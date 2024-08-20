package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.Bill;
import com.example.thetouringsuppliessystem.Model.User;
import com.example.thetouringsuppliessystem.Model.VendorStock;
import com.example.thetouringsuppliessystem.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final VendorRepository vendorRepository;

    private final VendorStockRepository vendorStockRepository;

    private final BillRepository billRepository;

    private int saveStock = 0;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user)
    {
        User u = userRepository.findUserById(id);
        if(u == null)
        {
            throw new ApiException("Not found");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setBalance(user.getBalance());
        u.setCity(user.getCity());
        u.setNumberOfPurchases(user.getNumberOfPurchases());
        userRepository.save(u);
    }
    public void deleteUser(Integer id)
    {
        if(userRepository.findUserById(id) == null)
        {
            throw new ApiException("Not found");
        }
        userRepository.deleteById(id);
    }
    public void buyProduct(Integer productID,Integer userID,int stock)
    {
        if(productRepository.findProductById(productID) == null)
        {
            throw new ApiException("productID is null");
        }
        if(userRepository.findUserById(userID) == null)
        {
            throw new ApiException("userID is null");
        }
        if(userRepository.findUserById(userID).getRole().equals("ADMIN"))
        {
            throw new ApiException("It is not CUSTOMER");
        }
        if(vendorStockRepository.findVendorStockByProductID(productID).getStock() < stock)
        {
            throw new ApiException("The stock is not enough");
        }
        if(userRepository.findUserById(userID).getCity().equals(vendorRepository.findVendorById(productRepository.findProductById(productID).getVendorID()).getCity())) {
            User u = userRepository.findUserById(userID);
            VendorStock vs = vendorStockRepository.findVendorStockByProductID(productID);
            Bill o = new Bill();
            if(u.getBalance() < (productRepository.findProductById(productID).getPrice() * stock))
            {
                throw new ApiException("The balance is less than the price");
            }
            u.setBalance(u.getBalance() - (productRepository.findProductById(productID).getPrice() * stock));
            u.setNumberOfPurchases(u.getNumberOfPurchases() + 1);
            vs.setStock(vs.getStock() - stock);
            o.setTypeOfOrder("BOUGHT");
            o.setStockOrder(stock);
            o.setTotal((productRepository.findProductById(productID).getPrice() * stock));
            o.setProductID(productID);
            o.setUserID(userID);
            userRepository.save(u);
            vendorStockRepository.save(vs);
            billRepository.save(o);
            saveStock = saveStock + stock;
        }
        else
        {
            User u = userRepository.findUserById(userID);
            VendorStock vs = vendorStockRepository.findVendorStockByProductID(productID);
            Bill o = new Bill();
            if(u.getBalance() < (productRepository.findProductById(productID).getPrice() * stock) + 50)
            {
                throw new ApiException("The balance is less than the price");
            }
            u.setBalance((u.getBalance() - (productRepository.findProductById(productID).getPrice() * stock)) - 50);
            u.setNumberOfPurchases(u.getNumberOfPurchases() + 1);
            vs.setStock(vs.getStock() - stock);
            o.setTypeOfOrder("BOUGHT");
            o.setStockOrder(stock);
            o.setTotal((productRepository.findProductById(productID).getPrice() * stock) + 50);
            o.setProductID(productID);
            o.setUserID(userID);
            userRepository.save(u);
            vendorStockRepository.save(vs);
            billRepository.save(o);
            saveStock = saveStock + stock;
        }
    }
    public void returnProduct(Integer productID,Integer userID,int stock)
    {
        if(productRepository.findProductById(productID) == null)
        {
            throw new ApiException("productID is null");
        }
        if(userRepository.findUserById(userID) == null)
        {
            throw new ApiException("userID is null");
        }
        if(userRepository.findUserById(userID).getRole().equals("ADMIN"))
        {
            throw new ApiException("It is not CUSTOMER");
        }
        if(stock > saveStock)
        {
            throw new ApiException("your order is rejected");
        }

        User u = userRepository.findUserById(userID);
        VendorStock vs = vendorStockRepository.findVendorStockByProductID(productID);
        u.setBalance(u.getBalance() + (productRepository.findProductById(productID).getPrice() * stock));
        u.setNumberOfPurchases(u.getNumberOfPurchases() - 1);
        vs.setStock(vs.getStock() + stock);
        userRepository.save(u);
        vendorStockRepository.save(vs);
        billRepository.deleteById(billRepository.findBillByProductIDAndUserID(productID, userID).getId());
        saveStock = saveStock - stock;
    }
    public void ReplaceProduct(Integer productIDBefore,Integer productIDAfter,Integer billID)
    {
        if(productRepository.findProductById(productIDBefore) == null)
        {
            throw new ApiException("productIDBefore is null");
        }
        if(productRepository.findProductById(productIDAfter) == null)
        {
            throw new ApiException("productIDAfter is null");
        }
        if(billRepository.findBillById(billID) == null)
        {
            throw new ApiException("billID is null");
        }
        if(userRepository.findUserById(billRepository.findBillById(billID).getId()).getRole().equals("ADMIN"))
        {
            throw new ApiException("It is not CUSTOMER");
        }
        if(productRepository.findProductById(productIDBefore).getVendorID() != productRepository.findProductById(productIDAfter).getVendorID())
        {
            throw new ApiException("It is not equal");
        }
        Bill b = billRepository.findBillById(billID);
        User u = userRepository.findUserById(billRepository.findBillById(billID).getUserID());
        u.setBalance(u.getBalance() + productRepository.findProductById(productIDBefore).getPrice());
        if(u.getBalance() < productRepository.findProductById(productIDAfter).getPrice())
        {
            throw new ApiException("It is wrong");
        }
        u.setBalance(u.getBalance() - productRepository.findProductById(productIDAfter).getPrice());
        b.setProductID(productIDAfter);
        userRepository.save(u);
        billRepository.save(b);
    }
    public void productRental(Integer productID,Integer userID,int stock)
    {
        if(productRepository.findProductById(productID) == null)
        {
            throw new ApiException("productID is null");
        }
        if(userRepository.findUserById(userID) == null)
        {
            throw new ApiException("userID is null");
        }
        if(userRepository.findUserById(userID).getRole().equals("ADMIN"))
        {
            throw new ApiException("It is not CUSTOMER");
        }
        if(!productRepository.findProductById(productID).isRent())
        {
            throw new ApiException("It is not rentable");
        }
        if(vendorStockRepository.findVendorStockByProductID(productID).getStock() < stock)
        {
            throw new ApiException("The stock is not enough");
        }

        if(userRepository.findUserById(userID).getCity().equals(vendorRepository.findVendorById(productRepository.findProductById(productID).getVendorID()).getCity())) {
            User u = userRepository.findUserById(userID);
            VendorStock vs = vendorStockRepository.findVendorStockByProductID(productID);
            Bill o = new Bill();
            if(u.getBalance() < (productRepository.findProductById(productID).getPrice() / 10) * stock)
            {
                throw new ApiException("The balance is less than the price");
            }
            u.setBalance(u.getBalance() - ((productRepository.findProductById(productID).getPrice() / 10) * stock));
            u.setNumberOfPurchases(u.getNumberOfPurchases() + 1);
            vs.setStock(vs.getStock() - stock);
            o.setTypeOfOrder("RENT");
            o.setStockOrder(stock);
            o.setTotal((productRepository.findProductById(productID).getPrice() / 10) * stock);
            o.setProductID(productID);
            o.setUserID(userID);
            userRepository.save(u);
            vendorStockRepository.save(vs);
            billRepository.save(o);
            saveStock = saveStock + stock;
        }
        else
        {
            User u = userRepository.findUserById(userID);
            VendorStock vs = vendorStockRepository.findVendorStockByProductID(productID);
            Bill o = new Bill();
            if(u.getBalance() < ((productRepository.findProductById(productID).getPrice() / 10) * stock) + 50)
            {
                throw new ApiException("The balance is less than the price");
            }
            u.setBalance(u.getBalance() - (((productRepository.findProductById(productID).getPrice() / 10) * stock) + 50));
            u.setNumberOfPurchases(u.getNumberOfPurchases() + 1);
            vs.setStock(vs.getStock() - stock);
            o.setTypeOfOrder("RENT");
            o.setStockOrder(stock);
            o.setTotal(((productRepository.findProductById(productID).getPrice() / 10) * stock) + 50);
            o.setProductID(productID);
            o.setUserID(userID);
            userRepository.save(u);
            vendorStockRepository.save(vs);
            billRepository.save(o);
            saveStock = saveStock + stock;
        }
    }
    public void doneRent(Integer billID)
    {
        if(billRepository.findBillById(billID) == null)
        {
            throw new ApiException("billID not found");
        }
        if(!billRepository.findBillById(billID).getTypeOfOrder().equals("RENT"))
        {
            throw new ApiException("It is not RENT");
        }
        Bill o = billRepository.findBillById(billID);
        VendorStock vs = vendorStockRepository.findVendorStockByProductID(o.getProductID());
        o.setTypeOfOrder("RENTEXPIRED");
        vs.setStock(vs.getStock() + o.getStockOrder());
        billRepository.save(o);
        vendorStockRepository.save(vs);
    }
    public void thePlus(Integer userID,int number,int plus)
    {
        if(userRepository.findUserById(userID) == null)
        {
            throw new ApiException("userID is null");
        }
        if(userRepository.findUserById(userID).getRole().equals("CUSTOMER"))
        {
            throw new ApiException("User is not ADMIN");
        }
        if(userRepository.toFindUserByNumberOfPurchases(number).isEmpty())
        {
            throw new ApiException("It is null");
        }
        for (int i = 0; i < userRepository.toFindUserByNumberOfPurchases(number).size(); i++) {
            User u = userRepository.toFindUserByNumberOfPurchases(number).get(i);
            u.setBalance(u.getBalance() + plus);
            userRepository.save(u);
        }
    }
}

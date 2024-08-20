package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Bill;
import com.example.thetouringsuppliessystem.Model.Product;
import com.example.thetouringsuppliessystem.Repository.BillRepository;
import com.example.thetouringsuppliessystem.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getBills()
    {
        return billRepository.findAll();
    }
    public void addBill(Bill bill)
    {
        billRepository.save(bill);
    }
    public void updateBill(Integer id, Bill bill)
    {
        if(billRepository.findBillById(id) == null)
        {
            throw new ApiException("not found");
        }
        Bill b = billRepository.findBillById(id);
        b.setTypeOfOrder(bill.getTypeOfOrder());
        b.setStockOrder(bill.getStockOrder());
        b.setTotal(bill.getTotal());
        b.setProductID(bill.getProductID());
        b.setUserID(bill.getUserID());
        billRepository.save(b);
    }
    public void deleteBill(Integer id)
    {
        if(billRepository.findBillById(id) == null)
        {
            throw new ApiException("not found");
        }
        billRepository.deleteById(id);
    }

    public String getCountAndSumTotal()
    {
        return "COUNT : " + billRepository.findCountBills() + " , Sum : " + billRepository.findSumBills();
    }

    public List<Bill> getBillsByTypeOfOrder(String typeOfOrder)
    {
        if(billRepository.findBillByTypeOfOrder(typeOfOrder).isEmpty())
        {
            throw new ApiException("not found");
        }
        return billRepository.findBillByTypeOfOrder(typeOfOrder);
    }
    public void deleteAllByTypeOfOrder(String typeOfOrder)
    {
        if(billRepository.findBillByTypeOfOrder(typeOfOrder).isEmpty())
        {
            throw new ApiException("not found");
        }
        for (int i = 0; i < billRepository.findBillByTypeOfOrder(typeOfOrder).size(); i++) {
            billRepository.deleteById(billRepository.findBillByTypeOfOrder(typeOfOrder).get(i).getId());
        }
    }
}

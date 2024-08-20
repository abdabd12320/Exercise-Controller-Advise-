package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.Product;
import com.example.thetouringsuppliessystem.Repository.BrandRepository;
import com.example.thetouringsuppliessystem.Repository.CategoryRepository;
import com.example.thetouringsuppliessystem.Repository.BillRepository;
import com.example.thetouringsuppliessystem.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }
    public void addProduct(Product product)
    {
        productRepository.save(product);
    }
    public void updateProduct(Integer id,Product product)
    {
        Product p = productRepository.findProductById(id);
        if(p == null)
        {
            throw new ApiException("Not found");
        }
        p.setName(product.getName());
        p.setDetails(product.getDetails());
        p.setPrice(product.getPrice());
        p.setRent(product.isRent());
        p.setBrandID(product.getBrandID());
        p.setCategoryID(product.getCategoryID());
        p.setVendorID(product.getVendorID());
        productRepository.save(p);
    }
    public void deleteProduct(Integer id)
    {
        if(productRepository.findProductById(id) == null)
        {
            throw new ApiException("Not found");
        }
        productRepository.deleteById(id);
    }
    public List<Product> getProductsByCategory(String category)
    {
        if(categoryRepository.findCategoryByName(category) == null)
        {
            throw new ApiException("Category is null");
        }
        return productRepository.findProductByCategoryID(categoryRepository.findCategoryByName(category).getId());
    }
    public List<Product> getProductsByBrand(String brand)
    {
        if(brandRepository.findBrandByName(brand) == null)
        {
            throw new ApiException("Brand is null");
        }
        return productRepository.findProductByBrandID(brandRepository.findBrandByName(brand).getId());
    }
    public List<Product> getProductsByName(String name)
    {
        return productRepository.findProductByNameStartsWith(name);
    }
    public List<Product> getProductByPrice(int min,int max)
    {
        return productRepository.findProductByPriceBetween(min, max);
    }
    public void deleteProductByBrand(Integer id)
    {
        if(productRepository.findProductByBrandID(id) == null)
        {
            throw new ApiException("It is null");
        }
        for (int i = 0; i < productRepository.findProductByBrandID(id).size(); i++) {
            deleteProduct(productRepository.findProductByBrandID(id).get(i).getId());
        }
        brandRepository.deleteById(id);
    }
    public void deleteProductByCategory(Integer id)
    {
        if(productRepository.findProductByCategoryID(id) == null)
        {
            throw new ApiException("It is null");
        }
        for (int i = 0; i < productRepository.findProductByCategoryID(id).size(); i++) {
            deleteProduct(productRepository.findProductByCategoryID(id).get(i).getId());
        }
        categoryRepository.deleteById(id);
    }
}

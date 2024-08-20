package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.VendorStock;
import com.example.thetouringsuppliessystem.Repository.VendorStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorStockService {

    private final VendorStockRepository vendorStockRepository;

    public List<VendorStock> getVendorsStock()
    {
        return vendorStockRepository.findAll();
    }
    public void addVendorStock(VendorStock vendorStock)
    {
        vendorStockRepository.save(vendorStock);
    }
    public void updateVendorStock(Integer id,VendorStock vendorStock)
    {
        VendorStock v = vendorStockRepository.findVendorStockById(id);
        if(v == null)
        {
            throw new ApiException("Not found");
        }
        v.setStock(vendorStock.getStock());
        v.setVendorID(vendorStock.getVendorID());
        v.setProductID(vendorStock.getProductID());
        vendorStockRepository.save(v);
    }
    public void deleteVendorStock(Integer id)
    {
        if(vendorStockRepository.findVendorStockById(id) == null)
        {
            throw new ApiException("Not found");
        }
        vendorStockRepository.deleteById(id);
    }
}

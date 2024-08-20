package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.Vendor;
import com.example.thetouringsuppliessystem.Repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public List<Vendor> getVendors()
    {
        return vendorRepository.findAll();
    }
    public void addVendor(Vendor vendor)
    {
        vendorRepository.save(vendor);
    }
    public void updateVendor(Integer id,Vendor vendor)
    {
        Vendor v = vendorRepository.findVendorById(id);
        if(v == null)
        {
            throw new ApiException("Not found");
        }
        v.setName(vendor.getName());
        v.setEmail(vendor.getEmail());
        v.setPhoneNumber(vendor.getPhoneNumber());
        v.setCity(vendor.getCity());
        vendorRepository.save(v);
    }
    public void deleteVendor(Integer id)
    {
        if(vendorRepository.findVendorById(id) == null)
        {
            throw new ApiException("Not found");
        }
        vendorRepository.deleteById(id);
    }
}

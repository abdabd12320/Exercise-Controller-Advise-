package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.Brand;
import com.example.thetouringsuppliessystem.Repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getBrands()
    {
        return brandRepository.findAll();
    }
    public void addBrand(Brand brand)
    {
        brandRepository.save(brand);
    }
    public void updateBrand(Integer id,Brand brand)
    {
        Brand b = brandRepository.findBrandById(id);

        if(b == null)
        {
            throw new ApiException("Not found");
        }

        b.setName(brand.getName());
        b.setMadeIn(brand.getMadeIn());
        brandRepository.save(b);
    }
    public void deleteBrand(Integer id)
    {
        if(brandRepository.findBrandById(id) == null)
        {
            throw new ApiException("Not found");
        }
        brandRepository.deleteById(id);
    }
}

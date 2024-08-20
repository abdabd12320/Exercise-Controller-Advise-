package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Brand;
import com.example.thetouringsuppliessystem.Service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/get")
    public ResponseEntity getBrands()
    {
        return ResponseEntity.status(200).body(brandService.getBrands());
    }
    @PostMapping("/add")
    public ResponseEntity addBrand(@Valid@RequestBody Brand brand)
    {
        brandService.addBrand(brand);
        return ResponseEntity.status(200).body(new ApiResponse("Brand added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBrand(@PathVariable Integer id,@Valid@RequestBody Brand brand)
    {
        brandService.updateBrand(id, brand);
        return ResponseEntity.status(200).body(new ApiResponse("Brand updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBrand(@PathVariable Integer id)
    {
        brandService.deleteBrand(id);
        return ResponseEntity.status(200).body(new ApiResponse("Brand deleted"));
    }
}

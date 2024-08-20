package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Vendor;
import com.example.thetouringsuppliessystem.Service.VendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendor")
public class VendorController {

    private final VendorService vendorService;

    @GetMapping("/get")
    public ResponseEntity getVendors()
    {
        return ResponseEntity.status(200).body(vendorService.getVendors());
    }
    @PostMapping("/add")
    public ResponseEntity addVendor(@Valid@RequestBody Vendor vendor)
    {
        vendorService.addVendor(vendor);
        return ResponseEntity.status(200).body(new ApiResponse("Vendor added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateVendor(@PathVariable Integer id,@Valid@RequestBody Vendor vendor)
    {
        vendorService.updateVendor(id, vendor);
        return ResponseEntity.status(200).body(new ApiResponse("Vendor updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteVendor(@PathVariable Integer id)
    {
        vendorService.deleteVendor(id);
        return ResponseEntity.status(200).body(new ApiResponse("Vendor deleted"));
    }
}

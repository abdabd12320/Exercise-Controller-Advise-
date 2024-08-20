package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.VendorStock;
import com.example.thetouringsuppliessystem.Service.VendorStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendor-stock")
public class VendorStockController {

    private final VendorStockService vendorStockService;

    @GetMapping("/get")
    public ResponseEntity getVendorStocks()
    {
        return ResponseEntity.status(200).body(vendorStockService.getVendorsStock());
    }
    @PostMapping("/add")
    public ResponseEntity addVendorStock(@Valid@RequestBody VendorStock vendorStock)
    {
        vendorStockService.addVendorStock(vendorStock);
        return ResponseEntity.status(200).body(new ApiResponse("VendorService added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateVendorStock(@PathVariable Integer id,@Valid@RequestBody VendorStock vendorStock)
    {
        vendorStockService.updateVendorStock(id, vendorStock);
        return ResponseEntity.status(200).body(new ApiResponse("VendorService updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteVendorStock(@PathVariable Integer id)
    {
        vendorStockService.deleteVendorStock(id);
        return ResponseEntity.status(200).body(new ApiResponse("VendorService deleted"));
    }
}

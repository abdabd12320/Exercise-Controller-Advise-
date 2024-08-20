package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Bill;
import com.example.thetouringsuppliessystem.Service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class BillController {

    private final BillService billService;

    @GetMapping("/get")
    public ResponseEntity getBills()
    {
        return ResponseEntity.status(200).body(billService.getBills());
    }
    @PostMapping("/add")
    public ResponseEntity addBill(@Valid@RequestBody Bill bill)
    {
        billService.addBill(bill);
        return ResponseEntity.status(200).body(new ApiResponse("Bill added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid@RequestBody Bill bill)
    {
        billService.updateBill(id, bill);
        return ResponseEntity.status(200).body(new ApiResponse("Bill updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBill(@PathVariable Integer id)
    {
        billService.deleteBill(id);
        return ResponseEntity.status(200).body(new ApiResponse("Bill deleted"));
    }
    @GetMapping("/get-count-and-sum-total")
    public ResponseEntity getCountAndSumTotal()
    {
        return ResponseEntity.status(200).body(new ApiResponse(billService.getCountAndSumTotal()));
    }
    @GetMapping("/get-bills-by-type-of-order/{typeoforder}")
    public ResponseEntity getBillsByTypeOfOrder(@PathVariable String typeoforder)
    {
        return ResponseEntity.status(200).body(new ApiResponse(billService.getBillsByTypeOfOrder(typeoforder).toString()));
    }
    @DeleteMapping("/delete-by-type-of-order/{typeoforder}")
    public ResponseEntity deleteAllByTypeOfOrder(@PathVariable String typeoforder)
    {
        billService.deleteAllByTypeOfOrder(typeoforder);
        return ResponseEntity.status(200).body(new ApiResponse("TypeOfOrder deleted"));
    }
}

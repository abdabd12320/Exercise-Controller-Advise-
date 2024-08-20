package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Product;
import com.example.thetouringsuppliessystem.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProducts()
    {
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid@RequestBody Product product)
    {
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("Product added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@Valid@RequestBody Product product)
    {
        productService.updateProduct(id, product);
        return ResponseEntity.status(200).body(new ApiResponse("Product updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted"));
    }
    @GetMapping("/get-by-brand/{name}")
    public ResponseEntity getByBrand(@PathVariable String name)
    {
        return ResponseEntity.status(200).body(productService.getProductsByBrand(name));
    }
    @GetMapping("/get-by-category/{name}")
    public ResponseEntity getByCategory(@PathVariable String name)
    {
        return ResponseEntity.status(200).body(productService.getProductsByCategory(name));
    }
    @GetMapping("/get-product-by-name/{name}")
    public ResponseEntity getProductByName(@PathVariable String name)
    {
        return ResponseEntity.status(200).body(productService.getProductsByName(name));
    }
    @GetMapping("/get-by-price/{min}/{max}")
    public ResponseEntity getByPrice(@PathVariable int min,@PathVariable int max)
    {
        return ResponseEntity.status(200).body(productService.getProductByPrice(min, max));
    }
    @DeleteMapping("/delete-product-by-brand/{id}")
    public ResponseEntity deleteProductByBrand(@PathVariable Integer id)
    {
        productService.deleteProductByBrand(id);
        return ResponseEntity.status(200).body(new ApiResponse("Brand and Products deleted"));
    }
    @DeleteMapping("/delete-product-by-category/{id}")
    public ResponseEntity deleteProductByCategory(@PathVariable Integer id)
    {
        productService.deleteProductByCategory(id);
        return ResponseEntity.status(200).body(new ApiResponse("Category and Products deleted"));
    }
}

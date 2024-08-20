package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.Category;
import com.example.thetouringsuppliessystem.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategories()
    {
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid@RequestBody Category category)
    {
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @Valid@RequestBody Category category)
    {
        categoryService.updateCategory(id,category);
        return ResponseEntity.status(200).body(new ApiResponse("Category updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted"));
    }
}

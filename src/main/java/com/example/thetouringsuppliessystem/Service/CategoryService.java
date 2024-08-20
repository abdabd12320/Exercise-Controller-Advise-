package com.example.thetouringsuppliessystem.Service;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Model.Category;
import com.example.thetouringsuppliessystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories()
    {
        return categoryRepository.findAll();
    }
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public void updateCategory(Integer id,Category category)
    {
        Category c = categoryRepository.findCategoryById(id);
        if(c == null)
        {
            throw new ApiException("Not found");
        }
        c.setName(category.getName());
        categoryRepository.save(c);
    }
    public void deleteCategory(Integer id)
    {
        if(categoryRepository.findCategoryById(id) == null)
        {
            throw new ApiException("Not found");
        }
        categoryRepository.deleteById(id);
    }
}

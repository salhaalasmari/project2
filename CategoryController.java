package com.example.week2day2.controller.Project2;


import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Project2.CategoryModel;
import com.example.week2day2.Model.Project2.ProductModel;
import com.example.week2day2.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Category")
public class CategoryController {

   private  final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/Category")
    public ResponseEntity getCategory(){
        ArrayList<CategoryModel> Category = categoryService.getCategory();
        return ResponseEntity.status(200).body(Category);
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid CategoryModel category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/Category/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid CategoryModel category
            ,@PathVariable int id,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        boolean isUpdated = categoryService.updateCategory(id, category);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Category updated successfully!" , 200));
        }
        return ResponseEntity.status(400).body(new ApiResponse("there are failed in ID !", 400));
    }

    @DeleteMapping("/Category/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index){
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("category deleted !",200));
    }

}

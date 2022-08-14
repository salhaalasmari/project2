package com.example.week2day2.Service;

import com.example.week2day2.Model.Project2.CategoryModel;
import com.example.week2day2.Model.Project2.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    private ArrayList<CategoryModel> CategoryList=new ArrayList<>();

    public ArrayList<CategoryModel> getCategory(){
        return CategoryList;
    }

    public void addCategory(CategoryModel myCategory){
        CategoryList.add(myCategory);
    }
    

    public boolean updateCategory(Integer id, CategoryModel myCategory) {
        for (int i = 0; i <CategoryList.size(); i++) {
            if(CategoryList.get(i).getId().equals(id)){
                CategoryList.set(i,myCategory);
                return true;
            }
        }
return false;
    }
    public void deleteCategory(int index) {
        CategoryList.remove(index);
    }
}

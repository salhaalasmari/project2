package com.example.week2day2.Model.Project2;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class ProductModel {
    @NotNull(message = "Id can't be null")
    @Min(value = 3,message = "ID have to be 3 character long ")
    private Integer ProductID;
    @NotEmpty(message = "Name can't be empty")
    @Size(min = 3,message = "Name have to be 3 length long")
    private String Name;
    @NotNull(message = "Price can't be null")
    @Positive(message = "Price must be positive number")
    private  Integer price;
    @NotNull(message = "category ID can't be null")
    @Min(value = 3,message = "category ID have to be 3 character long ")
    private Integer categoryID;

}

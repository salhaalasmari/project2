package com.example.week2day2.Model.Project2;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantModel {
    //id ( must not be empty , have to be 3 character long ).
    //name ( must not be empty , have to be 3 length long ).
    @NotNull(message = "Id can't be null")
    @Min(value = 3,message = "ID have to be 3 character long ")
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    @Size(min = 3,message = "Name have to be 3 length long")
    private String Name;
}

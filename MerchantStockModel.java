package com.example.week2day2.Model.Project2;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class MerchantStockModel {

    //id ( must not be empty , have to be 3 character long ).
    //productid ( must not be empty , have to be 3 character long ).
    //merchantid ( must not be empty , have to be 3 length long ).
    //stock ( must not be empty , have to be more than 10 at start ).
    @NotNull(message = "Id can't be null")
    @Min(value = 3,message = "ID have to be 3 character long ")
    private Integer MerchantStockModelID;
    @NotNull(message = "product id can't be null")
    @Min(value = 3,message = "product id have to be 3 character long ")
    private Integer productID;
    @NotNull(message = "merchant id can't be null")
    @Min(value = 3,message = "merchant id have to be 3 character long ")
    private Integer merchantid;
    @NotNull(message = "Stock  must not be empty ")
    @Size(min = 11 , max = 100 , message = "have to be more than 10 at start")
    private  Integer Stock;


}

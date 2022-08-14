package com.example.week2day2.controller.Project2;

import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Project2.MerchantStockModel;
import com.example.week2day2.Model.Project2.ProductModel;
import com.example.week2day2.Service.MerchantStockService;
import com.example.week2day2.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/MerchantStock")

public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    public MerchantStockController(MerchantStockService merchantStockService) {
        this.merchantStockService = merchantStockService;
    }

    @GetMapping("/Stocks")
    public ResponseEntity getMerchantStock(){
        ArrayList<MerchantStockModel> MerchantStock = merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(MerchantStock);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStockModel MerchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }

        boolean isAdd=merchantStockService.addMerchantStock(MerchantStock);

        if (isAdd){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock added successfully!",200));
        }
        return ResponseEntity.status(400).body(new ApiResponse("there is error either Product Id or Merchant Id ",400));

    }

    @PutMapping("/MerchantStock(/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStockModel MerchantStock
            ,@PathVariable Integer id,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));

        }

     boolean isUpdate = merchantStockService.updateMerchantStock(id , MerchantStock);
        if(isUpdate){

            return ResponseEntity.status(200).body( new ApiResponse("product updated !",200));
        }
        return ResponseEntity.status(400).body( new ApiResponse("product  not updated !",400));
    }



    @PutMapping("/AddProductToMerchantStock/{productid}/{merchantid}/{Stock}")
    public  ResponseEntity addProduct(@PathVariable Integer productid , @PathVariable Integer merchantid , @PathVariable
    Integer Stock){
        boolean isValid = merchantStockService.AddProductToMerchantStock(productid , merchantid , Stock);

        if(isValid){
            return ResponseEntity.status(200).body(new ApiResponse("product added to MerchantStock successfully",200));
        }
        return ResponseEntity.status(400).body(new ApiResponse("error in  merchantId ,productId  ",400));


    }



}

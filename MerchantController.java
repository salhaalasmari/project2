package com.example.week2day2.controller.Project2;

import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Project2.CategoryModel;
import com.example.week2day2.Model.Project2.MerchantModel;
import com.example.week2day2.Service.MerchantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Merchant")
public class MerchantController {



    private  final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @GetMapping("/Merchant")
    public ResponseEntity getMerchant(){
        ArrayList<MerchantModel> merchant =  merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchant);
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid MerchantModel merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body( new ApiResponse("New merchant added !",201));
    }


    @PutMapping("/Merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid MerchantModel merchant
            ,@PathVariable Integer id,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
      boolean isUpdate=merchantService.updateMerchant(id , merchant);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("merchant updateded  !",200));
        }
        return ResponseEntity.status(400).body(new ApiResponse("merchant not update , be careful about id  !",400));
    }
    @DeleteMapping("/merchant/{index}")
    public ResponseEntity deletemerchant(@PathVariable int index){
        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted !",200));
    }

}

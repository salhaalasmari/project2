package com.example.week2day2.controller.Project2;

import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Project2.ProductModel;
import com.example.week2day2.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
public class productController {

    private final ProductService productService;

    public productController(ProductService productService){

        this.productService=productService;
    }
    @GetMapping("/products")
    public ResponseEntity getProducts(){
        ArrayList<ProductModel> product = productService.getProduct();
        return ResponseEntity.status(200).body(product);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid ProductModel product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        boolean isAdd= productService.addProduct(product);
        if(isAdd){
            return ResponseEntity.status(201).body( new ApiResponse("New product added !",201));
        }

        return ResponseEntity.status(201).body( new ApiResponse("we do not found properties category gor this product !",201));

    }

    @PutMapping("/products/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid ProductModel product
    ,@PathVariable int id,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
 }
        boolean isUpdate = productService.updateProduct(id , product);
if(isUpdate){
    return ResponseEntity.status(201).body( new ApiResponse("product updated !",201));
}
        return ResponseEntity.status(201).body( new ApiResponse("error in id  !",201));
    }
    @DeleteMapping("/products/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        productService.deleteProduct(index);
        return ResponseEntity.status(200).body(new ApiResponse("product deleted !",200));
    }

    @PutMapping("/buy/{Userid}/{productid}/{merchantid}")
    public  ResponseEntity Buy(@PathVariable Integer Userid  , @PathVariable  Integer productid , @PathVariable int merchantid ){
        Integer isValid = productService.buy(Userid , productid , merchantid);
        if(isValid.equals(-1)){
            return ResponseEntity.status(400).body(new ApiResponse("the merchant have the product in stock \n bad request",400));

        } else if (isValid.equals(-2)) {
            return ResponseEntity.status(400).body(new ApiResponse(" balance is less than the product price \n bad request",400));
        } else if (isValid==0) {
            return ResponseEntity.status(400).body(new ApiResponse("user can buy a product directly \n good request",400));
        }
        return ResponseEntity.status(400).body(new ApiResponse("error in user id \n bad request",400));
    }


}
///////

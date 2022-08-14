package com.example.week2day2.controller.Project2;


import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Project2.MerchantModel;
import com.example.week2day2.Model.Project2.UserModel;
import com.example.week2day2.Service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/u")
    public ResponseEntity getMerchant(){
        ArrayList<UserModel> u = userService.getUser();
        return ResponseEntity.status(200).body(u);
    }
    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid UserModel u, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.addUserModel(u);
        return ResponseEntity.status(201).body( new ApiResponse("New Users added !",201));
    }


    @PutMapping("/u/{index}")
    public ResponseEntity updateUsers(@RequestBody @Valid UserModel u
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.updateUserModel(index , u);

        return ResponseEntity.status(201).body( new ApiResponse("Users updated !",201));
    }
    @DeleteMapping("/u/{index}")
    public ResponseEntity deleteUsers(@PathVariable int index){
        userService.deleteUserModel(index);
        return ResponseEntity.status(200).body(new ApiResponse("Users deleted !",200));
    }




}

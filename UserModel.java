package com.example.week2day2.Model.Project2;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
@AllArgsConstructor @Data
public class UserModel {

    //id ( must not be empty , have to be 3 character long ).
    //username ( must not be empty , have to be 5 length long ).
    //password ( must not be empty , have to be 6 length long , must have characters and digits ).
    //email ( must not be empty , must be valid email ).
    //role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
    //balance ( must not be empty , have to be positive ).
    @NotNull(message = "Id can't be null")
    @Min(value = 3,message = "ID have to be 3 character long ")
    private Integer id;
    @NotEmpty(message = "username can't be empty")
    @Size(min = 5 , max = 30 , message = "username have to be 5 length long")
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6,max = 15,message = "password must be more than 6 char and less than 15 char")
     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "please enter strong password")
    private String password;
    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(Admin|Customer)",message = "Role must be in admin or Customer only")
    private String role;
    @NotEmpty(message = "email can't be empty")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotNull(message = "balance must not be empty")
    @Positive(message = "balance must be positive number")
    private Integer balance;
}

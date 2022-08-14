package com.example.week2day2.Service;

import com.example.week2day2.Model.Project2.MerchantStockModel;
import com.example.week2day2.Model.Project2.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private ArrayList<UserModel> UserServiceList=new ArrayList<>();

    public ArrayList<UserModel> getUser(){
        return UserServiceList;
    }

    public void addUserModel(UserModel myUserService){
        UserServiceList.add(myUserService);
    }
    public void updateUserModel(int index, UserModel myUserService) {
        UserServiceList.set(index,myUserService);
    }
    public void deleteUserModel(int index) {
        UserServiceList.remove(index);
    }
}

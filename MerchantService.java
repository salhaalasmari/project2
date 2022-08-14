package com.example.week2day2.Service;

import com.example.week2day2.Model.Project2.CategoryModel;
import com.example.week2day2.Model.Project2.MerchantModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    private ArrayList<MerchantModel> MerchantList=new ArrayList<>();

    public ArrayList<MerchantModel> getMerchant(){
        return MerchantList;
    }

    public void addMerchant(MerchantModel myMerchant){
        MerchantList.add(myMerchant);
    }
    public Boolean updateMerchant(Integer id, MerchantModel myMerchant) {
        for (int i = 0; i < MerchantList.size(); i++) {
            if(MerchantList.get(i).getId().equals(i)){
                MerchantList.set(i,myMerchant);
                return true;
            }

        }
     return  false;
    }
    public void deleteMerchant(int index) {
        MerchantList.remove(index);
    }
}


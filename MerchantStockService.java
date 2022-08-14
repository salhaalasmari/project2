package com.example.week2day2.Service;

import com.example.week2day2.Model.Project2.MerchantModel;
import com.example.week2day2.Model.Project2.MerchantStockModel;
import com.example.week2day2.Model.Project2.ProductModel;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Service
public class MerchantStockService {


    private ArrayList<MerchantStockModel> MerchantStockList=new ArrayList<>();

    private  final MerchantService merchantService;
    private final ProductService productService;

    public MerchantStockService(ProductService productService , MerchantService merchantService ){
        this.merchantService=merchantService;
        this.productService=productService;
    }
    public ArrayList<MerchantStockModel> getMerchantStock(){
        return MerchantStockList;
    }

    public boolean addMerchantStock(MerchantStockModel myMerchantStock){
        ArrayList<MerchantModel> merchant = merchantService.getMerchant();
        ArrayList<ProductModel> product = productService.getProduct();
        for (int i = 0; i < merchant.size(); i++) {
            if(merchant.get(i).getId().equals(myMerchantStock.getMerchantid())){
                for (int j = 0; j <product.size() ; j++) {

                    if(product.get(j).getProductID().equals(myMerchantStock.getProductID())){
                        MerchantStockList.add(myMerchantStock);
                        return true;
                    }

                }

            }

        }
        return  false;
    }
    public boolean updateMerchantStock(Integer id, MerchantStockModel myMerchantStock) {
        for (int i = 0; i < MerchantStockList.size(); i++) {
            if(MerchantStockList.get(i).getMerchantStockModelID().equals(id)){

                MerchantStockList.set(i,myMerchantStock);
                return true;
            }

        }
        return  false;
    }
    public void deleteMerchantStock(int index) {
        MerchantStockList.remove(index);
    }

    //Create endpoint where user can add product to a merchantStock
    //this endpoint should accept a productid and merchantid and stock

    public  boolean AddProductToMerchantStock(Integer productid , Integer merchantid , Integer Stock){

        for (int i = 0; i < MerchantStockList.size(); i++) {
            if(MerchantStockList.get(i).getProductID()==productid &&
            MerchantStockList.get(i).getMerchantid()==merchantid)
          //  if(MerchantStockList.get(i).getProductid()==productid &&
            //       MerchantStockList.get(i).getMerchantid()==merchantid )

           //     MerchantStockList.get(i).getStock();
            MerchantStockList.get(i).setStock( MerchantStockList.get(i).getStock()+Stock);

            System.out.println("This product added to stock ");
               return  true;
            }

        return  false;
  }
}

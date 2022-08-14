package com.example.week2day2.Service;

import com.example.week2day2.Model.Project2.CategoryModel;
import com.example.week2day2.Model.Project2.MerchantStockModel;
import com.example.week2day2.Model.Project2.ProductModel;
import com.example.week2day2.Model.Project2.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private ArrayList<ProductModel> ProductList=new ArrayList<>();

private  final CategoryService categoryService;
private  final  MerchantStockService merchantStockService;
private  final  UserService userService;

    public ProductService(MerchantStockService merchantStockService , UserService userService , CategoryService categoryService) {

        this.merchantStockService = merchantStockService;
        this.userService=userService;
        this.categoryService=categoryService;
    }

    public ArrayList<ProductModel> getProduct(){
        return ProductList;
    }

    public Boolean addProduct(ProductModel myProduct){
        ArrayList<CategoryModel> myCategory = categoryService.getCategory();
        for (int i = 0; i < myCategory.size(); i++) {
            if(myCategory.get(i).getId().equals(myProduct.getCategoryID())){
                ProductList.add(myProduct);
                return  true;
            }
        }
     return  false;
    }
    public boolean updateProduct(Integer id, ProductModel myProduct) {
        for (int i = 0; i <ProductList.size() ; i++) {
            if(ProductList.get(i).getProductID().equals(id)) {
                ProductList.set(i,myProduct);
                return  true;
            }
        }
      return  false;
    }
    public void deleteProduct(int index) {
        ProductList.remove(index);
    }
//Create endpoint where user can buy a product directly
//this endpoint should accept userid , product id , merchantid.
//check if all the given id is valid or not
//check if the merchant have the product in stock or return bad request.
//reduce the stock from the MerchantStock.
//deducted the price of the product from the user balance.
//if balance is less than the product price return bad request.
  //

public int buy(Integer Userid , Integer productid , int merchantid ){
        int price=0;
     ArrayList<UserModel> UsertList = userService.getUser();
    for (int i = 0; i < UsertList.size(); i++) {
        UserModel user = UsertList.get(i);

        if(user.getId().equals(Userid)){

            ArrayList<MerchantStockModel> MS =merchantStockService.getMerchantStock();
            for (int j = 0; j < MS.size(); j++) {
                MerchantStockModel ms = MS.get(j);
                if(ms.getMerchantid().equals(merchantid) && ms.getProductID().equals(productid));

                // check stock valid
                if(ms.getStock() == 0){
                    return -1; // not found
                }
                // get product price
                for (int k = 0; k <ProductList.size() ; k++) {
                    if(ProductList.get(k).getProductID().equals(productid)){
                    price= ProductList.get(k).getPrice();
                    }
                }
                // check the balance
                if(user.getBalance() <price){
                    return -2; //
                }
               ms.setStock(ms.getStock()-1);
                user.setBalance(user.getBalance()-price);
                return 0;

            }



        }


    }
return 2;


}




}

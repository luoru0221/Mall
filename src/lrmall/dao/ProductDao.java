package lrmall.dao;

import lrmall.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductDao {
    Product queryProductById(int id);//根据商品Id查询商品
    int addProduct(Product product);//添加商品
    HashMap<String, ArrayList<String>> queryNorm(int id);//根据商品Id查询商品规格
    ArrayList<Product> queryProductByType(int type); //根据商品类别查询商品
    void addTips(String tipName,String tip);    //添加商品规格
    ArrayList<Product> queryProductByStore(int storeId); //查询店铺的全部商品
    ArrayList<Product> queryAllProducts();  //查询所有商品
}

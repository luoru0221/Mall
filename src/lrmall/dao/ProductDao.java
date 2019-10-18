package lrmall.dao;

import lrmall.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductDao {
    Product queryProductById(int id);//根据商品Id查询商品
    int addProduct(Product product);//添加商品
    ArrayList<Product> queryProductByType(int type); //根据商品类别查询商品
    ArrayList<Product> queryProductByStore(String store); //查询店铺的全部商品
    ArrayList<Product> queryAllProducts();  //查询所有商品
    int deleteProduct(int productId);

    int updateProduct(Product product);

    ArrayList<Product> selectLikeProduct(String keyword);   //关键字模糊搜索商品

    ArrayList<Product> selectLikeProductLimit(String keyword,int page,int number); //关键字加搜索条数限制搜索

    ArrayList<Product> selectTypeProductLimit(int typeId,int page,int number);  //分类查找每一页的id
}

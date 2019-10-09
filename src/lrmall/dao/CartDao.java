package lrmall.dao;

import lrmall.bean.Cart;
import lrmall.bean.Product;

import java.util.ArrayList;

public interface CartDao {
    ArrayList<Product> selectCartByUserId(String uid);//根据用户账号查询购物车
    int selectCartNumber(String uid);//查询购物车数量
    int selectProductNumber(Cart cart); //查询购物车中某一商品的数量
    boolean addCart(Cart cart); //添加购物车
    void deleteCart(Cart cart); //删除购物车
}

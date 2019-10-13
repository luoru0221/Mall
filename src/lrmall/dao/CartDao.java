package lrmall.dao;

import lrmall.bean.Cart;
import lrmall.bean.Product;

import java.util.ArrayList;

public interface CartDao {
    /**
     * 根据用户账号查询购物车
     * @time 2019年10月13日19:10:25
     * @param uid 待查询的用户的购物车
     * @return Cart对象的ArrayLIst集合
     */
    ArrayList<Product> selectCartByUserId(String uid);//根据用户账号查询购物车
    int selectCartNumber(String uid);//查询购物车数量
    int selectProductNumber(Cart cart); //查询购物车中某一商品的数量
    boolean addCart(Cart cart); //添加购物车
    void deleteCart(Cart cart); //删除购物车

    /**
     * 更新购物车
     * @param cart 新的购物车对象
     * @return 影响的数据条数
     */
    int updateCart(Cart cart);

    /**
     * 查询即将生成订单的购物车
     * @param uid 用户Id
     * @return Product的ArrayList结果集
     */
    ArrayList<Product> selectToOrderCart(String uid);

    /**
     * 刷新购物车信息
     * @param uid 待刷新的购物车的用户
     */
    void refreshCart(String uid);
}

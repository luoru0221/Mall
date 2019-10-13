package lrmall.dao;

import lrmall.bean.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  @author: Luoru
 *  @Date: 2019/10/13 19:08
 *  @Description: OrderItem数据库操作
 */
public interface OrderItemDao {

    /**
     * 创建订单项
     * @time 2019年10月13日11:56:42
     * @param orderItem OrderItemd对象
     * @return 影响的数据条数
     */
    int createOrderItem(OrderItem orderItem);

    /**
     * 删除订单项
     * @time 2019年10月13日19:07:54
     * @param orderItem 待删除的OrderItem对象
     * @return 影响的暑假条数
     */
    int delateOrderItem(OrderItem orderItem);

    /**
     * 修改订单项
     * @time 2019年10月13日19:08:35
     * @param orderItem 待修改的OrderList对象
     * @return 影响的数据条数
     */
    int updateOrderItem(OrderItem orderItem);

    /**
     * 查询某一用户的所有订单
     * @time 2019年10月13日20:57:58
     * @param uid 需查询的用户Id
     * @return 该用户的订单HashMap<String, ArrayList<OrderItem>>集合
     */
    HashMap<String, ArrayList<OrderItem>> selectAllOrdersByUserId(String uid);

}

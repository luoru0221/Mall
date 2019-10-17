package lrmall.dao;

import lrmall.bean.Order;

import java.util.HashMap;
import java.util.Set;

public interface OrderDao {

    /**
     * 创建订单
     *
     * @param order Order对象
     * @return 影响的数据条数
     * @time 2019年10月13日11:31:20
     */
    int createOrder(Order order);

    int deleteOrder(String orderId);

    HashMap<String,Order> selectInformation(String userId);

}

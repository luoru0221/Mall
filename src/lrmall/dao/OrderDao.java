package lrmall.dao;

import lrmall.bean.Order;

public interface OrderDao {

    /**
     * 创建订单
     * @time 2019年10月13日11:31:20
     * @param order Order对象
     * @return 影响的数据条数
     */
    int createOrder(Order order);

}

package lrmall.dao.impl;

import lrmall.bean.Order;
import lrmall.dao.OrderDao;
import lrmall.utils.DbUtil;

public class OrderDaoImpl extends DbUtil implements OrderDao {
    @Override
    public int createOrder(Order order) {
        String sql = "INSERT INTO orders (id,uid,price,type) VALUES (?,?,?,?)";
        Object[] params = {order.getId(),order.getUid(),order.getPrice(),order.getType()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }
}

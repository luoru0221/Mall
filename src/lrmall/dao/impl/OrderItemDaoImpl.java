package lrmall.dao.impl;

import lrmall.bean.OrderItem;
import lrmall.bean.Product;
import lrmall.dao.OrderItemDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderItemDaoImpl extends DbUtil implements OrderItemDao {

    @Override
    public int createOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO orderitem (oid,pid,number,type) values(?,?,?,?)";
        Object[] params = {orderItem.getOid(), orderItem.getPid(), orderItem.getNumber(), orderItem.getType()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int delateOrderItem(OrderItem orderItem) {
        return 0;
    }

    @Override
    public int updateOrderItem(OrderItem orderItem) {
        return 0;
    }

    @Override
    public HashMap<String, ArrayList<OrderItem>> selectAllOrdersByUserId(String uid) {
        HashMap<String, ArrayList<OrderItem>> allOrders = new HashMap<>();
        ArrayList<OrderItem> orderItems;
        OrderItem orderItem;
        Product product;
        String sql = "SELECT orders.id,product.id,product.name,product.price,orderitem.number,product.image,orderitem.type FROM ORDERS,ORDERITEM,PRODUCT WHERE orders.uid = ? and orders.id = orderitem.oid and orderitem.pid = product.id";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{uid});
            while (resultSet.next()) {

                String orderId = resultSet.getString("orders.id");
                int productId = resultSet.getInt("product.id");
                String productName = resultSet.getString("product.name");
                double productPrice = resultSet.getDouble("product.price");
                String productImage = resultSet.getString("product.image");
                int productNumber = resultSet.getInt("orderitem.number");
                int orderItemType = resultSet.getInt("orderitem.type");

                if (allOrders.containsKey(orderId)) {
                    orderItem = new OrderItem();
                    product = new Product();

                    orderItem.setOid(orderId);
                    product.setId(productId);
                    orderItem.setPid(productId);
                    product.setName(productName);
                    product.setPrice(productPrice);
                    product.setImage(productImage);
                    orderItem.setType(orderItemType);
                    orderItem.setNumber(productNumber);
                    orderItem.setProduct(product);

                    allOrders.get(orderId).add(orderItem);
                } else {
                    orderItems = new ArrayList<>();
                    orderItem = new OrderItem();
                    product = new Product();

                    orderItem.setOid(orderId);
                    product.setId(productId);
                    orderItem.setPid(productId);
                    product.setName(productName);
                    product.setPrice(productPrice);
                    product.setImage(productImage);
                    orderItem.setType(orderItemType);
                    orderItem.setNumber(productNumber);
                    orderItem.setProduct(product);

                    orderItems.add(orderItem);
                    allOrders.put(orderId, orderItems);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return allOrders;
    }
}
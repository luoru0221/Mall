package lrmall.servlet.order;

import lrmall.bean.Order;
import lrmall.bean.OrderItem;
import lrmall.bean.Product;
import lrmall.dao.impl.CartDaoImpl;
import lrmall.dao.impl.OrderDaoImpl;
import lrmall.dao.impl.OrderItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  @author: Luoru
 *  @Date: 2019/10/13 20:41
 *  @Description: 添加订单到数据库
 */
@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {

    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    private CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = (String) req.getSession().getAttribute("loginId");
        ArrayList<Product> products = cartDao.selectToOrderCart(uid);
        String orderId = uid + System.currentTimeMillis();

        saveOrder(uid, products, orderId);
        saveOrderItem(products,orderId);

        resp.sendRedirect("orderList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private void saveOrder(String uid, ArrayList<Product> products, String orderId) {
        double sumPrice = 0;
        for (Product product : products) {
            sumPrice += (product.getPrice() * product.getNumber());
        }
        Order order = new Order();
        order.setId(orderId);
        order.setUid(uid);
        order.setPrice(sumPrice);
        order.setType(0);
        orderDao.createOrder(order);
    }

    private void saveOrderItem(ArrayList<Product> products, String orderId) {
        OrderItem orderItem;
        for (Product product : products) {
            orderItem = new OrderItem();
            orderItem.setOid(orderId);
            orderItem.setPid(product.getId());
            orderItem.setNumber(product.getNumber());
            orderItem.setType(0);
            orderItemDao.createOrderItem(orderItem);
        }
    }
}

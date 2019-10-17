package lrmall.servlet.merchan;

import lrmall.bean.Order;
import lrmall.bean.OrderItem;
import lrmall.dao.impl.OrderDaoImpl;
import lrmall.dao.impl.OrderItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ordersMerchan")
public class OrdersMerchan extends HttpServlet {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String store = (String) req.getSession().getAttribute("loginId");
        HashMap<String, ArrayList<OrderItem>> orders = orderItemDao.selectAllOrdersByStore(store);
        HashMap<String, Order> infor = orderDao.selectInformation(store);
        req.setAttribute("infor",infor);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("orders_merchan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

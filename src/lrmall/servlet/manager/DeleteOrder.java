package lrmall.servlet.manager;

import lrmall.bean.OrderItem;
import lrmall.dao.OrderItemDao;
import lrmall.dao.impl.OrderDaoImpl;
import lrmall.dao.impl.OrderItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderDao.deleteOrder(orderId);

        OrderItem orderItem = new OrderItem();
        orderItem.setOid(orderId);
        orderItemDao.delateOrderItem(orderItem);

        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

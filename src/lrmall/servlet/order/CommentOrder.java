package lrmall.servlet.order;

import lrmall.bean.Evaluate;
import lrmall.bean.OrderItem;
import lrmall.dao.OrderItemDao;
import lrmall.dao.impl.EvaluateDaoImpl;
import lrmall.dao.impl.OrderItemDaoImpl;
import lrmall.utils.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/commentOrder")
public class CommentOrder extends HttpServlet {
    private EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("pid"));  //商品id
        String uid = (String)req.getSession().getAttribute("loginId");  //用户Id
        String content = req.getParameter("content");   //评价内容
        String orderId = req.getParameter("orderId");
        String time = LocalTime.getStringDate();  //评价时间
        Evaluate evaluate = new Evaluate();
        evaluate.setPid(pid);
        evaluate.setUid(uid);
        evaluate.setContent(content);
        evaluate.setTime(time);

        OrderItem orderItem = new OrderItem();
        orderItem.setType(4);
        orderItem.setOid(orderId);
        orderItem.setPid(pid);

        evaluateDao.addEvaluateForProduct(evaluate);
        orderItemDao.updateOrderItemType(orderItem);
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

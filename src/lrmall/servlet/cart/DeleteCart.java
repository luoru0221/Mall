package lrmall.servlet.cart;

import lrmall.bean.Cart;
import lrmall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCart")
public class DeleteCart extends HttpServlet {
    private CartDaoImpl cartDao = new CartDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = req.getParameter("uid");
        String pid = req.getParameter("pid");
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setPid(Integer.parseInt(pid));
        cartDao.deleteCart(cart);
        resp.sendRedirect("cartLoad?userId="+uid);//重定向到购物车
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        this.doGet(req,resp);
    }
}

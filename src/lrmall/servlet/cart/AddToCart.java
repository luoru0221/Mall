package lrmall.servlet.cart;

import lrmall.bean.Cart;
import lrmall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 添加商品到购物车
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {

    private CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        int productId = Integer.parseInt(req.getParameter("productId"));
        int number = Integer.parseInt(req.getParameter("number"));
        boolean isNewCart = addToCart(userId, productId,number);
        try {
            PrintWriter writer = resp.getWriter();
            writer.print(isNewCart);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }

    private boolean addToCart(String uid, int pid,int number) {
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setPid(pid);
        cart.setNumber(number);
        cart.setType(0);
        return cartDao.addCart(cart);
    }

}

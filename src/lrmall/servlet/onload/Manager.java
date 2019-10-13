package lrmall.servlet.onload;

import lrmall.bean.Product;
import lrmall.bean.User;
import lrmall.dao.impl.ProductDaoImpl;
import lrmall.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manager")
public class Manager extends HttpServlet {

    private ProductDaoImpl productDao = new ProductDaoImpl();
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = productDao.queryAllProducts();  //查询到所有商品
        req.setAttribute("products", products);
        ArrayList<User> users = userDao.queryAllUsers();
        System.out.println(users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("manager.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

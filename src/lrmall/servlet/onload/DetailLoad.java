package lrmall.servlet.onload;

import lrmall.bean.Product;
import lrmall.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/detailLoad")
public class DetailLoad extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HashMap<String, ArrayList<String>> norms = productDao.queryNorm(id);
        Product product = productDao.queryProductById(id);
        req.setAttribute("norms", norms);
        req.setAttribute("product",product);
        //请求转发到商品详情页
        req.getRequestDispatcher("detail.jsp?productId="+id).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

package lrmall.servlet.usercenter;

import lrmall.bean.User;
import lrmall.dao.impl.UserDaoImpl;
import lrmall.utils.Md5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = Md5.toMd5(req.getParameter("password"));
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        if (password == null) {
            //不更改密码
            userDao.updateUserEmail(user);
        } else {
            //修改密码
            user.setPassword(password);
            userDao.updateUser(user);
        }
    }
}

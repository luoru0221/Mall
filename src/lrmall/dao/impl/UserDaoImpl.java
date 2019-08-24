package lrmall.dao.impl;

import lrmall.bean.User;
import lrmall.dao.UserDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DbUtil implements UserDao {

    /**
     * 根据用户账号查询用户所有信息
     * 参数为用户的id，返回值为用户的所有信息
     */
    @Override
    public User queryUserById(String id) {
        User user = null;
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        ResultSet resultSet = this.doQuery(sql, new Object[]{id});
        try {
            if (resultSet.next()){
                String userId = resultSet.getString("id");
                String userPwd = resultSet.getString("password");
                user = new User(userId,userPwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return user;
    }

    @Override
    public int addUser() {
        return 0;
    }
}

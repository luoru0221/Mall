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
            if (resultSet.next()) {
                String userId = resultSet.getString("id");
                String name = resultSet.getString("name");
                String userPwd = resultSet.getString("password");
                String email = resultSet.getString("email");
                user = new User();
                user.setId(userId);
                user.setName(name);
                user.setEmail(email);
                user.setPassword(userPwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return user;
    }

    /**
     * 添加新用户，参数为User对象
     * 返回值大于0则添加成功
     */
    @Override
    public int addUser(User newUser) {
        try {
            String sql = "INSERT INTO USERS (id,name,password,email) VALUES (?,?,?,?)";
            Object[] params = {newUser.getId(), newUser.getName(), newUser.getPassword(), newUser.getEmail()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    /**
     * 根据Id删除User
     */
    @Override
    public int deleteUserById(String id) {
        String sql = "DELETE FROM USERS WHERE id = ?";
        return this.doUpdate(sql, new Object[]{id});
    }

    /**
     * 修改用户信息的name,email,password
     */
    @Override
    public int updateUser(User user) {
        try {
            String sql = "UPDATE users set name=?,email=?,password=? WHERE id=?";
            Object[] params = {user.getName(),user.getEmail(),user.getPassword(),user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int updateUserEmail(User user) {
        try {
            String sql = "UPDATE users set name=?,email=? WHERE id=?";
            Object[] params = {user.getName(),user.getEmail(),user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }
}

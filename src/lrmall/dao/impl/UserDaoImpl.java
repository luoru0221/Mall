package lrmall.dao.impl;

import lrmall.bean.User;
import lrmall.dao.UserDao;
import lrmall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                user = new User();
                setUser(resultSet,user);
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
     * @param user User对象,包含id和password
     * @return 影响的数据条数
     * @time 2019年10月12日14:32:30
     */
    @Override
    public int updateUserPwd(User user) {
        try {
            String sql = "UPDATE users set password=? WHERE id=?";
            Object[] params = {user.getPassword(), user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    /**
     * 修改收件人的姓名和收货地址
     *
     * @param user User对象，包含用户的账号、收件人姓名和地址
     * @return 影响的数据条数
     */
    @Override
    public int updateUserAddress(User user) {
        try {
            String sql = "UPDATE users SET recname = ?,address = ? WHERE id = ?";
            Object[] params = {user.getRecName(), user.getAddress(), user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    /**
     * @return 除后台管理员之外的所有User对象的ArrayList集合
     * @time 2019年10月10日20:20:11
     */
    @Override
    public ArrayList<User> queryAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user;
        String sql = "SELECT * FROM USERS WHERE type <> 0";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while (resultSet.next()) {
                user = new User();
                setUser(resultSet, user);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return users;
    }

    /**
     * @param resultSet 数据库返回的所有User对象的结果集
     * @param user      需设置属性值的User对象
     * @time 2019年10月10日20:36:33
     */
    private void setUser(ResultSet resultSet, User user) throws SQLException {
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setAddress(resultSet.getString("address"));
        user.setType(resultSet.getInt("type"));
        user.setRecName(resultSet.getString("recname"));
    }
}

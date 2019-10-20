package lrmall.dao;

import lrmall.bean.User;

import java.util.ArrayList;

public interface UserDao {

    User queryUserById(String id);//根据Id查询User

    int addUser(User newUser);//增加用户信息

    int deleteUserById(String id);//根据Id删除User

    /**
     * 修改收件人信息
     * @param user User对象，包含用户的收件人姓名和地址
     * @return 影响数据的条数
     */
    int updateUserAddress(User user);

    /**
     * 修改用户密码
     * @param user User对象，包含用户ID和密码
     * @return 影响数据的条数
     */
    int updateUserPwd(User user);// 修改用户密码


    /**
     * @return 除后台管理员之外的所有User对象的ArrayList集合
     * @time 2019年10月10日20:20:11
     */
    ArrayList<User> queryAllUsers();

    void updateUserType(User user);
}

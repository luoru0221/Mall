package lrmall.dao;

import lrmall.bean.User;

public interface UserDao {

    User queryUserById(String id);//根据Id查询User
    int addUser(User newUser);//增加用户信息
    int deleteUserById(String id);//根据Id删除User
}

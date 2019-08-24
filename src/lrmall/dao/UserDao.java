package lrmall.dao;

import lrmall.bean.User;

public interface UserDao {

    User queryUserById(String id);//根据Id查询User
    int addUser();//增加用户信息
}

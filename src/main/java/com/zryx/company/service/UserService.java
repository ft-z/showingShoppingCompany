package com.zryx.company.service;

import com.zryx.company.model.User;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/14
 */
public interface UserService {
    User login(String userName, String password);
    List<User> getAllUser();

    void delUser(int id);

    void updUser(User user);
    //void updUserStatus(User user);

    User getUserById(int id);
    User getUserByName(String userName);

    void addUser(User user);
}

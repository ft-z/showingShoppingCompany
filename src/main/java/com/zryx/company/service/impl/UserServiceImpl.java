package com.zryx.company.service.impl;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.UserMapper;
import com.zryx.company.model.User;
import com.zryx.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/14
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

//    @Override
//    public User login(User userName, String password) {
//        User user = (User) UserMapper.getUserByName(userName);
//        if(user!=null) {
//            if(user.getPassword().equals(password)) {
//                return user;
//            }else {
//                throw new CustomException(2000,"用户名或密码错误");
//            }
//        }
//        return null;
//    }


    @Override
    public User login(String userName, String password) {
        User user = (User) userMapper.getUserByName(userName);
        if (user != null) {

            /*查询该用户是否已经登录，就是从数据库当中查询该用的登录状态。如果已经登录则抛出异常。*/
//            if (user.getLoginStatus() == 0) {

            if (user.getPassword().equals(password)) {
                return user;

            } else {
                throw new CustomException(2000, "用户名或密码错误");
            }

        } else {
            throw new CustomException(2001, "重复登录");
        }
    }
    // return null;


    @Override
    public List<User> getAllUser() {
        List<User> user = userMapper.getAllUser();
        return user;
    }

    @Override
    public void delUser(int id) {
        int row = userMapper.delUser(id);
        if (row == 0) {
            throw new CustomException(200, "删除用户出现异常");
        }
    }

    @Override
    public void updUser(User user) {
        int row = userMapper.updUser(user);
        if (row == 0) {
            throw new CustomException(200, "修改用户出现异常");
        }
    }

    //    @Override
//    public void updUserStatus(User user) {
//        int row = userMapper.updUserStatus(user);
//        if (row == 0) {
//            throw new CustomException(200, "修改用户状态出现异常");
    // }
    // }
    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String userName) {
        User user = userMapper.getUserByName(userName);
        return user;
    }


    @Override
    public void addUser(User user) {
        int row = userMapper.addUser(user);
        if (row == 0) {
            throw new CustomException(200, "增加用户出现异常");
        }
    }
}

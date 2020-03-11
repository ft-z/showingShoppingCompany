package com.zryx.company.controller;

import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.User;
import com.zryx.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 后台控制器当中的一个方法，该方法用来进行查询并返回一个json
     *
     * @return 向客户端返回json格式的字符串
     * @PostMapping用来处理post请求
     */
    @PostMapping("/initUser")
    public String initUser() {
        List<User> user = userService.getAllUser();
        String json = dealQueryResult(user, user);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/delUser")
    public String delUser(int id) {
        userService.delUser(id);
        return dealSuccessResutl("删除成功", null);
    }

    @PostMapping("/updUser")
    public String updUser(User user) {
        userService.updUser(user);
        return dealSuccessResutl("修改成功", null);
    }
//    @PostMapping("/updUserStatus")
//    public String updUserStatus(User user) {
//        userService.updUserStatus(user);
//        return dealSuccessResutl("修改状态成功", null);
    // }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return dealSuccessResutl("增加成功", null);
    }

    @PostMapping("/getUserById")
    public String getUserById(int id) {
        User user = userService.getUserById(id);
        String json = dealQueryResult(user, user);
        System.out.println(json);
        return dealQueryResult(user, user);
    }

    @PostMapping("/getUserByName")
    public String getUserByName(String userName) {
        User users = userService.getUserByName(userName);
        String json = dealQueryResult(users, users);
        System.out.println(json);
        return dealQueryResult(users, users);
    }
}
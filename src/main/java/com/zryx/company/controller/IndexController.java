package com.zryx.company.controller;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.News;
import com.zryx.company.model.Product;
import com.zryx.company.model.User;
import com.zryx.company.service.NewsService;
import com.zryx.company.service.ProductService;
import com.zryx.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 123
 * @create 2019/7/10
 */
@RestController
public class IndexController extends BaseController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    /**
     * 初始化首页新闻数据
     * @return
     */
    @PostMapping("/iniNews")
    public String iniNews() {
        List<News> top8News = newsService.selTop8News();
        String result = dealQueryResult(top8News,top8News);
     return result;
     }
    /**
     * 初始化首页商品数据
     * @return
     */
    @PostMapping("/top8Product")
    public String top8Product() {
        List<Product> top8Product = productService.selTop8Product();
        String result = dealQueryResult(top8Product,top8Product);
        return result;
    }

     /**
     * 初始化商品信息
     * @return
     */
    @PostMapping("/initProducts")
    public String initProducts() {
        List<Product> products = productService.allProducts();
        String result = dealQueryResult(products,products);
        return result;
    }

    /**
     * 聊天
     * @return
     */
    @PostMapping("/chat")
    public String chat(HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user==null) {
            throw new CustomException(1000,"您未曾登录");
        }
        return dealSuccessResutl("into chat",null);
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return dealSuccessResutl("登出成功",null);
    }

    @PostMapping("/login")
    public String login(HttpSession session, User user) {
        User dbUser = userService.login(user.getUserName(), user.getPassword());
        ServletContext application = session.getServletContext();
        List<User> users = (List<User>)application.getAttribute("users");
        if(users!=null) {
            for(User u : users) {
                if(u.getUserName().equals(user.getUserName())) {
                    throw new CustomException(1234,"该用户已经登录");
                }
            }
        }
        if (dbUser != null) {
            session.setAttribute("user", dbUser);
            //List<User> users = (List<User>) session.getServletContext().getAttribute("users");
            if (users == null) {
                users = new ArrayList<User>();
            }
            users.add(dbUser);
            session.getServletContext().setAttribute("users", users);
            return dealQueryResult(dbUser,dbUser);
            // return dealSuccessResutl("login success", null);
        }
        throw new CustomException(1100, "登录失败，用户名或密码错误");
    }
}

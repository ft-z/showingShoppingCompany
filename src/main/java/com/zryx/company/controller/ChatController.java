package com.zryx.company.controller;

import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Chat;
import com.zryx.company.model.User;
import com.zryx.company.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 123
 * @create 2019/7/13
 */

@RestController
public class ChatController extends BaseController {

    /**
     * 初始化聊天信息
     * @param session
     * @return
     */
    @PostMapping("/initChat")
    public String initChat(HttpSession session) {
        ServletContext application = session.getServletContext();
        List<User> users = (List<User>)application.getAttribute("users");
        User user = (User)session.getAttribute("user");
        Chat chat = (Chat)application.getAttribute("chat");
        if(chat == null) {
            chat = new Chat();
            chat.setSession(session);
            chat.setUser((List<User>) user);
        }
        application.setAttribute("chat",chat);
        String json = dealQueryResult(chat,chat);
        System.out.println("json=" + json);
        return json;
    }

    @PostMapping("/sendChat")
    public String sendChat(HttpSession session,String msg) {
        ServletContext application = session.getServletContext();
        Chat chat = (Chat)application.getAttribute("chat");
        LinkedList<String> chats = chat.getChats();
        User user = (User)session.getAttribute("user");
        chats.addFirst(user.getUserName()+"说："+msg);
        return dealQueryResult(chats,chats);
    }
}

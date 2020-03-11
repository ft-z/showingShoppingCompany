package com.zryx.company.model;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 123
 * @create 2019/7/14
 */
public class Chat {
    private List<User> user;
    private HttpSession session;

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    private LinkedList<String> chats;

    public Chat() {
    }

    public Chat(List<User> user, LinkedList<String> chats) {
        this.user = user;

        this.chats = chats;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }


    public LinkedList<String> getChats() {
        return chats;
    }

    public void setChats(LinkedList<String> chats) {
        this.chats = chats;
    }
}

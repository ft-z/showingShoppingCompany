package com.zryx.company.model;

/**
 * @author 123
 * @create 2019/7/11
 */
public class User{
    private int userId;
    private String userName;
    private String password;
    private int status;
    private int loginStatus;
    public User() {
    }

    public User(int userId, String userName, String password, int status,int loginStatus) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.loginStatus=loginStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }


//    public int getLoginStatus() {
//        return loginStatus;
//    }
//
//    public void setLoginStatus(int loginStatus) {
//        this.loginStatus = loginStatus;
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}

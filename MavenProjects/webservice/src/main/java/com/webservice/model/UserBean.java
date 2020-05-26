package com.webservice.model;

public class UserBean {
    private String user;
    private String pass;

    public UserBean(String user, String pass) {
        this.setUser(user);
        this.setPass(pass);
    }

    public UserBean() {
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
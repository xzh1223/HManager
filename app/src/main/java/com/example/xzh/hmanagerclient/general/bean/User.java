package com.example.xzh.hmanagerclient.general.bean;

/**
 * Created by Administrator on 2017/10/28.
 */

public class User {

    private int id;
    private String account;
    private String password;
    // 身份代号（ 0 表示管理员， 1 表示用户）
//    private int code = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

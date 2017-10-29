package com.example.xzh.hmanagerclient.user.work.bean;

import com.example.xzh.hmanagerclient.general.bean.User;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/28.
 *
 *  work 实体类
 *
 */

public class Work {

    private int id;

    private String workTitle;

    private String workContent;

    private String workTime;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workTitle='" + workTitle + '\'' +
                ", workContent='" + workContent + '\'' +
                ", workTime=" + workTime +
                ", user=" + user +
                '}';
    }
}

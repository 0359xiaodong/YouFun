package com.deakee.youfun.mvp.bean;

/**
 * Created by JHong on 2015/3/3.
 */
public class NavBean extends BaseBean{
    protected String userName; // 用户名
    protected String userHeadUrl; // 用户头像URL
    protected String statue; // 状态

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
}

package com.deakee.youfun.mvp.bean;

/**
 * Created by Deekea on 2015/3/1.
 *
 * Topic 帖子Bean
 */
public class TopicBean extends BaseBean{
    // 结账方式，分3种
    public final int PAY_TYPE_AA = 1;   // AA制
    public final int PAY_TYPE_ME = 2;   // 我请客
    public final int PAY_TYPE_YOU = 3;  // 你请客 haha

    private String username;    // 用户名（发帖人）
    private String userheadUrl; // 用户头像图片地址
    private String publishTime; // 发帖时间
    private int payType;        // 结账方式，详见上方常量
    private String summary;     // 摘要

    private String location;            // 地点
    private String locationImageUrl;    // 地点图片地址
    private String locationDistance;    // 地址离“我”的距离
    private String[] mealTags;          // 标签
    private String vailTime;            // 有效时间（吃饭时间）

    // 暂不可见
    private String joinNum;             // 报名人数
    private String relayNum;            // 回复数目

    // 隐藏信息
    private int orderNum; // 序号

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserheadUrl() {
        return userheadUrl;
    }

    public void setUserheadUrl(String userheadUrl) {
        this.userheadUrl = userheadUrl;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationImageUrl() {
        return locationImageUrl;
    }

    public void setLocationImageUrl(String locationImageUrl) {
        this.locationImageUrl = locationImageUrl;
    }

    public String getLocationDistance() {
        return locationDistance;
    }

    public void setLocationDistance(String locationDistance) {
        this.locationDistance = locationDistance;
    }

    public String[] getMealTags() {
        return mealTags;
    }

    public void setMealTags(String[] mealTags) {
        this.mealTags = mealTags;
    }

    public String getVailTime() {
        return vailTime;
    }

    public void setVailTime(String vailTime) {
        this.vailTime = vailTime;
    }

    public String getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(String joinNum) {
        this.joinNum = joinNum;
    }

    public String getRelayNum() {
        return relayNum;
    }

    public void setRelayNum(String relayNum) {
        this.relayNum = relayNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}

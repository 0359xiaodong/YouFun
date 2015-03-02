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
    private String id; // id
    private int orderNum; // 序号

}

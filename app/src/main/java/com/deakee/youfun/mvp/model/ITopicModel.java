package com.deakee.youfun.mvp.model;

import com.deakee.youfun.mvp.bean.TopicBean;

import java.util.ArrayList;

/**
 * Created by JHong on 2015/3/3.
 */
public interface ITopicModel {
    /**
     * 初始化
     */
    void init();

    /**
     * 加载成功，更新UI
     */
    void update();

    /**
     * 加载失败
     */
    void loadFailed();

    /**
     *  第一次加载
     */
    ArrayList<TopicBean> load();

    /**
     * 加载更多
     */
    ArrayList<TopicBean> loadMore(int page);
}

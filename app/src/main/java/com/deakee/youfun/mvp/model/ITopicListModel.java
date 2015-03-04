package com.deakee.youfun.mvp.model;

import com.deakee.youfun.mvp.bean.TopicBean;

import java.util.ArrayList;

/**
 * Created by JHong on 2015/3/3.
 */
public interface ITopicListModel {
    /**
     * 初始化
     */
    void init();

    /**
     *  第一次加载
     */
    void load();

    /**
     * 加载更多
     */
    void loadMore();
}

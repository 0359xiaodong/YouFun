package com.deakee.youfun.mvp.model;

import com.deakee.youfun.mvp.bean.TopicBean;

import java.util.ArrayList;

/**
 * Created by JHong on 2015/3/3.
 */
public class TopicModel extends BaseModel implements ITopicModel{
    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void loadFailed() {

    }

    @Override
    public ArrayList<TopicBean> load() {
        return null;
    }

    @Override
    public ArrayList<TopicBean> loadMore(int page) {
        return null;
    }
}

package com.deakee.youfun.mvp.presenter;

import com.deakee.youfun.mvp.model.ITopicModel;
import com.deakee.youfun.mvp.model.TopicModel;
import com.deakee.youfun.mvp.view.ITopicView;
import com.deakee.youfun.util.LogUtils;

/**
 * Created by JHong on 2015/3/3.
 */
public class TopicPresenter {
    private String TAG = "TopicPresenter";

    protected ITopicModel mITopicModel;
    protected ITopicView mITopicView;

    public TopicPresenter(ITopicView mITopicView) {
        this.mITopicView = mITopicView;
        mITopicModel = new TopicModel();
    }

    public void load() {
        LogUtils.LOGI(TAG, "load");
    }

    public void loadMore(int page) {
        LogUtils.LOGI(TAG, "loadMore");
    }


}

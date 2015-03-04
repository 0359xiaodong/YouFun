package com.deakee.youfun.mvp.presenter;

import com.deakee.youfun.mvp.model.ITopicListModel;
import com.deakee.youfun.mvp.model.TopicListModel;
import com.deakee.youfun.mvp.view.ITopicListView;
import com.deakee.youfun.util.LogUtils;

/**
 * Created by JHong on 2015/3/3.
 */
public class TopicListPresenter {
    private String TAG = "TopicPresenter";

    protected ITopicListModel mITopicListModel;
    protected ITopicListView mITopicListView;

    public TopicListPresenter(ITopicListView mITopicListView) {
        this.mITopicListView = mITopicListView;
        mITopicListModel = new TopicListModel();
    }

    public void load() {
        LogUtils.LOGI(TAG, "load");
    }

    public void loadMore(int page) {
        LogUtils.LOGI(TAG, "loadMore");
    }


}

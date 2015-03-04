package com.deakee.youfun.mvp.model;

import com.deakee.youfun.adapter.base.ListPageInfo;
import com.deakee.youfun.mvp.bean.TopicBean;
import com.deakee.youfun.util.LogUtils;

import java.util.ArrayList;

/**
 * Created by JHong on 2015/3/3.
 */
public class TopicListModel extends BaseListModel<TopicBean> implements ITopicListModel {
    private final String TAG = "TopicListModel";

    public final int PAGE_WITH_ITEM_SIZE = 10;

    // test
    TopicListData event = new TopicListData();

    public TopicListModel() {
        mListPageInfo = new ListPageInfo<TopicBean>(PAGE_WITH_ITEM_SIZE);

    }

    public ListPageInfo getPageInfo() {
        return mListPageInfo;
    }

    @Override
    public void init() {

    }

    @Override
    public void load() {
        LogUtils.LOGD(TAG, "load");
        queryFirstPage();
    }

    @Override
    public void loadMore() {
        LogUtils.LOGD(TAG, "loadMore");
        queryNextPage();
    }

    @Override
    protected void doQueryData() {
        LogUtils.LOGD(TAG, "doQueryData");


        event.success = true;
        event.hasMore = true;
        for(int i = 0; i < 10; i++) {
            TopicBean item = new TopicBean();
            item.setId(mListPageInfo.getPage() + "_" + i);
            item.setJoinNum("join num " + i);
            item.setLocation("location " + i);
            item.setLocationDistance("location distance " + i);
            item.setLocationImageUrl("location iamge " + i);
            item.setMealTags(new String[]{"good", "delicious"});
            item.setOrderNum(i);
            item.setPayType(1);
            item.setPublishTime("publish time " + i);
            item.setRelayNum("relay num " + i);
            item.setSummary("summary " + i);
            item.setUserheadUrl("user head " + i);
            item.setUsername("username " + i);
            item.setVailTime("vailtime" + i);
            event.topicList.add(item);
        }
    }

    private class TopicListData {
        public boolean success;
        public boolean hasMore;
        public ArrayList<TopicBean> topicList;
    }
}

package com.deakee.youfun.model;


import com.deakee.youfun.data.TopicListItem;
import com.deakee.youfun.event.EventCenter;
import com.deakee.youfun.event.TopicListDataEvent;

import java.io.InputStream;
import java.util.ArrayList;

import in.srain.cube.util.CLog;
import in.srain.cube.views.list.ListPageInfo;

/**
 * Created by Deekea on 2015/3/1.
 */
public class TopicListDataModel extends BaseListModel<TopicListItem> {
    private String TAG = "TopicListDataModel";

    public TopicListDataModel(int numDataPrePage) {
        mListPageInfo = new ListPageInfo<TopicListItem>(numDataPrePage);
    }

    @Override
    protected void doQueryData() {
        CLog.d(TAG, "doQueryData");

        TopicListDataEvent event = new TopicListDataEvent();
        event.success = true;
        event.hasMore = true;
        event.topicList = new ArrayList<TopicListItem>();
        for (int i = 0; i < 10; i++) {
            TopicListItem data = new TopicListItem();
            data.setUsername("Deekea");
            data.setUserSexType(i % 2);
            data.setUserheadUrl("http://img.user.kanimg.com/usrimg/434897878/100x100"); //
            data.setCommentNum((10 + i) + "");
            data.setId(i + "");
            data.setJoinNum((1 + i) + "");
            data.setLocation("xx Hotel");
            data.setLocationDistance(i + "Km");
            data.setLocationImageUrl("http://img5.imgtn.bdimg.com/it/u=1051673220,2134620161&fm=23&gp=0.jpg"); //
            data.setMealTags(new String[]{"good", "delicious"});
            data.setOrderNum(i);
            data.setPayType(i % 3);
            data.setPublishTime("2014-03-07");
            data.setSummary("Welcome every to join !  Enjoy yourself ! \n  This is a summary ! ");
            data.setVailTime("2014-03-08");

            event.topicList.add(data);
        }


        setRequestResult(event.topicList, event.hasMore); // update the paper
        EventCenter.getInstance().post(event);

    }
}

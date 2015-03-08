package com.deakee.youfun.event;


import com.deakee.youfun.data.TopicListItem;

import java.util.ArrayList;

/**
 * Created by Deekea on 2015/3/6.
 */
public class TopicListDataEvent {
    public boolean success;
    public boolean hasMore;
    public ArrayList<TopicListItem> topicList;
}

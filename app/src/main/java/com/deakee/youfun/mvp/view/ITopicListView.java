package com.deakee.youfun.mvp.view;

import com.deakee.youfun.adapter.base.ListPageInfo;

/**
 * Created by JHong on 2015/3/3.
 */
public interface ITopicListView {
    void initPageListAdapter(ListPageInfo listPageInfo);

    void updateUI();
}

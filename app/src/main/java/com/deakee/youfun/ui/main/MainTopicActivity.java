package com.deakee.youfun.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.deakee.youfun.R;
import com.deakee.youfun.adapter.base.ListPageInfo;
import com.deakee.youfun.adapter.base.PagedListViewDataAdapter;
import com.deakee.youfun.mvp.bean.TopicBean;
import com.deakee.youfun.mvp.presenter.TopicListPresenter;
import com.deakee.youfun.mvp.view.INavView;
import com.deakee.youfun.mvp.view.ITopicListView;
import com.deakee.youfun.ui.BaseActivity;
import com.deakee.youfun.util.LocalDisplay;
import com.deakee.youfun.util.LogUtils;

public class MainTopicActivity extends BaseActivity implements INavView, ITopicListView {
    private final String TAG = "MainTopicActivity";

    private ListView mTopicListView; //
    private PagedListViewDataAdapter<TopicBean> mAdapter;
    private TopicListPresenter mTopicListPresenter; // TopicPresenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topic);

        Toolbar toolbar = getActionBarToolbar();
        toolbar.setTitle("");

        mTopicListView = (ListView) findViewById(R.id.topic_list);
        // header place holder
        View headerMarginView = new View(MainTopicActivity.this);
        headerMarginView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LocalDisplay.dp2px(20)));
        mTopicListView.addHeaderView(headerMarginView);

        mAdapter = new PagedListViewDataAdapter<TopicBean>();

        mTopicListPresenter = new TopicListPresenter(MainTopicActivity.this); //

        mTopicListView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTopicListPresenter.load(); // 加载数据
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_topic, menu);
        return true;
    }

    @Override
    public void initPageListAdapter(ListPageInfo listPageInfo) {
        if(listPageInfo != null) {
            mAdapter.setListPageInfo(listPageInfo);
        } else {
            LogUtils.LOGE(TAG, "listPageInfo is null !");
        }
    }

    @Override
    public void updateUI() {
        mAdapter.notifyDataSetChanged();
    }
}

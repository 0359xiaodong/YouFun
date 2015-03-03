package com.deakee.youfun.ui.main;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.deakee.youfun.R;
import com.deakee.youfun.mvp.presenter.TopicPresenter;
import com.deakee.youfun.mvp.view.INavView;
import com.deakee.youfun.mvp.view.ITopicView;
import com.deakee.youfun.ui.BaseActivity;

import java.util.List;

public class MainTopicActivity extends BaseActivity implements INavView, ITopicView{

    private ListView mTopicListView; // TopicList控件
    private TopicPresenter mTopicPresenter; // TopicPresenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topic);

        Toolbar toolbar = getActionBarToolbar();
        toolbar.setTitle(null);

        mTopicListView = (ListView) findViewById(R.id.topic_list);

        mTopicPresenter = new TopicPresenter(MainTopicActivity.this); //

    }

    @Override
    protected void onStart() {
        super.onStart();
        mTopicPresenter.load(); // 加载数据
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_topic, menu);
        return true;
    }

}

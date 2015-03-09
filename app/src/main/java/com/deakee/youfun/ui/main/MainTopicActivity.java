package com.deakee.youfun.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.deakee.youfun.R;
import com.deakee.youfun.base.YouFunTitleBaseActivity;
import com.deakee.youfun.data.TopicListItem;
import com.deakee.youfun.event.DemoSimpleEventHandler;
import com.deakee.youfun.event.EventCenter;
import com.deakee.youfun.event.TopicListDataEvent;
import com.deakee.youfun.model.TopicListDataModel;
import com.deakee.youfun.ui.PtrUIRefreshCompleteHandler;
import com.deakee.youfun.ui.fragment.LoginFragment;
import com.deakee.youfun.ui.viewholders.TopicListItemViewHolder;

import org.json.JSONObject;

import java.io.InputStream;

import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.util.CLog;
import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.list.PagedListViewDataAdapter;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

public class MainTopicActivity extends YouFunTitleBaseActivity {
    private String TAG = "MainTopicActivity";

    private PagedListViewDataAdapter<TopicListItem> mAdapter;
    private TopicListDataModel mDataModel;
    private ImageLoader mImageLoader;
    private PtrFrameLayout mPtrFrameLayout;
    private ListView mListView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topic);

        initImageLoader();
        initModelAndAdapter();

        initView();
        initEventBus();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh(true);
            }
        }, 150);

        LoginFragment editNameDialog = new LoginFragment();
        editNameDialog.show(getSupportFragmentManager(), "LoginFragment");
    }

    private void initImageLoader() {
        mImageLoader = ImageLoaderFactory.create(getContext());
        ((DefaultImageLoadHandler) mImageLoader.getImageLoadHandler()).setImageRounded(true, 25);
    }

    private void initModelAndAdapter() {
        mDataModel = new TopicListDataModel(5);

        mAdapter = new PagedListViewDataAdapter<TopicListItem>();
        mAdapter.setViewHolderClass(getContext(), TopicListItemViewHolder.class, mImageLoader);
        mAdapter.setListPageInfo(mDataModel.getListPageInfo());
    }

    private void initView() {
        initToolBar();
        initDrawerLayout();
        initPtrFrameLayout();
        initListView();
    }

    // init the toolbar
    private void initToolBar() {
        Toolbar toolbar = getActionBarToolbar();
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
    }

    private void initDrawerLayout() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, getActionBarToolbar(), R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    // init the pull down
    private void initPtrFrameLayout() {
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.load_more_list_view_ptr_frame);
        MaterialHeader ptrHeader = new MaterialHeader(getContext());
        PtrFrameLayout.LayoutParams lp = new PtrFrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ptrHeader.setLayoutParams(lp);
        ptrHeader.setPadding(0, LocalDisplay.dp2px(20), 0, LocalDisplay.dp2px(2));
        ptrHeader.setPtrFrameLayout(mPtrFrameLayout);

        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setHeaderView(ptrHeader);
        mPtrFrameLayout.addPtrUIHandler(ptrHeader);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // here check list view, not content.
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mListView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                CLog.d(TAG, "onRefreshBegin");
                mDataModel.queryFirstPage();
            }
        });

        mPtrFrameLayout.addPtrUIHandler(new PtrUIRefreshCompleteHandler() {
            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {
                CLog.d(TAG, "onUIRefreshComplete");

//                loadMoreListViewContainer.loadMoreFinish(mDataModel.getListPageInfo().isEmpty(), mDataModel.getListPageInfo().hasMore());
                mAdapter.notifyDataSetChanged();
                mDataModel.getListPageInfo().unlock(); // unlock the pull down action
            }
        });
    }

    // init ListView
    private void initListView() {
        mListView = (ListView) findViewById(R.id.topic_list_view);

        // header place holder
        View headerMarginView = new View(getContext());
        headerMarginView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LocalDisplay.dp2px(getResources().getDimension(R.dimen.keyline_1_minus_8dp))));
        mListView.addHeaderView(headerMarginView);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    private void initEventBus() {
        EventCenter.bindContainerAndHandler(this, new DemoSimpleEventHandler() {

            public void onEvent(TopicListDataEvent event) {
                CLog.d(TAG, "onEvent");
                mPtrFrameLayout.refreshComplete();
            }

        }).tryToRegisterIfNot();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_topic, menu);

        initSearchView(menu);

        return true;
    }

    private void initSearchView(Menu menu) {
        //init searchView
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on search onclick
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                // on close onclick
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Context getContext() {
        return MainTopicActivity.this;
    }
}

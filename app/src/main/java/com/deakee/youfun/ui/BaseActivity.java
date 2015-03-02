package com.deakee.youfun.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.deakee.youfun.R;
import com.deakee.youfun.util.LogUtils;

/**
 * Created by Deekea on 2015/3/1.
 *
 * 所有Activity公用的方法
 */
public abstract class BaseActivity extends ActionBarActivity{
    private final String TAG = "BaseActivity";

    // 标题栏
    private Toolbar mActionBarToolbar;
    // 侧拉栏
    private DrawerLayout mDrawerLayout;
    // 侧拉栏选项容器
    private ViewGroup mDrawerItemsListContainer;

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavDrawer();

    }

    /**
     *
     */
    private void setupNavDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout == null) {
            return;
        }

        if (mActionBarToolbar != null) {
            mActionBarToolbar.setNavigationIcon(R.drawable.ic_drawer);
            mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LogUtils.LOGI(TAG, "mActionBarToolbar on click");
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            });
        }
    }

    private void createNavDrawerItems() {
        mDrawerItemsListContainer = (ViewGroup) findViewById(R.id.navdrawer_items_list);
        if (mDrawerItemsListContainer == null) {
            return;
        }

//        mNavDrawerItemViews = new View[mNavDrawerItems.size()];
//        mDrawerItemsListContainer.removeAllViews();
//        int i = 0;
//        for (int itemId : mNavDrawerItems) {
//            mNavDrawerItemViews[i] = makeNavDrawerItem(itemId, mDrawerItemsListContainer);
//            mDrawerItemsListContainer.addView(mNavDrawerItemViews[i]);
//            ++i;
//        }
    }
}

package com.deakee.youfun.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.deakee.youfun.R;


/**
 * Created by Deekea on 2015/3/6.
 * <p/>
 * use toolbar
 */
public abstract class YouFunTitleBaseActivity extends YouFunExitTipFragmentActivity {

    private Toolbar mActionBarToolbar;
    private LinearLayout mContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    protected int getFrameLayoutId() {
        return R.layout.activity_base_titlebar;
    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        }
        return mActionBarToolbar;
    }

    protected LinearLayout getContentContainer() {
        return (LinearLayout) findViewById(R.id.youfun_content_frame_content);
    }

    private void initViews() {
        super.setContentView(getFrameLayoutId());
        mContentContainer = (LinearLayout) findViewById(R.id.youfun_content_frame_content);
    }


    protected boolean enableDefaultBack() {
        return true;
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mContentContainer.addView(view);
    }
}

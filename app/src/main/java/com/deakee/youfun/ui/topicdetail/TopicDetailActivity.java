package com.deakee.youfun.ui.topicdetail;

import android.content.Context;
import android.os.Bundle;

import com.deakee.youfun.R;
import com.deakee.youfun.base.YouFunNoExitTipFragmentActivity;

/**
 * Created by Deekea on 2015/3/10.
 */
public class TopicDetailActivity extends YouFunNoExitTipFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topic_detail);
    }

    @Override
    protected Context getContext() {
        return TopicDetailActivity.this;
    }
}

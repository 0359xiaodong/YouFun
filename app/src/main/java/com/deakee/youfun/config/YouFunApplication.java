package com.deakee.youfun.config;

import android.app.Application;

import com.deakee.youfun.util.LocalDisplay;

/**
 * Created by Deekea on 2015/2/21.
 */
public class YouFunApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // local display
        LocalDisplay.init(YouFunApplication.this);
    }
}

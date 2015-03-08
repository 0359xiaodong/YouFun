package com.deakee.youfun.base;

import com.deakee.youfun.R;

/**
 * Created by Deekea on 2015/3/6.
 */
public abstract class YouFunExitTipFragmentActivity extends YouFunBaseFragmentActivity {

    @Override
    protected String getCloseWarning() {
        return getString(R.string.exit_tip);
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }
}

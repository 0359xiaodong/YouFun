package com.deakee.youfun.base;


/**
 * Created by Deekea on 2015/3/9.
 */
public abstract class YouFunNoExitTipFragmentActivity extends YouFunBaseFragmentActivity {

    @Override
    protected String getCloseWarning() {
        return null;
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

    /**
     * process the return back logic
     * return true if back pressed event has been processed and should stay in current view
     *
     * @return
     */
    protected boolean processBackPressed() {
        return true;
    }
}

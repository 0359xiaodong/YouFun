package com.deakee.youfun.mvp.presenter;

import com.deakee.youfun.mvp.model.INavModel;
import com.deakee.youfun.mvp.model.NavModel;
import com.deakee.youfun.mvp.view.INavView;

/**
 * Created by JHong on 2015/3/3.
 */
public class NavPresenter {
    protected INavView mINavView;
    protected INavModel mINavModel;

    public NavPresenter(INavView mINavView) {
        this.mINavView = mINavView;
        this.mINavModel = new NavModel();
    }

    public void update() {

    }


}

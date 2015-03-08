package com.deakee.youfun.base;

import android.os.Bundle;

import in.srain.cube.app.lifecycle.IComponentContainer;
import in.srain.cube.app.lifecycle.LifeCycleComponent;
import in.srain.cube.app.lifecycle.LifeCycleComponentManager;
import in.srain.cube.util.CLog;
import in.srain.cube.util.CubeDebug;

/**
 * Created by Deekea on 2015/3/6.
 *
 */
public abstract class YouFunBaseFragmentActivity extends YouFunFragmentActivity implements IComponentContainer {

    private LifeCycleComponentManager mComponentContainer = new LifeCycleComponentManager();

    private static final boolean DEBUG = CubeDebug.DEBUG_LIFE_CYCLE;

    @Override
    protected void onRestart() {
        super.onStart();
        mComponentContainer.onBecomesVisibleFromTotallyInvisible();
        if (DEBUG) {
            showStatus("onRestart");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mComponentContainer.onBecomesPartiallyInvisible();
        if (DEBUG) {
            showStatus("onPause");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mComponentContainer.onBecomesVisibleFromPartiallyInvisible();
        if (DEBUG) {
            showStatus("onResume");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG) {
            showStatus("onCreate");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mComponentContainer.onBecomesTotallyInvisible();
        if (DEBUG) {
            showStatus("onStop");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponentContainer.onDestroy();
        if (DEBUG) {
            showStatus("onDestroy");
        }
    }

    @Override
    public void addComponent(LifeCycleComponent component) {
        mComponentContainer.addComponent(component);
    }

    private void showStatus(String status) {
        final String[] className = ((Object) this).getClass().getName().split("\\.");
        CLog.d("cube-lifecycle", String.format("%s %s", className[className.length - 1], status));
    }
}

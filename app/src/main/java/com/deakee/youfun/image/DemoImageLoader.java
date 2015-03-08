package com.deakee.youfun.image;

import android.content.Context;

import in.srain.cube.app.lifecycle.LifeCycleComponent;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageProvider;
import in.srain.cube.image.iface.ImageLoadHandler;
import in.srain.cube.image.iface.ImageResizer;
import in.srain.cube.image.iface.ImageTaskExecutor;

public class DemoImageLoader extends ImageLoader implements LifeCycleComponent {

    public static ImageLoader createStableImageLoader(Context context) {
        return null;
    }

    public DemoImageLoader(Context context, ImageProvider imageProvider, ImageTaskExecutor imageTaskExecutor, ImageResizer imageResizer, ImageLoadHandler imageLoadHandler) {
        super(context, imageProvider, imageTaskExecutor, imageResizer, imageLoadHandler);
    }

    @Override
    public void onBecomesVisibleFromTotallyInvisible() {
        recoverWork();
    }

    @Override
    public void onBecomesPartiallyInvisible() {
        pauseWork();
    }

    @Override
    public void onBecomesVisible() {
        resumeWork();
    }

    @Override
    public void onBecomesTotallyInvisible() {
        stopWork();
    }

    @Override
    public void onDestroy() {
        destroy();
    }
}
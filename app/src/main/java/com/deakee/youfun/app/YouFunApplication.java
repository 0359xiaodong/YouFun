package com.deakee.youfun.app;

import android.app.Application;
import android.os.Environment;

import com.deakee.youfun.BuildConfig;
import com.deakee.youfun.image.DemoDuiTangImageResizer;
import com.deakee.youfun.util.DemoEnv;

import java.io.File;

import in.srain.cube.Cube;
import in.srain.cube.cache.CacheManagerFactory;
import in.srain.cube.diskcache.lru.SimpleDiskLruCache;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.request.RequestCacheManager;
import in.srain.cube.util.CLog;
import in.srain.cube.util.CubeDebug;
import in.srain.cube.util.LocalDisplay;

/**
 * Created by Deekea on 2015/2/21.
 */
public class YouFunApplication extends Application{

    public static YouFunApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        boolean isProd = !BuildConfig.DEBUG;
        DemoEnv.setIsProd(isProd);

        // init log level
        if (DemoEnv.isProd()) {
            CLog.setLogLevel(CLog.LEVEL_ERROR);
        } else {
            // development
            CLog.setLogLevel(CLog.LEVEL_VERBOSE);
        }

        // debug options
        SimpleDiskLruCache.DEBUG = true;
        CubeDebug.DEBUG_LIFE_CYCLE = false;
        CubeDebug.DEBUG_CACHE = true;
        CubeDebug.DEBUG_IMAGE = true;
        CubeDebug.DEBUG_REQUEST = true;

        Cube.onCreate(this);

        initImageLoader();

        initRequestCache();

        // init local cache, just use default
        CacheManagerFactory.initDefaultCache(this, null, -1, -1);
    }

    private void initImageLoader() {

        File path1 = Environment.getExternalStoragePublicDirectory("cube/test1/a/b/c");
        ImageLoaderFactory.customizeCache(
                this,
                // memory size
                1024 * 10,
                // disk cache directory
                path1.getAbsolutePath(),
                // disk cache size
                ImageLoaderFactory.DEFAULT_FILE_CACHE_SIZE_IN_KB
        );

        DefaultImageLoadHandler handler = new DefaultImageLoadHandler(this);
        // handler.setLoadingImageColor("#999999");

        ImageLoaderFactory.setDefaultImageLoadHandler(handler);
        ImageLoaderFactory.setDefaultImageResizer(DemoDuiTangImageResizer.getInstance());
    }

    private void initRequestCache() {
        String dir = "request-cache";
        RequestCacheManager.init(this, dir, 1024 * 10, 1024 * 10);
    }

}
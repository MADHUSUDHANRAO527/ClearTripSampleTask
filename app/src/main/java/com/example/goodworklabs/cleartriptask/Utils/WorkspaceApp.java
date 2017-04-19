package com.example.goodworklabs.cleartriptask.Utils;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.android.volley.ExecutorDelivery;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;

import java.util.concurrent.ThreadPoolExecutor;

import static android.content.ContentValues.TAG;

/**
 * Created by Madhu on 17/04/17.
 */

public class WorkspaceApp extends Application {
    RequestQueue mRequestQueue;
    private static final String DEFAULT_CACHE_DIR = "volley";
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private static WorkspaceApp workspaceAppInstance;
    private ImageLoader mImageLoader;
    private FeaturedActivityModel mainModel;
    @Override
    public void onCreate() {
        super.onCreate();
        workspaceAppInstance = this;
        // Instantiate the RequestQueue.
        mRequestQueue = Volley.newRequestQueue(this);

    }
    public static synchronized WorkspaceApp getInstance() {
        return workspaceAppInstance;
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            java.io.File cacheDir = new java.io.File(getCacheDir(), DEFAULT_CACHE_DIR);
            Network network = new BasicNetwork(new HurlStack());
            ThreadPoolExecutor tp = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
            tp.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
            ExecutorDelivery exec = new ExecutorDelivery(tp);
            mRequestQueue = new RequestQueue(new DiskBasedCache(cacheDir), network,
                    DEFAULT_NETWORK_THREAD_POOL_SIZE, exec);
            mRequestQueue.start();
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
    public void setMainModel(FeaturedActivityModel model){
        this.mainModel = model;
    }
    public FeaturedActivityModel getMainModel(){
        return mainModel;
    }
}

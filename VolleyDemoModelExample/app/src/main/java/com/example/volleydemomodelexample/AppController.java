package com.example.volleydemomodelexample;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static AppController getmInstance() {
        return mInstance;
    }

    public RequestQueue getmRequestQueue() {
        if (mRequestQueue == null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getmImageLoader() {
        getmRequestQueue();
        if (mImageLoader == null){
            mImageLoader=new ImageLoader(this.mRequestQueue,new ImageClass());

        }
        return this.mImageLoader;
    }

    public  void addToRequestQueue(Request req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getmRequestQueue().add(req);
    }

    public  void addToRequestQueue(Request req) {
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

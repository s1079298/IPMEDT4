package com.example.thier.demo;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
     * Created by Wendy on 5-4-2016.
 */

//initialiseren van de volley core objects
public class JSONadapter extends Application {

    public static final String TAG = JSONadapter.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static JSONadapter mInstance;

    //onCreate methode
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //JSONAdapter
    public static synchronized JSONadapter getInstance() {
        return mInstance;
    }

    //RequestQueue voor volley
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    //toevoegen aan requestqueue
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
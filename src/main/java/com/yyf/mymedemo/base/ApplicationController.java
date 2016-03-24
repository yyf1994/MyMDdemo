package com.yyf.mymedemo.base;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/3/17.
 */
public class ApplicationController extends Application {

    public static final String TAG = "VolleyPatterns";

    private  RequestQueue mRequestQueue;

    private static ApplicationController sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }

    public static ApplicationController getsInstance() {
        return sInstance;
    }


    public RequestQueue getmRequestQueue() {
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    //加入消息队列
    public <T> void addToRequestQueue(Request<T> request){

        request.setTag(TAG);
        getmRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request,String tag){

        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getmRequestQueue().add(request);
    }

    /**
     * Volley提供了强大的API取消未处理或正在处理的请求。取消请求最简单的方法是调用请求队列cancelAll（tag）的方法，
     * 前提是你在添加请求时设置了标记。这样就能使标签标记的请求挂起。
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /**
     * 重试失败的请求，自定义请求超时 Volley中没有指定的方法来设置请求超时时间，可以设置RetryPolicy
     * 来变通实现。DefaultRetryPolicy类有个initialTimeout参数
     * ，可以设置超时时间。要确保最大重试次数为1，以保证超时后不重新请求。
     */
    public <T> void SettingRequestTimeout(Request<T> req) {
        req.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
    }
}

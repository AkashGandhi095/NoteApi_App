package com.asus.noteapiapp.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequest {
    private RequestQueue requestQueue;
    private static SingletonRequest mInstance;

    private SingletonRequest(Context context)
    {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized SingletonRequest getInstance(Context context)
    {
        if(mInstance == null)
            mInstance = new SingletonRequest(context);

        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        return requestQueue;
    }
}

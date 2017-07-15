package com.example.student.oolie.view;

/**
 * Created by Student on 7/2/17.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ravali121 on 6/29/2017.
 */

public class MySingleton {
    //Create instance of this class
    private static MySingleton mInstance;
    //Create a variable for request queue
    private RequestQueue requestQueue;
    private static Context mContext;

    private MySingleton(Context context){
        mContext = context;
        requestQueue = getRequestQueue();
    }

    //Method to return RequestQueue
    public RequestQueue  getRequestQueue()
    {
        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getInstance(Context context)
    {
        if(mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestqueue(Request<T> request){
        requestQueue.add(request);
    }
}

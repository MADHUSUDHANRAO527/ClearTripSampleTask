package com.example.goodworklabs.cleartriptask.Utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.goodworklabs.cleartriptask.Events.AcitivityEvent;
import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Madhu on 17/04/17.
 */

public class VolleyHelper {
    private static String TAG = "VolleyHelper";

    public static void getFeaturedActivityList() {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Constants.BASE_URL + Constants.activityAPIUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject activityResponse) {
                        Log.d(TAG, activityResponse.toString());
                        Gson gson = new Gson();
                        Type type = new TypeToken<FeaturedActivityModel>() {
                        }.getType();
                        FeaturedActivityModel model = gson.fromJson(activityResponse.toString(), type);
                        EventBus.getDefault().post(new AcitivityEvent(true, 200, model));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                Log.d(TAG, error.toString());
                error.printStackTrace();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    EventBus.getDefault().post(new AcitivityEvent(false, "No Connection Error"));
                } else if (error instanceof AuthFailureError) {
                    EventBus.getDefault().post(new AcitivityEvent(false, "AuthFailureError"));
                } else if (error instanceof ServerError) {
                    EventBus.getDefault().post(new AcitivityEvent(false, "ServerError"));
                } else if (error instanceof NetworkError) {
                    EventBus.getDefault().post(new AcitivityEvent(false, "NetworkError"));
                } else if (error instanceof ParseError) {
                    EventBus.getDefault().post(new AcitivityEvent(false, "ParseError"));
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        jsonRequest.setShouldCache(false);
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 2, 2));
        WorkspaceApp.getInstance().addToRequestQueue(jsonRequest);
    }
}

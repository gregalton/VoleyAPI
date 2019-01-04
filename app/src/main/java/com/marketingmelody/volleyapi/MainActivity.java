package com.marketingmelody.volleyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import android.util.Log;

import static android.util.Log.*;
import static com.android.volley.Response.*;

public class MainActivity extends AppCompatActivity {

    private static final String RESPONSE_SUCCESS = "success response: ";
    private static final String RESPONSE_FAILURE = "error response: ";
    private static final String URL = "https://api2.marketingmelody.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e(RESPONSE_SUCCESS, response.toString());
                    }
                },
                new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e(RESPONSE_FAILURE, error.toString());
                        }
                }
        );

        requestQueue.add(arrayRequest);

    }

}

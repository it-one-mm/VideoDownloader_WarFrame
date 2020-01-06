package com.itonemm.videodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class WarFrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_frame);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.warframestat.us/pc/dailyDeals";

// Request a string response from the provided URL.



// Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject object = response.getJSONObject(0);
                            String item = object.getString("item");
                            String time = object.getString("expiry");
                            TextView textView = findViewById(R.id.txt_expire_time);
                            textView.setText("Item:" + item + "\n" + "Time is:\n" + time);
                        }
                        catch (Exception ex)
                        {
                            Log.e("Error",ex.getLocalizedMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(){
            @Override
            public int getCurrentTimeout() {
                return 5000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 5000;
            }

            @Override
            public float getBackoffMultiplier() {
                return super.getBackoffMultiplier();
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
                super.retry(error);
            }

            @Override
            protected boolean hasAttemptRemaining() {
                return super.hasAttemptRemaining();
            }
        });
        queue.add(jsonArrayRequest);
    }
}

package com.example.caculator;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChangeActivity extends AppCompatActivity {
    private static final String TAG = "ChangeActivity";

    public void initData() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://haobaoshui.com:8008/exchangerate/v1/rate?scur=usd&tcur=cny";
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            Log.d(TAG, response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }
}

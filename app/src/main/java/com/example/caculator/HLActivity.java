package com.example.caculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.json.JSONStringer;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HLActivity extends AppCompatActivity {
    private static final String TAG = "HLActivity";
    private EditText ed_from;
    private EditText ed_to;
    private TextView from;
    private TextView to;
    private Button submit;
    private double rate;
    private String update;
    private TextView update_time;

    private void initWidget() {
        ed_from = (EditText) findViewById(R.id.ed_from);
        ed_to = (EditText) findViewById(R.id.ed_to);
        from = (TextView) findViewById(R.id.from);
        to = (TextView) findViewById(R.id.to);
        submit = (Button) findViewById(R.id.submit);
        update_time = (TextView) findViewById(R.id.update);
    }

    private void addEventListener()  {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(ed_from.getText().toString())) {
                        ed_from.setText(String.valueOf(Double.valueOf(ed_to.getText().toString()) / rate));
                }
                if ("".equals(ed_to.getText().toString())) {
                        ed_to.setText(String.valueOf(Double.valueOf(ed_from.getText().toString()) * rate));

                }
            }
        });
    }

    private void initData() {
        String url = "http://t.finlu.com.cn:5000/rate?scur=usd&tcur=cny";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ", e);
                Toast.makeText(HLActivity.this, "服务器开小差了", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                JSONObject jsonObject = JSON.parseObject(res);
                String scur = jsonObject.getString("scur");
                String tcur = jsonObject.getString("tcur");
                 rate = jsonObject.getDouble("rate");
                 update = jsonObject.getString("update");
                 update_time.setText("汇率更新于："+ update);
                from.setText(scur);
                to.setText(tcur);
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hl);
        initWidget();
        addEventListener();
        initData();
    }
}

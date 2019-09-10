package com.example.caculator;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        Toast.makeText(ChangeActivity.this, "启动", Toast.LENGTH_SHORT).show();
    }
}

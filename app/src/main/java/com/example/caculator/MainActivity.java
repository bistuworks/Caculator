package com.example.caculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button num_0;
    private Button num_1;
    private Button num_2;
    private Button num_3;
    private Button num_4;
    private Button num_5;
    private Button num_6;
    private Button num_7;
    private Button num_8;
    private Button num_9;
    private Button dot;
    private Button div_op;
    private Button sub_op;
    private Button multiply_op;
    private Button add_op;
    private Button ac;
    private TextView text_v;
    private TextView text_op;
    private Button equal_op;

    private void initWidget() {
        dot = (Button) findViewById(R.id.dot);
        add_op = (Button) findViewById(R.id.add_op);
        sub_op = (Button) findViewById(R.id.sub_op);
        multiply_op = (Button) findViewById(R.id.multiply_op);
        div_op = (Button) findViewById(R.id.div_op);
        text_v = (TextView) findViewById(R.id.text_v);
        text_op = (TextView) findViewById(R.id.text_op);
        equal_op = (Button) findViewById(R.id.equal_op);
        ac = (Button) findViewById(R.id.ac);
        num_0 = (Button) findViewById(R.id.num_0);
        num_1 = (Button) findViewById(R.id.num_1);
        num_2 = (Button) findViewById(R.id.num_2);
        num_3 = (Button) findViewById(R.id.num_3);
        num_4 = (Button) findViewById(R.id.num_4);
        num_5 = (Button) findViewById(R.id.num_5);
        num_6 = (Button) findViewById(R.id.num_6);
        num_7 = (Button) findViewById(R.id.num_7);
        num_8 = (Button) findViewById(R.id.num_8);
        num_9 = (Button) findViewById(R.id.num_9);
    }

    private void addEventListener() {
        add_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_op.setText(R.string.add_op);
            }
        });
        sub_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_op.setText(R.string.sub_op);
            }
        });
        multiply_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_op.setText(R.string.multiply_op);
            }
        });
        div_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_op.setText(R.string.div_op);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText("");
            }
        });
        equal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        num_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_0.getText());
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_1.getText());
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_2.getText());
            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_3.getText());
            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_4.getText());
            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_5.getText());
            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_6.getText());
            }
        });
        num_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_7.getText());
            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_8.getText());
            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addNum((String) num_9.getText());
            }
        });
    }


    private void addNum(String num) {
        String org_text = (String) text_v.getText();
        switch (num) {
            case "0":
                // 只有当求值字符串为""或者求值字符串的第一个值不为0的情况下才允许添加0到求值字符串中
                if ("".equals(org_text)) {
                    text_v.setText((String) (text_v.getText() + num));
                } else if (!"0".equals(String.valueOf(org_text.charAt(0)))) {
                    text_v.setText((String) (text_v.getText() + num));
                }
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (!"".equals(org_text)) {
                    // 当字符串的第一个数字为0的时候，添加其它数字时会将0删除
                    if ("0".equals(String.valueOf(org_text.charAt(0)))) {
                        text_v.setText(num);
                    } else {
                        text_v.setText((String) (text_v.getText() + num));
                    }
                } else {
                    text_v.setText(num);
                }
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        addEventListener();
    }

}


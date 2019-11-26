package com.example.caculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChangeActivity extends AppCompatActivity {
    private static final String TAG = "ChangeActivity";
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
    private Button m3km3;
    private Button cmm;
    private Button back;
    private Button ac;
    private Button dot;
    private Button ten_to_two;
    private Button ten_to_eight;
    private Button ten_to_16;
    private Button two_to_eight;
    private Button two_to_ten;
    private Button two_to_16;
    private Button eight_to_two;
    private Button eight_to_ten;
    private Button eight_to_16;
    private Button to_two_16;
    private Button to_eight_16;
    private Button to_ten_16;
    private TextView text_v;
    private TextView text_pre;
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private Button E;
    private Button F;


    private void initWidgets() {
        A = (Button) findViewById(R.id.a);
        B = (Button) findViewById(R.id.B);
        C = (Button) findViewById(R.id.C);
        D = (Button) findViewById(R.id.D);
        E = (Button) findViewById(R.id.E);
        F = (Button) findViewById(R.id.F);
        ten_to_two = (Button) findViewById(R.id.ten_to_two);
        ten_to_eight = (Button) findViewById(R.id.ten_to_eight);
        ten_to_16 = (Button) findViewById(R.id.ten_to_16);
        two_to_eight = (Button) findViewById(R.id.two_to_eight);
        two_to_ten = (Button) findViewById(R.id.two_to_ten);
        two_to_16 = (Button) findViewById(R.id.two_to_16);
        eight_to_two = (Button) findViewById(R.id.eight_to_two);
        eight_to_ten = (Button) findViewById(R.id.eight_to_ten);
        eight_to_16 = (Button) findViewById(R.id.eight_to_16);
        to_two_16 = (Button) findViewById(R.id.to_two_16);
        to_eight_16 = (Button) findViewById(R.id.to_eight_16);
        to_ten_16 = (Button) findViewById(R.id.to_ten_16);
        text_v = (TextView) findViewById(R.id.text_v);
        text_pre = (TextView) findViewById(R.id.text_pre);
        cmm = (Button) findViewById(R.id.cmm);
        dot = (Button) findViewById(R.id.dot);
        ac = (Button) findViewById(R.id.ac);
        back = (Button) findViewById(R.id.back);
        m3km3 = (Button) findViewById(R.id.m3km3);
        cmm = (Button) findViewById(R.id.cmm);
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

    private String ten_to_2(int num) {
        ArrayList seq = new ArrayList<>();
        int m = num / 2;
        while (m != 0) {
            int mod = num % 2;
            m = num / 2;
            num = m;
            seq.add(mod);
        }
        String ret = "";
        for (int i = seq.size() - 1; i >= 0; i--) {
            ret += seq.get(i);
        }
        return ret;
    }

    private String ten_to_eight(int num) {
        String two_str = ten_to_2(num);
        return two_to_eight(two_str);
    }

    private String eight_to_two(String eight_num) {
        String return_ret = "";
        for (int i = 0; i < eight_num.length(); i++) {
            switch (eight_num.charAt(i)) {
                case '0':
                    return_ret += "000";
                    break;
                case '1':
                    return_ret += "001";
                    break;
                case '2':
                    return_ret += "010";
                    break;
                case '3':
                    return_ret += "011";
                    break;
                case '4':
                    return_ret += "100";
                    break;
                case '5':
                    return_ret += "101";
                    break;
                case '6':
                    return_ret += "110";
                    break;
                case '7':
                    return_ret += "111";
            }
        }
        return return_ret;
    }

    private String to_two_16(String num_16) {
        String return_ret = "";
        for (int i = 0; i < num_16.length(); i++) {
            switch (num_16.charAt(i)) {
                case '0':
                    return_ret += "0000";
                    break;
                case '1':
                    return_ret += "0001";
                    break;
                case '2':
                    return_ret += "0010";
                    break;
                case '3':
                    return_ret += "0011";
                    break;
                case '4':
                    return_ret += "0100";
                    break;
                case '5':
                    return_ret += "0101";
                    break;
                case '6':
                    return_ret += "0110";
                    break;
                case '7':
                    return_ret += "0111";
                    break;
                case '8':
                    return_ret += "1000";
                    break;
                case '9':
                    return_ret += "1001";
                    break;
                case 'A':
                    return_ret += "1010";
                    break;
                case 'B':
                    return_ret += "1011";
                    break;
                case 'C':
                    return_ret += "1100";
                    break;
                case 'D':
                    return_ret += "1101";
                    break;
                case 'E':
                    return_ret += "1110";
                    break;
                case 'F':
                    return_ret += "1111";
            }
        }
        return return_ret;
    }

    private String two_to_eight(String two_str) {
        if (two_str.length() % 3 == 1) {
            two_str = "00" + two_str;
        } else if (two_str.length() % 3 == 2) {
            two_str = "0" + two_str;
        }
        String return_ret = "";
        for (int i = 0; i < two_str.length(); i += 3) {
            String three_str = two_str.substring(i, i + 3);
            String ret = "";
            switch (three_str) {
                case "000":
                    ret = "0";
                    break;
                case "001":
                    ret = "1";
                    break;
                case "010":
                    ret = "2";
                    break
                            ;
                case "011":
                    ret = "3";
                    break;
                case "100":
                    ret = "4";
                    break;
                case "101":
                    ret = "5";
                    break;
                case "110":
                    ret = "6";
                    break;
                case "111":
                    ret = "7";
                    break;
            }
            return_ret += ret;
        }
        return return_ret;
    }

    private String two_to_16(String two_str) {
        if (two_str.length() % 4 == 1) {
            two_str = "000" + two_str;
        } else if (two_str.length() % 4 == 2) {
            two_str = "00" + two_str;
        } else if (two_str.length() % 4 == 3) {
            two_str = "00" + two_str;
        }
        String return_ret = "";
        for (int i = 0; i < two_str.length(); i += 4) {
            String four_str = two_str.substring(i, i + 4);
            String ret = "";
            switch (four_str) {
                case "0000":
                    ret = "0";
                    break;
                case "0001":
                    ret = "1";
                    break;
                case "0010":
                    ret = "2";
                    break
                            ;
                case "0011":
                    ret = "3";
                    break;
                case "0100":
                    ret = "4";
                    break;
                case "0101":
                    ret = "5";
                    break;
                case "0110":
                    ret = "6";
                    break;
                case "0111":
                    ret = "7";
                    break;
                case "1000":
                    ret = "8";
                    break;
                case "1001":
                    ret = "9";
                    break;
                case "1010":
                    ret = "A";
                    break;
                case "1011":
                    ret = "B";
                    break;
                case "1100":
                    ret = "C";
                    break;
                case "1101":
                    ret = "D";
                    break;
                case "1110":
                    ret = "E";
                    break;
                case "1111":
                    ret = "F";
                    break;

            }
            return_ret += ret;
        }
        return return_ret;
    }

    private String ten_to_16(int num) {
        String two_str = ten_to_2(num);
        return two_to_16(two_str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return true;
    }

    private void addEventListener() {
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "A");
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "B");
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "C");
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "D");
            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "E");
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "F");
            }
        });
        ten_to_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        String ret = ten_to_2(Integer.valueOf(org_text));
                        text_pre.setText("十进制" + org_text + "转换为二进制是" + Integer.toBinaryString(Integer.valueOf(org_text)));
                        text_v.setText("");
                    }
                }
            }
        });

        ten_to_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("十进制" + org_text + "转换为八进制是" + Integer.toOctalString(Integer.valueOf(org_text)));
                        text_v.setText("");
                    }
                }
            }
        });
        ten_to_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("十进制" + org_text + "转换为十六进制是" + Integer.toHexString(Integer.valueOf(org_text)));
                        text_v.setText("");
                    }
                }
            }
        });
        two_to_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("二进制" + org_text + "转换为八进制是" + two_to_eight(org_text));
                        text_v.setText("");
                    }
                }
            }
        });
        two_to_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("二进制" + org_text + "转换为十进制是" + (Integer.valueOf(org_text, 2).toString()));
                        text_v.setText("");
                    }
                }
            }
        });
        two_to_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("二进制" + org_text + "转换为十六进制是" + two_to_16(org_text));
                        text_v.setText("");
                    }
                }
            }
        });
        eight_to_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("八进制" + org_text + "转换为二进制是" + eight_to_two(org_text));
                        text_v.setText("");
                    }
                }
            }
        });
        eight_to_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("八进制" + org_text + "转换为十进制是" + Integer.valueOf(org_text, 8).toString());
                        text_v.setText("");
                    }
                }
            }
        });
        eight_to_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("八进制" + org_text + "转换为十六进制是" + two_to_16(eight_to_two(org_text)));
                        text_v.setText("");
                    }
                }
            }
        });
        to_eight_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("十六进制" + org_text + "转换为八进制是" + two_to_eight(to_two_16(org_text)));
                        text_v.setText("");
                    }
                }
            }
        });
        to_two_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("十六进制" + org_text + "转换为二进制是" + to_two_16(org_text));
                        text_v.setText("");
                    }
                }
            }
        });
        to_ten_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    if (org_text.contains(".")) {
                        Toast.makeText(ChangeActivity.this, "不支持小数点转换", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        text_pre.setText("十进制" + org_text + "转换为十六进制是" + Integer.valueOf(to_two_16(org_text), 2).toString());
                        text_v.setText("");
                    }
                }
            }
        });
        num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "0");
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "1");
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "2");
            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "3");
            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "4");
            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "5");
            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "6");
            }
        });
        num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "7");
            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "8");
            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText(text_v.getText().toString() + "9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!org_text.contains(".")) {
                    text_v.setText(text_v.getText().toString() + ".");
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_v.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org_text = text_v.getText().toString();
                if (!"".equals(org_text)) {
                    text_v.setText(org_text.substring(0, org_text.length() - 1));
                }
            }
        });
        cmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteText = text_v.getText().toString();
                double b = Double.valueOf(excuteText);
                double b2 = b / 100;
                text_pre.setText(b + "cm" + " = " + b2 + "m");
                text_v.setText("");
            }
        });
        m3km3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteText = text_v.getText().toString();
                double b = Double.valueOf(excuteText);
                double b2 = b / 1000 / 1000;
                text_pre.setText(b + "m3" + " = " + b2 + "km3");
                text_v.setText("");
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        initWidgets();
        addEventListener();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Log.d(TAG, "菜单项1");
                return true;
            case R.id.item2:
                Intent intent = new Intent(ChangeActivity.this, HLActivity.class);
                startActivity(intent);
                return true;
            default:
                Log.d(TAG, "default");
                return false;
        }
    }


}

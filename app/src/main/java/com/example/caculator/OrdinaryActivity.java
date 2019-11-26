package com.example.caculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class OrdinaryActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String ADD_OP = "+";
    public static final String SUB_OP = "-";
    public static final String MULTIPLY_OP = "×";
    public static final String DIV_OP = "÷";
    public static final String DOT_STRING = ".";
    public static final String PERCENT = "%";

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
    private Button percent;
    private Button ac;
    private Button back;
    private TextView text_v;
    private TextView text_v2;
    private TextView text_res;
    private TextView text_op;
    private Button equal_op;
    private Button change;

    private void acAction() {
        text_v.setText("");
        text_op.setText("");
        text_v2.setText("");
        text_res.setText("");
    }


    private void initWidget() {
        dot = (Button) findViewById(R.id.dot);
        add_op = (Button) findViewById(R.id.add_op);
        sub_op = (Button) findViewById(R.id.sub_op);
        multiply_op = (Button) findViewById(R.id.multiply_op);
        div_op = (Button) findViewById(R.id.div_op);
        text_v = (TextView) findViewById(R.id.text_v);
        text_v2 = (TextView) findViewById(R.id.text_v2);
        text_op = (TextView) findViewById(R.id.text_op);
        text_res = (TextView) findViewById(R.id.text_res);
        equal_op = (Button) findViewById(R.id.equal_op);
        ac = (Button) findViewById(R.id.ac);
        back = (Button) findViewById(R.id.back);
        percent = (Button) findViewById(R.id.percent);
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
        change = (Button) findViewById(R.id.change);
    }

    /**
     * 将计算结果整合成计算表达式，并存储在历史记录中
     * @param res 计算结果
     */
    private void setResText(double res) {
        String resString = String.valueOf(res);
        int dotIndex = resString.indexOf(".");
        String tail = resString.substring(dotIndex + 1, resString.length());
        if (new BigDecimal(tail).equals(new BigDecimal("0"))) {
            resString = resString.substring(0, dotIndex);
        }
        text_res.setText(resString);
    }

    private TextView getCurrentTextView() {
        TextView textView;
        if ("".equals(text_op.getText().toString())) {
            textView = text_v;
        } else {
            textView = text_v2;
        }
        return textView;
    }

    private void handleNumClick(Button num) {
        TextView textView = getCurrentTextView();
        if (!textView.getText().toString().contains(PERCENT)) {
            if (!"".equals(text_res.getText().toString())) {
                acAction();
            }
        }
        addNum((String) num.getText());
    }

    private void addEventListener() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getCurrentTextView();
                String textViewString = textView.getText().toString();
                if (!"".equals(textViewString)) {
                    if (textViewString.equals("0" + PERCENT)) {
                        textView.setText("");
                    } else if (textViewString.equals("0" + DOT_STRING)) {
                        textView.setText("");
                    } else {
                        if ("".equals(text_v.getText().toString()) | "".equals(text_op.getText().toString()) | "".equals(text_v2.getText().toString()) | "".equals(text_res.getText().toString())) {
                            textView.setText(textViewString.substring(0, textViewString.length() - 1));
                        }
                    }
                }

            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getCurrentTextView();
                String orgText = textView.getText().toString();
                if (!orgText.contains(PERCENT)) {
                    if ("".equals(orgText)) {
                        textView.setText("0" + PERCENT);
                    } else {
                        textView.setText(textView.getText() + PERCENT);
                    }
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getCurrentTextView();
                String org_text = textView.getText().toString();
                if (!org_text.contains(DOT_STRING)) {
                    String setText = "";
                    if ("".equals(textView.getText().toString())) {
                        setText = "0" + DOT_STRING;
                    } else {
                        if (org_text.contains(PERCENT)) {
                            setText = org_text.substring(0, org_text.length() - 1) + DOT_STRING + PERCENT;
                        } else {
                            setText = org_text + DOT_STRING;
                        }
                    }
                    textView.setText(setText);
                }
            }
        });
        add_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 进行连续操作
                String textResContent = text_res.getText().toString();
                if (!"".equals(textResContent)) {
                    text_v.setText(textResContent);
                    text_v2.setText("");
                } else {
                    // 调用计算逻辑
                    equal_op.callOnClick();
                    text_v.setText(text_res.getText().toString());
                    text_v2.setText("");
                    text_res.setText("");
                }
                text_op.setText(R.string.add_op);
            }
        });
        sub_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textResContent = text_res.getText().toString();
                if (!"".equals(textResContent)) {
                    text_v.setText(textResContent);
                    text_v2.setText("");
                }

                if ("".equals(text_v.getText().toString())) {
                    text_v.setText("-");
                } else {
                    text_op.setText(R.string.sub_op);
                }
            }
        });
        multiply_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textResContent = text_res.getText().toString();
                if (!"".equals(textResContent)) {
                    text_v.setText(textResContent);
                    text_v2.setText("");
                }
                text_op.setText(R.string.multiply_op);
            }
        });
        div_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textResContent = text_res.getText().toString();
                if (!"".equals(textResContent)) {
                    text_v.setText(textResContent);
                    text_v2.setText("");
                }
                text_op.setText(R.string.div_op);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acAction();
            }
        });
        equal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1;
                double num2;
                double res;
                // 解决两个操作数为空出现的闪退问题
                String textVString = text_v.getText().toString();
                String textV2String = text_v2.getText().toString();
                if ("".equals(textVString)) {
                    textVString = "0";
                }
                if ("".equals(textV2String)) {
                    textV2String = "0";
                }
                if (textVString.contains(PERCENT)) {
                    textVString = textVString.substring(0, textVString.length() - 1);
                    num1 = Double.valueOf(textVString);
                    num1 /= 100;
                } else {
                    num1 = Double.valueOf(textVString);
                }
                if (textV2String.contains(PERCENT)) {
                    textV2String = textV2String.substring(0, textV2String.length() - 1);
                    num2 = Double.valueOf(textV2String);
                    num2 /= 100;
                } else {
                    num2 = Double.valueOf(textV2String);
                }
                switch (text_op.getText().toString()) {
                    case ADD_OP:
                        res = CalculateUtils.add(num1, num2);
                        setResText(res);
                        break;
                    case SUB_OP:
                        res = CalculateUtils.sub(num1, num2);
                        setResText(res);
                        break;
                    case MULTIPLY_OP:
                        res = CalculateUtils.multiply(num1, num2);
                        setResText(res);
                        break;
                    case DIV_OP:
                        try {
                            res = CalculateUtils.div(num1, num2);
                            setResText(res);
                        } catch (ArithmeticException e) {
                            String errMsg = "除数不能为零";
                            Toast.makeText(OrdinaryActivity.this, errMsg, Toast.LENGTH_SHORT).show();
                            Log.e(TAG, e.getMessage());
                        }
                        break;
                    default:
                        String errMSg = "非法操作符";
                        Log.e(TAG, errMSg);
                        text_res.setText(errMSg);
                }
            }
        });
        num_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_0);
            }
        });
        num_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_1);
            }
        });
        num_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_2);
            }
        });
        num_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_3);
            }
        });
        num_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_4);
            }
        });
        num_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_5);
            }
        });
        num_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_6);
            }
        });
        num_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_7);
            }
        });
        num_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_8);
            }
        });
        num_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleNumClick(num_9);
            }
        });
    }


    private void addNum(String num) {
        TextView setTextView = getCurrentTextView();
        String org_text = (String) setTextView.getText();
        String org_text_pre = org_text;
        switch (num) {
            case "0":
                // 只有当求值字符串为""或者求值字符串的第一个值不为0的情况下才允许添加0到求值字符串中
                if ("".equals(org_text)) {
                    setTextView.setText((String) (setTextView.getText() + num));
                } else {
                    if (org_text.length() >= 2) {
                        if ("0".equals(String.valueOf(org_text.charAt(0)))) {
                            if (DOT_STRING.equals(String.valueOf(org_text.charAt(1))))
                                setTextView.setText((String) (setTextView.getText() + num));
                        } else {
                            setTextView.setText((String) (setTextView.getText() + num));
                        }
                    } else {
                        if (!"0".equals(String.valueOf(org_text.charAt(0)))) {
                            setTextView.setText((String) (setTextView.getText() + num));
                        }
                    }
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
                if ("".equals(org_text)) {
                    setTextView.setText((String) (setTextView.getText() + num));
                } else {
                    if (org_text.length() >= 2) {
                        // 处理百分号的情况
                        if (org_text.contains(PERCENT)) {
                            if ("-".equals(String.valueOf(org_text.charAt(0)))){
                                org_text = org_text_pre.substring(1, org_text_pre.length() - 1);
                            }
                            if ("0".equals(String.valueOf(org_text.charAt(0)))) {
                                setTextView.setText(num + PERCENT);
                            } else {
                                String t = org_text_pre.substring(0, org_text.length() - 1) + num + PERCENT;
                                setTextView.setText(t);
                            }
                        } else {
                            setTextView.setText(org_text_pre + num);
                        }
                    } else {
                        // 当字符串的第一个数字为0的时候，添加其它数字时会将0删除
                        if ("0".equals(String.valueOf(org_text.charAt(0)))) {
                            setTextView.setText((String) (num));
                        } else {
                            setTextView.setText((String) (setTextView.getText() + num));
                        }
                    }
                }
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        initWidget();
        addEventListener();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent intent = new Intent(OrdinaryActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}


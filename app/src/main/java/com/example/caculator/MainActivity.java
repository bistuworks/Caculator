package com.example.caculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button change;
    private TextView textExp;
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button sin;
    private Button cos;
    private Button power;
    private Button radical_sign;
    private Button ac;
    private Button equal_op;
    private Button back;
    private Button div_op;
    private Button add_op;
    private Button sub_op;
    private Button dot;
    private Button multiply_op;
    private TextView org;
    private Button left_bracket;
    private Button right_bracket;
    private Button lg;
    private Button ln;
    private Button reciprocal;
    private Button factorial;
    private Button percent;

    private Button tan;

    private void initWidgets() {
        tan = (Button) findViewById(R.id.tan);
        left_bracket = (Button) findViewById(R.id.left_bracket);
        right_bracket = (Button) findViewById(R.id.right_bracket);
        org = (TextView) findViewById(R.id.org);
        div_op = (Button) findViewById(R.id.div_op);
        add_op = (Button) findViewById(R.id.add_op);
        sub_op = (Button) findViewById(R.id.sub_op);
        multiply_op = (Button) findViewById(R.id.multiply_op);
        dot = (Button) findViewById(R.id.dot);
        equal_op = (Button) findViewById(R.id.equal_op);
        back = (Button) findViewById(R.id.back);
        ac = (Button) findViewById(R.id.ac);
        change = (Button) findViewById(R.id.change);
        textExp = (TextView) findViewById(R.id.text_exp);
        num0 = (Button) findViewById(R.id.num_0);
        num1 = (Button) findViewById(R.id.num_1);
        num2 = (Button) findViewById(R.id.num_2);
        num3 = (Button) findViewById(R.id.num_3);
        num4 = (Button) findViewById(R.id.num_4);
        num5 = (Button) findViewById(R.id.num_5);
        num6 = (Button) findViewById(R.id.num_6);
        num7 = (Button) findViewById(R.id.num_7);
        num8 = (Button) findViewById(R.id.num_8);
        num9 = (Button) findViewById(R.id.num_9);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        power = (Button) findViewById(R.id.power);
        radical_sign = (Button) findViewById(R.id.radical_sign);
        lg = (Button) findViewById(R.id.lg);
        ln = (Button) findViewById(R.id.ln);
        reciprocal = (Button) findViewById(R.id.reciprocal);
        factorial = (Button) findViewById(R.id.factorial);
        percent = (Button) findViewById(R.id.percent);
    }

    /**
     * 数n的阶乘
     * @param n
     * @return
     */
    private int doFactorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 | n == 1) {
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    private void addEventListener() {
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Double.valueOf(excuteData) / 100;
                org.setText( excuteData + "% " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.log10(Double.valueOf(excuteData));
                org.setText("lg(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.log(Double.valueOf(excuteData));
                org.setText("lg(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        reciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = 1 / (Double.valueOf(excuteData));
                org.setText("1/" + excuteData + "= " + String.format("%f", res));
                textExp.setText("");
            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                int res = doFactorial(Integer.valueOf(excuteData));
                org.setText(excuteData + "!" + "= " + String.format("%d", res));
                textExp.setText("");
            }
        });
        left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "(");
            }
        });
        right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + ")");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + ".");
            }
        });
        add_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "+");
            }
        });
        sub_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "-");
            }
        });
        multiply_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "×");
            }
        });
        div_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "÷");
            }
        });
        equal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (org.getText().toString().contains("^")) {
                    power.callOnClick();
                } else {
                    String orgText = textExp.getText().toString();
                    String excuteText = orgText;
                    excuteText = excuteText.replace("÷", "/");
                    excuteText = excuteText.replace("×", "*");
                    try {
                        double res = Util.executeExpression(excuteText + "=");
                        org.setText(orgText + " = " + String.valueOf(res));
                        textExp.setText("");
                    } catch (Exception e) {
                        try {
                            double res = Double.valueOf(orgText);
                            org.setText(orgText + " = " + String.valueOf(res));
                            textExp.setText("");
                        } catch (Exception e1) {
//                            textExp.setText("");
                            Toast.makeText(MainActivity.this, "表达式输入异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textExpString = textExp.getText().toString();
                if (!"".equals(textExpString)) {
                    textExp.setText(textExpString.substring(0, textExpString.length() - 1));
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num0.getText().toString());
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num1.getText().toString());
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num2.getText().toString());
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num3.getText().toString());
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num4.getText().toString());
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num5.getText().toString());
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num6.getText().toString());
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num7.getText().toString());
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num8.getText().toString());
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num9.getText().toString());
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.sin(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("sin(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.cos(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("cos(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.tan(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("tan(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if (org.getText().toString().contains("^")) {
                    double num1 = Double.valueOf(org.getText().toString().substring(0, org.getText().toString().indexOf("^")));
                    double num2 = Double.valueOf(textExp.getText().toString());
                    org.setText(num1 + "^" + num2 + " = " + Math.pow(num1, num2));
                } else {
                    org.setText(excuteData + "^");
                }
                textExp.setText("");
            }
        });
        radical_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.sqrt(Double.valueOf(excuteData));
                org.setText("√" + excuteData + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        addEventListener();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(MainActivity.this, OrdinaryActivity.class);
            startActivity(intent);
        }
    }
}

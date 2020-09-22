package com.example.assingment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5;
    EditText edtNum1,edtNum2;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);

        tvResult = (TextView)findViewById(R.id.tvResult);

        edtNum1 = (EditText)findViewById(R.id.edtNum1);
        edtNum2 = (EditText)findViewById(R.id.edtNum2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNum1.getText().length() == 0 && edtNum2.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int iResult = num1 + num2;
                    tvResult.setText("계산 결과 :" + iResult);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNum1.getText().length() == 0 && edtNum2.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int iResult = num1 - num2;
                    tvResult.setText("계산 결과 :" + iResult);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNum1.getText().length() == 0 && edtNum2.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int iResult = num1 * num2;
                    tvResult.setText("계산 결과 :" + iResult);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNum1.getText().length() == 0 && edtNum2.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int iResult = num1 / num2;
                    tvResult.setText("계산 결과 :" + iResult);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNum1.getText().length() == 0 && edtNum2.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(edtNum1.getText().toString());
                    int num2 = Integer.parseInt(edtNum2.getText().toString());
                    int iResult = num1 % num2;
                    tvResult.setText("계산 결과 :" + iResult);
                }
            }
        });



    }
}

package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnPlus;
    TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnPlus = (Button) findViewById(R.id.btn1);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edtNum1.getText().toString());
                int num2 = Integer.parseInt(edtNum2.getText().toString());

                int iResult = num1 + num2 ;
                tvResult.setText("계산 결과 : "+iResult);
                //위와같은 사용방법이 있고 아래와 같은 사용 방법이 있음
                //tvResult.setText(tvResult.getText().toString()+iResult);


            }
        });

    }
}

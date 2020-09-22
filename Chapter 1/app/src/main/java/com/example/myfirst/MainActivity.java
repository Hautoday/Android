package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // R은 리소스
        btn = (Button) findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast 클래스를 이용하여 토스트 객체를 생설할 수 있다 .
                // context : 안드로이드 프로그램에서는 프로그램의 정보 (주인)
                // 그러나 context를 this로 사용하면 안되는 경우가 많다.
                // 따라서 정확한 컨텍스트 값을 지정해 주어야 한다.
                // getApplicationContext() 함수로 context 값을 얻을 수 있다.
                Toast.makeText(getApplicationContext(), "안드로이드 시작",Toast.LENGTH_SHORT).show();


            }
        });

    }



}

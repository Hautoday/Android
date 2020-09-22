package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MyTag", "onCreate()호출");
    }

    @Override
    protected void onResume() { //액티비티 활성화 시 호출되는 함수
        // 실제 서비스를 위한 코드를 작성한다.
        super.onResume();
        Log.i("MyTag", "onResume() 호출");
    }

    @Override
    protected void onPause() { // 액티비티 비활성화 시 호출되는 함수
        //실행중인 서비스를 일시 중지하는 코드를 작성한다.
        super.onPause();
        Log.i("MyTag", "onPause() 호출");
    }

    @Override
    protected void onDestroy() { // 액티비티 종료 시 호출되는 함수
        // 실행중인 코드의 정리작업 코드를 작성한다.
        super.onDestroy();
        Log.i("MyTag", "onDestroy() 호출");
    }
}

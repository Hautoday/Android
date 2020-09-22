package com.example.musicservicesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 서비스 프로그래밍은 인텐트 메세지를 이용한다.
    // 서비스를 등록하는 인텐트 메시지가 필요하다.
    // 서비스 등록을 위한 인텐트 객체 선언
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("myTag", "액티비티 onCreate() 호출");

        // 명시적 인텐트 : 서비스 클래스의 이름을 알고있다.
        intent = new Intent(this,MediaService.class);
    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.serivce:
//                서비스를 실행하는 코드 작성
                Log.i("myTag", "Start 버튼 클릭");
//                명시적 인텐트를 통해 서비스를 시작하는 메서드
                startService(intent);
//                서비스 클래스의 onCreate() => onStartCommend()메서드가 호출된다
                Toast.makeText(getApplicationContext(), "서비스 시작", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Stop:
//                서비스를 중지하는 코드 작성
                Log.i("myTag", "Stop 버튼 클릭");
                stopService(intent);
                Toast.makeText(getApplicationContext(), "서비스 종료", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

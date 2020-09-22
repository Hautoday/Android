package com.example.optionmenusample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout baseLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = findViewById(R.id.bassLayout);


    }
//    옵션 메뉴 생성 및 등록에 사용되는 함수
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        1. 공기주입기 생성 ( inflater 생성 )
//        2. 메뉴 풍선 주입 (menu XML 을 menu 로 준비한다.)
//        3. 동시에 공기 주입 ( menu가 실체회 된다. )
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);

    }
//    메튜에서 특정 아이템이 선택될떄 반응하는 핸들러
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
            break;
            case R.id.itemBlack:
                baseLayout.setBackgroundColor(Color.BLACK);
            break;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
            break;
            case R.id.itemViolet:
                baseLayout.setBackgroundColor(Color.RED);
            break;
            case R.id.itemtoast:
                Toast.makeText(getApplicationContext(), "메뉴에서 실행된 토스트먹고싶다!", Toast.LENGTH_SHORT).show();
            break;


        }

        return super.onOptionsItemSelected(item);
    }
}
//    단축키 : alt + insert => 코드 도움 메뉴 전체
//    단축키 : ctri + o => override 리스트 메뉴
//    단축키 : alt + enter => 자동 import 자동 완성등 많이쓰임


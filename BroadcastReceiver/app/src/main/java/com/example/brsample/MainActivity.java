package com.example.brsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //BroadcastReceiver br;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(br,intentFilter); // 수신기 등록 BR 되는 광고 메세지를 수신을 시작한다.

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br); // 수신기 등록 해제 : BR을 수신하지 않는다.
    }

    // 브로드캐스트 리시버는 사용할떄 등록하고 사용하지 않을때 해제한다.
    BroadcastReceiver br = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction(); // 액션은 문자열 정보를 가지고 있다.

            if(action.equals(intent.ACTION_BATTERY_CHANGED)){
                int iLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                Toast.makeText(getApplicationContext(), "배터리 상태 변화 : "+iLevel , Toast.LENGTH_SHORT).show();
            }
            else if(action.equals(Intent.ACTION_USER_PRESENT)){
                Toast.makeText(getApplicationContext(), "화면 켜짐", Toast.LENGTH_SHORT).show();
            }
        }
    };
}

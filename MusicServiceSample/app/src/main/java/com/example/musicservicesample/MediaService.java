package com.example.musicservicesample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MediaService extends Service {
    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("myTag", "onCreate() 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("myTag", "onStartCommand() 호출");
//        서비스 실행 코드를 작성하는 영역
        mp = MediaPlayer.create(this,R.raw.some);
        mp.start();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("myTag", "onDestroy() 호출");


    }
}

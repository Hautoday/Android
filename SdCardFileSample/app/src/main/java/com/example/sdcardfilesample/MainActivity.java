package com.example.sdcardfilesample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);

//        안드로이드 6버전 이상부터 사용자가 허가권을 수락하는 창을 띄워야한다.
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.read:
                readData();
                break;
            case R.id.btnMKdir:
                MKforder();
                break;
        }
    }
    public void MKforder(){
//        sd 카드의 경로를 받아온다
        String strPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        edt1.setText(strPath);

        File myDir = new File(strPath + ".myDir");
        myDir.mkdir();
        myDir.delete();

    }
    public void readData(){
//        flieinputStream 으로 파일을 읽어온 결과를 반환한다.
//        fileinputStream 객체를 생성해서 파일을 연다
//        byte 형태로 읽어온다. 즉 바이트 공간이 필요하다.
//        읽기는 read() 메서드를 사용한다.
//        사용이 완료되면 반드시 close() 한다.
        try {
            FileInputStream fis = new FileInputStream("/storage/emulated/0/sd_data.txt");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            edt1.setText(new String(data));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

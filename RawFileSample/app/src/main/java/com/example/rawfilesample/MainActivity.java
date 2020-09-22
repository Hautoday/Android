package com.example.rawfilesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText Edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edt1 = findViewById(R.id.Edt1);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn1:
                readData();
                break;
        }
    }

    public void readData(){
    // 자원을 얻는다.
    // 해당 자원으로 부터 파일을 연다
    // 열린 파일은 stream 구조로 반환된다
    // 읽기 전용임으로 InputStream 구조가 반환돤다
        InputStream is = getResources().openRawResource(R.raw.text);
    // 읽기 작업 수행
        try{
            byte[] data = new byte[is.available()];
            is.read(data);
            String str = new String (data);
            Edt1.setText(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 닫기 작업 수행

    }
}

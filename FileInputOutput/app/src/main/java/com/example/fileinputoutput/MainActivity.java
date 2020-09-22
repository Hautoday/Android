package com.example.fileinputoutput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListener;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.Edt1);
    }


    public void onClick(View v){
        switch(v.getId()) {
            case R.id.BtnRead:
                readData();
                break;
            case R.id.BtnWrite:
                writeData();
                break;

        }
    }
    public void writeData(){
        try {
            //쓰기모드 파일 열기
            FileOutputStream fos = openFileOutput("text.txt",MODE_PRIVATE);

            fos.write(str.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            //파일열기
            FileInputStream fis = openFileInput("text.txt");
            //읽을 파일의 공간을 생성
            byte[] data = new byte[50];
            fis.read(data); // read()메서드의 괄호 사이에 읽은 파일의 내용을 보관할 공간을 지정한다.
//            byte 타입의 데이터를 string 타입으로 변환해야 문자열을 읽을수 있다.
            String str = new String(data);
            //내용 표시
            edt1.setText(str);
            //파일 닫기
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

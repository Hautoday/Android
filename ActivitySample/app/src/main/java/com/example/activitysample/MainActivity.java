package com.example.activitysample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName ,edtNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.isekai:
                callsecond();
                break;
            case R.id.btnSendValue:
                sendValue();
                break;
            case R.id.getRetuen:
                getReturn();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        이 메서드는 값을 전달받은 두번째 엑티비티에서 값을 반환하면 자동으로 호출된다
//        괄호 사이의 마지막 매개변수를 보면 intent 타입의 반환 값이 있다.
//        즉 data 매개변수에 반환된 결과가 포함되어 호출된다.
//        data에서 get*extra() 함수를 이용하여 값을 꺼낼수 있다.

        int iResult = data.getIntExtra("result",0);
        Toast.makeText(getApplicationContext(), "제곱결과 : "+iResult, Toast.LENGTH_SHORT).show();



    }

    public void sendValue() {
//    1.edtName의 값을 얻어온다.
        String str = edtName.getText().toString();
        int num = Integer.parseInt(edtNum.getText().toString());
        Intent intent = new Intent (getApplicationContext(),SecondsActivity.class);
//    3.intent 메세지의 값을 담는다.
        intent.putExtra("username",str); // 현재 putExtra()로 문자열을 담았다.
        intent.putExtra("number",num);
//    4.발송한다.
        startActivity(intent);
    }

    public void callsecond(){
//        두번쨰 엑티비티를 호출하기 위해서 intent 메세지 기능을 사용한다.
//        intent 클래스로 인스턴스를 생성하고 startActivity() 메서드에 해당 인텐트를 담아 전송한다.
//        intent() 생성자의 매개변수 1번은 content 정보, 2번은 띄우고자 하는 activity 이름
          Intent intent = new Intent(getApplicationContext(),SecondsActivity.class);
//        위에서 생성한 인텐트 메세지를 발송한다.
          startActivity(intent);
    }

    public void getReturn(){
        int num1 = Integer.parseInt(edtNum.getText().toString());
        Intent intent = new Intent(getApplicationContext(),SecondsActivity.class);
        intent.putExtra("num",num1);
        startActivityForResult(intent, 0);
    }
}

package com.example.activitysample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondsActivity extends AppCompatActivity {
    TextView tvRecvData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvRecvData = findViewById(R.id.tvRecvData);

        //주의사항 : 현재 엑티비티가 호출에 의해서 실행된 경우 해당 메세지인 intent를 얻어와야한다.
        //이렇게 얻어온 메세지를 intent 클래스 타입의 변수에 저장한다.
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("username");
//        Integer num = intent.getIntExtra("number",0);
//        tvRecvData.setText("전달 받은 값 : "+str+num);
    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn1:
                finish(); // 현재 엑티비티 종료 함수
                break;
            case R.id.btnRetuen:
                getReturn();
                break;
        }
    }
    public void getReturn(){
        Intent intent = getIntent();
        int iNum = intent.getIntExtra("num",0);
        int iResult = iNum*iNum;
//        결과를 반환해줘야 함으로 추가적인 intent 메세지가 필요하다
        Intent intentOut = new Intent(getApplicationContext(),MainActivity.class);
        intentOut.putExtra("result",iResult);
//        첫번째 엑티비티로 값을 반환한다.
//        첫번째 엑티비티는 이미 실행되어 두번째 엑티비티 뒤에 가려져있는 상태이다.
//        따라서 startActivity()로 새로 시작하는 것이 아니다.
//        결과를 세팅하는 아래 함수를 이용하여 첫번째 엑티비티로 값을 전달한다.
//        즉 두번쨰 엑티비티는 아직 화면에 자리잡고 실행중인 상태이다.
//        따라서 두번째 엑티비티를 종료할 필요가 있다.
        setResult(RESULT_OK,intentOut);
        finish();
    }


}

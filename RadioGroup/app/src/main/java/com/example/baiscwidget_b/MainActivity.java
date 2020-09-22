package com.example.baiscwidget_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgroup;
    Button btnFin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgroup = (RadioGroup)findViewById(R.id.r1);
        btnFin = (Button)findViewById(R.id.btn1);

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rdoJava:
                        Toast.makeText(getApplicationContext(),"지바 버튼 눌렸습니다",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoAnd:
                        Toast.makeText(getApplicationContext(),"안드로이드 버튼 눌렸습니다",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch ( rgroup.getCheckedRadioButtonId()){
                    case R.id.rdoJava:
                        Toast.makeText(getApplicationContext(),"자바 버튼 눌렸습니다",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoAnd:
                        Toast.makeText(getApplicationContext(),"안드로이드 버튼 눌렸습니다",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        });


    }


    // 매개변수 v에 어떠한 뷰에서 호출이 된것인지 정보가 담겨있다

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn11:
                Toast.makeText(getApplicationContext(), "XML에서 버튼1 호출", Toast.LENGTH_SHORT).show();
                break;
                case R.id.btn22:
                    Toast.makeText(getApplicationContext(), "XML에서 버튼2 호출", Toast.LENGTH_SHORT).show();
                break;
                case R.id.btn33:
                    Toast.makeText(getApplicationContext(), "XML에서 버튼3 호출", Toast.LENGTH_SHORT).show();
                break;
                default:

        }

    }
}

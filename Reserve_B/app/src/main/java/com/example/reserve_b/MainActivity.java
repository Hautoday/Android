package com.example.reserve_b;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnEnd;
    RadioGroup rgroup;
    LinearLayout linear1, linear2;
    Chronometer Chrono;
    DatePicker DateP;
    TextView tvResult;
    TimePicker timePick;
    String strResult;
    int iYear = 0, iMonth = 0, iDaymonth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        스크롤 뷰의 테스트 확인하는 코드
//        setContentView(R.layout.scroll_test);
        //버튼 시작과 종료의 동작 코드
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        rgroup = (RadioGroup) findViewById(R.id.rgroup);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        Chrono = (Chronometer) findViewById(R.id.Chono);
        DateP = (DatePicker) findViewById(R.id.DateP);
        tvResult = (TextView) findViewById(R.id.tvResult);
        timePick = (TimePicker) findViewById(R.id.timePick);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //시작 버튼이 눌리면 할 일
                // 라디오 그룹, 레이아웃 1, 레이아웃 2 를 나타나게 한다.
                Chrono.setBase(SystemClock.elapsedRealtime());
                Chrono.start();
                Chrono.setTextColor(Color.RED);

                rgroup.setVisibility(view.VISIBLE);
                linear1.setVisibility(view.VISIBLE);
                linear2.setVisibility(view.VISIBLE);

                timePick.setVisibility(view.GONE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Chrono.stop();
                Chrono.setTextColor(Color.BLUE);

                strResult = iYear + "년 " + (iMonth + 1) + "월 " + iDaymonth + "일 ";
                strResult += timePick.getCurrentHour() + "시 ";
                strResult += timePick.getCurrentMinute() + "분 ";

                tvResult.setText(strResult);

            }
        });

//      라디오 그룹을 통해 어떠한 라디오 버튼이 눌렸는지 판단한다.
//      이때 onCheckedChanged() 함수의 (핸들러) 매개변수 중 두번째 값이
//      선택된 라디오버튼의 아이디 값이다.
//      따라서 switch-case 문장으로 아아디 (상수) 를 판별한다.

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
                switch (checkedid) {
                    case R.id.rdoCal:
                        DateP.setVisibility(View.VISIBLE);
                        timePick.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rdoTime:
                        DateP.setVisibility(View.INVISIBLE);
                        timePick.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

//        라디오 그룹처럼 캘린더 뷰 역시 선택된 날짜가 변경되는 것을 감지 (리스닝) 할수있다.
//        따라서 리스너를 등록해주면 된다.
        DateP.init(DateP.getYear(), DateP.getMonth(), DateP.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                iYear = year;
                iDaymonth = dayOfMonth;
                iMonth = month;
                strResult += year + "년 " + (month + 1) + "월 " + dayOfMonth + "일 ";
                strResult += timePick.getCurrentHour() + "시 " + timePick.getCurrentMinute() + "분 예약 되었습니다.";
            }
        });
//        DateP.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
//                iYear = year;
//                iDaymonth = dayOfMonth;
//                iMonth = month;
//                strResult += year + "년 "  +(month+1) + "월 "+dayOfMonth+"일 ";
//                strResult  +=timePick.getCurrentHour() +"시 " +timePick.getCurrentMinute()+"분 예약 되었습니다.";
//            }
//        });
    }
}

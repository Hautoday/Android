package com.example.viewsample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


public class MyView extends View {
    public int x,y;
    public String str;
    public boolean isStop;
    MoveThread mThread = new MoveThread(this);
    public MyView(Context context) {
        super(context);

        mThread.start();
    }


    //현재 뷰 클래스는 화면에 그리는 작업을 하지 않는다.
    //뷰 클래스는 반드시 오버라이딩 해야하는 메서드가 존재한다.
    //즉 onDraw 메소드가 무엇인가 그리는 역할을 수행한다.


    @Override
    protected void onDraw(Canvas canvas) { // onDraw() 함수는 View생성시 한번만 실행된다.
//        super.onDraw(canvas);
        Paint p ;
        p = new Paint();
        p.setTextSize(50);
        p.setColor(Color.BLUE);
        canvas.drawText("x 좌표 : "+x+"  y 좌표 : "+y ,10,50,p);
        canvas.drawText("터치상태 : "+str,10,130,p);

        Bitmap Bm = new BitmapFactory().decodeResource(getResources(),R.drawable.yurisa);
        Bm = Bitmap.createScaledBitmap(Bm,600,900,true);
        canvas.drawBitmap(Bm,250 ,970+y,p);

    }

    // onTouthevent 메서드는 뷰 화면터치 시 자동 호출된다.
    // 호출된 상태 정보는 매개변수인 motionEvent에 전달된다,
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(isStop = false){
            isStop = true;
            try{
                mThread.suspend();
            }catch(Exception e){

            }

        }
        else{
            isStop = false;
            try {
                mThread.resume();
            }catch(Exception e){

            }
        }
//        x = (int)event.getX();
//        y = (int)event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            str = "Action Down 상태입니다.";
        }
        else if (event.getAction() == MotionEvent.ACTION_UP){
            str = "Action Up 상태입니다.";
        }
        else if (event.getAction() == MotionEvent.ACTION_MOVE){
            str = "ETC";
        }


        //invalidate();
        // 이 함수는 화면을 갱신한다.
        // 즉 현재 onDraw()로 그려진 화면을 무효화 하고 새로운 화면을 그린다.
        return true;

        // Action up & Move 를 감지하기 위해서는 반드시 true 값을 반환해줘야 한다.
    }
}















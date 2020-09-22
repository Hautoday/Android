package com.example.viewsample;

import android.view.View;

public class MoveThread extends Thread {
    MyView m_view;
    public MoveThread(MyView _view){
        m_view = _view;

    }

    @Override
    public void run() {
//        super.run();
        for (;;){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            m_view.y  -=  10;
            m_view.postInvalidate();
        }

    }
}

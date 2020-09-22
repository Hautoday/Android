package com.example.contextmenusample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    LinearLayout BaseLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseLayout = findViewById(R.id.baseLayout);
//        위젯 변수와 XML의 버튼을 결합
        btn1 = findViewById(R.id.btn1);
//        버튼에 컨텍스트 메뉴를 등록한다.
        registerForContextMenu(btn1);
        btn2 = findViewById(R.id.btn2);
        registerForContextMenu(btn2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.context_menu,menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                btn1.setBackgroundColor(Color.RED);
                break;
            case R.id.itemBlue:
                btn1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemGreen:
                btn1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemRed:
                break;
            case R.id.itemRed:
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}

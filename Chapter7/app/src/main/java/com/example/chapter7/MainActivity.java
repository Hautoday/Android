package com.example.chapter7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvName,tvEmail,toast1,sample;
    EditText edt1,edt2;
    Button btn1;
    View dialogView,toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        btn1 = findViewById(R.id.btn1);
        sample = findViewById(R.id.sample);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dig = new AlertDialog.Builder((MainActivity.this));
                dig.setTitle("사용자 정보 입력");

                dig.setView(dialogView);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edt1 = dialogView.findViewById(R.id.edt1);
                        edt2 = dialogView.findViewById(R.id.edt2);

                        tvName.setText(edt1.getText().toString());
                        tvEmail.setText(edt2.getText().toString());
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(getApplicationContext(),"취소 되었습니다",Toast.LENGTH_SHORT).show();

                    }
                });
                dig.show();
            }
        });
    }
}

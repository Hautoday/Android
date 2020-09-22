package com.example.yurisa.oj;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { /** * 사용자 단말기의 권한 중 "전화걸기" 권한이 허용되어 있는지 확인한다. * Android는 C언어 기반으로 만들어졌기 때문에 Boolean 타입보다 Int 타입을 사용한다. */
                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE); /** * 패키지는 안드로이드 어플리케이션의 아이디이다. * 현재 어플리케이션이 CALL_PHONE에 대해 거부되어있는지 확인한다. */
                    if (permissionResult == PackageManager.PERMISSION_DENIED) { /** * 사용자가 CALL_PHONE 권한을 거부한 적이 있는지 확인한다. * 거부한적이 있으면 True를 리턴하고 * 거부한적이 없으면 False를 리턴한다. */
                        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("권한이 필요합니다.").setMessage("이 기능을 사용하기 위해서는 단말기의 \"전화걸기\" 권한이 필요합니다. 계속 하시겠습니까?").setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) { /** * 새로운 인스턴스(onClickListener)를 생성했기 때문에 * 버전체크를 다시 해준다. */
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                    }
                                }
                            }).setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            }).create().show();
                        } else {
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-6470-6405"));
                        startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-6470-6405"));
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 권한 요청에 대한 응답을 이곳에서 가져온다. * * @param requestCode 요청코드 * @param permissions 사용자가 요청한 권한들 * @param grantResults 권한에 대한 응답들(인덱스별로 매칭)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-6470-6405"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                }
            } else {
                Toast.makeText(MainActivity.this, "권한요청을 거부했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}






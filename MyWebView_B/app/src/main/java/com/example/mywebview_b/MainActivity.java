package com.example.mywebview_b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    WebView webview;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//        위젯 변수 결합시 형 변환은 생략 가능하다.
            edtUrl = findViewById(R.id.edtUrl);
            webview = findViewById(R.id.webview);

//        webview 위젯 변수를 통해 웹 클라이언트 ( 브라우저 )의 기능을 설정한 것이다.
//        setWebViewClient() 함수의 매개 변수에 우리가 지정한 MyWebClient 클래스의 인스턴스를 인자로 전달한다.
            webview.setWebViewClient(new MyWebClient());

//        web 기능의 해당하는 기본 속성 관리 방법
            WebSettings webSet = webview.getSettings();
//        webSet 객체에 webView 로부터 읽어온 기본 기능을 저장한 것이다.
//        webSet 객체를 통해 기능을 변경할 수 있다.
            webSet.setBuiltInZoomControls(true);
            webview.loadUrl("http://m.naver.com");

        }

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGo:
                    goUrl();

                    break;
                case R.id.btnBack:
                    webview.goBack();

                    break;
                case R.id.btnHome:
                    String UrlHome ="https://www.twitch.tv/espoir9048/";
                    webview.loadUrl(UrlHome);
                    break;
            }
        }

        //    입력창의 URL을 읽어오고 해당 주소로 webView를 로딩하게 된다.
        public void goUrl() {
//        입력창에 값을 읽어 웹뷰에게 그 URL로 이동하라고 명령한다.
            String strUrl = edtUrl.getText().toString().trim(); // 읽어오는 과정
            if (strUrl.length() >= 7)
                if (strUrl.equals("")) {
                    String strTemp = strUrl.substring(0, 7);
//        1. 첫번째 문자부터 7번째 문자까지 잘라낸다.
//        2."https://" 와 1번의 잘라낸 부분과 같은가 검사.
//        3. 다르면 "https://"를 붙여준다.
//        4. 만약 같으면 그냥 로딩한다.
                    if (!strTemp.equals("http://")) {
                        strUrl = "http://" + strUrl;
                        webview.loadUrl(strUrl);
                        edtUrl.setText(strUrl);
                    }
                }
        }
//    inner class : 클래스 내부에 객체 생성을 위한 다른 클래스를 정의할 수 있다.

        class MyWebClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {


                return super.shouldOverrideUrlLoading(view, request);
            }
        }
    }


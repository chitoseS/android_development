package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


//TODO:
// 戻るボタンを実装する。
// リフレッシュボタンを実装する。
// テストコードを書く。

public class WebView_Google extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // WebView
        WebView myWebView = findViewById(R.id.webView); // レイアウトに設置したWebViewを追加します。
        myWebView.setWebViewClient(new WebViewClient()); // リンクをクリックしたときに標準ブラウザへ遷移させずにWebView内で表示
        myWebView.loadUrl("https://www.google.com/"); // 表示させたいURLを記述します。

        // findView
        Button button = findViewById(R.id.button3);

        // ボタン処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebView_Google.this, FirstScreen.class);
                String data = "My name is Moriota";
                intent.putExtra("name", data);

                // データ確認
                CommonMessage commonMessage = new CommonMessage();
                commonMessage.InfoMessage("data");

                //遷移先の画面を起動
                startActivity(intent);
            }
        });
    }
}

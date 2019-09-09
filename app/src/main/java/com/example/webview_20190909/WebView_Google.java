package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
    }

    // 画面遷移用のボタンイベント
    public void onClick(View v){
        Log.v("test","----------------");
//        // インテントの作成
        Intent intent = new Intent(this, FirstScreen.class);
//        EditText editText = this.findViewById(R.id.button);
//        intent.putExtra("sendText",editText.getText().toString());
//        //遷移先の画面を起動
        startActivity(intent);
    }
}

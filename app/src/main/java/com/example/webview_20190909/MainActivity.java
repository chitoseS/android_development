package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

//TODO:
// WebViewを使ってGoogleをアプリ内で表示させる。[完了]
// 画面遷移用のイベントを起すボタンを実装する。
// - 2つ目の画面を追加する。
// 戻るボタンを実装する。
// リフレッシュボタンを実装する。
// テストコードを書く。

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // WebView
        WebView myWebView = (WebView) findViewById(R.id.webView); // レイアウトに設置したWebViewを追加します。
        myWebView.setWebViewClient(new WebViewClient()); // リンクをクリックしたときに標準ブラウザへ遷移させずにWebView内で表示
        myWebView.loadUrl("https://www.google.com/"); // 表示させたいURLを記述します。
    }
}

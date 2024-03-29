package com.example.webview_20190909;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


//TODO:
// 戻るボタンを実装する。[OK]
// - 戻る先がない場合は、disableにする。[]
// リフレッシュボタンを実装する。[OK]
// テストコードを書く。

public class WebView_Google extends AppCompatActivity {
    // クラス変数
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // WebView
        mWebView = findViewById(R.id.webView); // レイアウトに設置したWebViewを追加します。
        mWebView.setWebViewClient(new WebViewClient()); // リンクをクリックしたときに標準ブラウザへ遷移させずにWebView内で表示
        mWebView.loadUrl("https://www.google.com/"); // 表示させたいURLを記述します。

        // findView
        Button button1 = findViewById(R.id.screen1_button);
        Button button2 = findViewById(R.id.screen2_button);
        Button button_refresh = findViewById(R.id.refresh_button);
        Button button_next = findViewById(R.id.next_button);
        Button button_back = findViewById(R.id.back_button);

        // ボタン1の処理
        button1.setOnClickListener(new View.OnClickListener() {
            // 変数初期化
            Intent intent = new Intent();
            String data = "";

            @Override
            public void onClick(View view) {
                // 画面1へ遷移するボタン
                intent = new Intent(WebView_Google.this, FirstScreen.class);
                data = "ここは画面 1 です。";
                intent.putExtra("Message", data);
                //遷移先の画面を起動
                startActivityForResult(intent, Consts.REQUEST_CODE_FIRST);
            }
        });

        // ボタン2の処理
        button2.setOnClickListener(new View.OnClickListener() {
            // 変数初期化
            Intent intent = new Intent();
            String data = "";

            @Override
            public void onClick(View view) {
                // 画面2へ遷移するボタン
                intent = new Intent(WebView_Google.this, SecondScreen.class);
                data = "ここは画面 2 です。";
                intent.putExtra("Message", data);

                //遷移先の画面を起動
                startActivityForResult(intent, Consts.REQUEST_CODE_SECOND);
            }
        });

        // 更新ボタンの実装
        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.reload();

                // textViewの初期化
                TextView textView = findViewById(R.id.textView);
                textView.setText(Consts.TEXT_VIEW_INIT_MESSAGE_MENU);
            }
        });

        // WebViewClientの設定 http://accelebiz.hatenablog.com/entry/2016/08/25/232305
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Log.d("--- ログ --->", "タップされたリンクのurl:" + url);

                return false;
            }
        });

//        // 進むが有効でない場合、ボタンを無効化する。
//        if (mWebView.canGoForward() == true) {
//            button_next.setEnabled(true);
//        } else {
//            button_next.setEnabled(false);
//        }
//
//        // 戻るが有効でない場合、ボタンを無効化する。
//        if (mWebView.canGoBack() == true) {
//            button_back.setEnabled(true);
//        } else {
//            button_back.setEnabled(false);
//        }

        // 進むボタンの実装
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWebView.canGoForward()) {
                    mWebView.goForward();
                }
            }
        });

        // 戻るボタンの実装
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            // firstから戻ってきた場合
            case (Consts.REQUEST_CODE_FIRST):
                returnMenu(resultCode, data);
                break;
            case (Consts.REQUEST_CODE_SECOND):
                returnMenu(resultCode, data);
                break;

            default:
                break;
        }
    }

    // 遷移先画面から戻ってきたときの共通処理
    // 遷移先から渡されたデータを受け取り、画面のTextViewに表示する。
    private void returnMenu(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // データの受け取り
            String receivedData = Objects.requireNonNull(data).getStringExtra("screenNum");
            TextView textView = findViewById(R.id.textView);
            textView.setText(receivedData);
            // データ確認
            CommonMessage commonMessage = new CommonMessage();
            commonMessage.InfoMessage("------------------------");
            commonMessage.InfoMessage(receivedData);
        } else {
            // その他
            CommonMessage commonMessage = new CommonMessage();
            commonMessage.InfoMessage("Another");
        }
    }

    public String getStrFromFunction(String str){
        return str;
    }
}

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
// 更新ボタンを実装する。
// 戻るボタンを実装する。
// - 戻る先がない場合は、disableにする。
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
        Button button1 = findViewById(R.id.Screen1_button);
        Button button2 = findViewById(R.id.returnButton);

        // 二つのボタンがある場合、別のonClickListenerを用意しないといけないので、setTagを用いる。
        button1.setTag(1);
        button2.setTag(2);

        // ボタン処理
        button1.setOnClickListener(new View.OnClickListener() {
            // 変数初期化
            Intent intent = new Intent();
            String data = "";

            @Override
            public void onClick(View view) {
                // どのボタンが押されたか判断する
                Log.d("Button Tapped", view.getTag().toString());
                switch (view.getId()) {
                    // 画面1へ遷移するボタン
                    case R.id.Screen1_button:
                        intent = new Intent(WebView_Google.this, FirstScreen.class);
                        data = "ここは画面 1 です。";
                        intent.putExtra("Message", data);

                        //遷移先の画面を起動
                        startActivityForResult(intent, Consts.REQUEST_CODE_FIRST);

                        // 画面2へ遷移するボタン
                    case R.id.returnButton:
                        intent = new Intent(WebView_Google.this, SecondScreen.class);
                        data = "ここは画面 2 です。";
                        intent.putExtra("Message", data);
                        break;
                }
            }
        });

        // ボタン処理
        button2.setOnClickListener(new View.OnClickListener() {
            // 変数初期化
            Intent intent = new Intent();
            String data = "";

            @Override
            public void onClick(View view) {
                // どのボタンが押されたか判断する
                Log.d("Button Tapped", view.getTag().toString());
                switch (view.getId()) {
                    // 画面1へ遷移するボタン
                    case R.id.Screen1_button:
                        intent = new Intent(WebView_Google.this, FirstScreen.class);
                        data = "ここは画面 1 です。";
                        intent.putExtra("Message", data);

                        //遷移先の画面を起動
                        startActivityForResult(intent, Consts.REQUEST_CODE_FIRST);

                        // 画面2へ遷移するボタン
                    case R.id.returnButton:
                        intent = new Intent(WebView_Google.this, SecondScreen.class);
                        data = "ここは画面 2 です。";
                        intent.putExtra("Message", data);

                        //遷移先の画面を起動
                        startActivityForResult(intent, Consts.REQUEST_CODE_SECOND);
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
            TextView textView = findViewById(R.id.textView3);
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
}

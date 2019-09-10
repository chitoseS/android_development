package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Menu画面からデータの受け取り
        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("Message");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(receivedData);
        // 受取ったデータの確認
        CommonMessage commonMessage = new CommonMessage();
        commonMessage.InfoMessage(receivedData);

        // findViewで戻るボタンのIDを取得
        Button button = findViewById(R.id.Screen2_button);

        // 戻るボタン処理の実装
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 遷移先の画面を準備
                Intent intent = new Intent(FirstScreen.this, WebView_Google.class);

                // 遷移先に渡すデータを準備
                Intent result = new Intent();
                // resultに、screenNameというキーをつけて、値を設定する。(String)
                result.putExtra("screenNum", Consts.SCREEN_NUMBER_FIRST);
                // 処理が成功した場合
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}

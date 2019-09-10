package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Menu画面からデータの受け取り
        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.textView);
        textView.setText(receivedData);
        // 受取ったデータの確認
        CommonMessage commonMessage = new CommonMessage();
        commonMessage.InfoMessage(receivedData);
        // findViewで戻るボタンのIDを取得
        Button button = findViewById(R.id.returnButton);

        // 戻るボタン処理の実装
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 遷移先の画面を準備
                Intent intent = new Intent(SecondScreen.this, WebView_Google.class);

                // 遷移先に渡すデータを準備
                Intent result = new Intent();
                // resultに、screenNameというキーをつけて、値を設定する。(String)
                result.putExtra("screenNum", Consts.SCREEN_NUMBER_SECOND);
                // 処理が成功した場合
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}

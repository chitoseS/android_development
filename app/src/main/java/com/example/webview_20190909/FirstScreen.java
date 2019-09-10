package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//ToDo
// onClickイベントの実装

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // データの受け取り
        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.textView2);
        textView.setText(receivedData);

        // データ確認
        CommonMessage commonMessage = new CommonMessage();
        commonMessage.InfoMessage(receivedData);

        // findView
        Button button = findViewById(R.id.returnButton);

        // 戻るボタン処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstScreen.this, WebView_Google.class);



                //遷移先の画面を起動
                startActivity(intent);
            }
        });
    }

    // 画面遷移用のボタンイベント
    public void onClick(View v){
        // ログの表示
        CommonMessage commonMessage = new CommonMessage();
        commonMessage.InfoMessage("_________");
//        // インテントの作成
        Intent intent = new Intent(this, SecondScreen.class);
//        EditText editText = this.findViewById(R.id.button);
//        intent.putExtra("sendText",editText.getText().toString());
//        //遷移先の画面を起動
        startActivity(intent);
    }

    public void onClickBack(View v){
        // インテントの作成
        Intent intent = new Intent(this, WebView_Google.class);
        //遷移先の画面を起動
        startActivity(intent);
    }
}

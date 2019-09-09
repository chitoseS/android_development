package com.example.webview_20190909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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

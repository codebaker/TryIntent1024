package com.codebakery.joan.tryintent1024;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //넘어온값 처리
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        mMessageTextView = (TextView) findViewById(R.id.message_edit_text);
        mMessageTextView.setText(age + "살 " + name);

        //이벤트리스너 달기
        findViewById(R.id.result_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("result",mMessageTextView.getText().toString());

        //왔던화면으로 결과 전달
        setResult(RESULT_OK,intent);

        //두번빼 액티비티 종료...
        finish();
    }
}

package com.codebakery.joan.tryintent1024;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static final int REQUEST_CODE = 1000;
    private EditText mNameEditText,mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //레이아웃 표시
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_edit);
        mAgeEditText = (EditText) findViewById(R.id.age_edit);

        //전송버튼에 리스너 달기.
        // this를 넘겨준것은 MainActivity에서 처리하겠다는 뜻.
        findViewById(R.id.submit).setOnClickListener(this);
        // 다른 방법
        /*findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("name",mNameEditText.getText().toString());
        intent.putExtra("age",mAgeEditText.getText().toString());

        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //1000,-1,intent가 넘어왔는지 모두 확인하고 결과값을 set한다.
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            String result = data.getStringExtra("result");
            Toast.makeText(MainActivity.this, result,Toast.LENGTH_SHORT).show();
        }
    }


}

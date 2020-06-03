package com.jaydonga.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

           String  TAG="mainActivity";
           Button button;
           TextView textView;
           int  i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"oncreate");

       button= findViewById(R.id.btn);
       textView = findViewById(R.id.main);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("key",String.valueOf(i));
                startActivityForResult(intent,2);//pass the code to second activity
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==2) {
            if (resultCode == RESULT_OK) {
                 i = data.getIntExtra("key",0);
                   textView.setText(String.valueOf(i));//pass String value
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"start");
    }

    @Override

    protected void onResume() {
        super.onResume();
        Log.d(TAG,"resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "destroy");
    }

}
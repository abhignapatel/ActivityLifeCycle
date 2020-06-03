package com.jaydonga.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    String TAG ="secondActivity";
    Button button;
    TextView textView;
    int count =0;
    Intent intent;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG,"create Activity");

       button = findViewById(R.id.btnSecond);
        textView = findViewById(R.id.second);


//
        intent=getIntent();
        String str = intent.getStringExtra("key");
        textView.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(String.valueOf(count));//string value
            }
        });
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("key",String.valueOf(count));
//                startActivity(intent);
//            }
//        });


    }
    @Override
    public void onBackPressed() {

        intent= new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("key",Integer.parseInt(String.valueOf(textView.getText())));//convert integer value
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"start activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "resume activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"pause activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"stop activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"restart activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "destroy activity");
    }
}
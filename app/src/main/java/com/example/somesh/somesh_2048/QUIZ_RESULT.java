package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class QUIZ_RESULT extends AppCompatActivity {
    Button b9,b45,b46,b47;
    TextView e1;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__result);
        b9=(Button)findViewById(R.id.button9);
        b45=(Button)findViewById(R.id.button45);
        b46=(Button)findViewById(R.id.button46);
        b47=(Button)findViewById(R.id.button47);
        e1=(TextView)findViewById(R.id.textView9);
        w1=(WebView)findViewById(R.id.webView);
        String s2=Integer.toString(Q1.score);
        String s1="RESULT =";
        e1.setText(s1+s2);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("http://www.facebook.com");
            }
        });
        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("http://www.twitter.com");
            }
        });
        b46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("http://www.google.com");

            }
        });
        b47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(QUIZ_RESULT.this,GAME_2048.class);
                startActivity(i);
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i=new Intent(QUIZ_RESULT.this,EXTRA_FUNCTION.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
}

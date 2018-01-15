package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class EXTRA_FUNCTION extends AppCompatActivity {
    Button b26,b27,b28,b32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra__function);
        b26=(Button)findViewById(R.id.button26);
        b27=(Button)findViewById(R.id.button27);
        b28=(Button)findViewById(R.id.button28);
        b32=(Button)findViewById(R.id.button32);
        b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EXTRA_FUNCTION.this,SENSOR_MUSIC_PLAYER.class);
                startActivity(i);
                finish();
            }
        });
        b27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EXTRA_FUNCTION.this,GRAVITY_MISOC_PLAYER.class);
                startActivity(i);
                finish();
            }
        });
        b28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EXTRA_FUNCTION.this,QUIZ.class);
                startActivity(i);
                finish();
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EXTRA_FUNCTION.this,GAME_2048.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i=new Intent(EXTRA_FUNCTION.this,GAME_2048.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
}

package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GO_TO_LOGIN extends AppCompatActivity {
    Button b4,b3;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__to__login);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GO_TO_LOGIN.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(GO_TO_LOGIN.this, "COMPLETE ALL FIELDS", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase data = openOrCreateDatabase("net", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp (name varchar,password varchar)");
                    String s4 = "select * from camp where name ='"+s1+"' and password='"+s2+"' ";
                    Cursor cursor = data.rawQuery(s4,null);
                    if (cursor.getCount() > 0) {
                        //Toast.makeText(GO_TO_LOGIN.this, s1, Toast.LENGTH_SHORT).show();
                        Toast.makeText(GO_TO_LOGIN.this,"Hii   " +s1, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(GO_TO_LOGIN.this, GAME_2048.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(GO_TO_LOGIN.this, "USER NOT FOUND", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i=new Intent(GO_TO_LOGIN.this,MainActivity.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
}

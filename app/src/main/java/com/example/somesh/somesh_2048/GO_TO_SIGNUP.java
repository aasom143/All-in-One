package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GO_TO_SIGNUP extends AppCompatActivity {
    Button b5,b6,b8;
    EditText e4,e5,e3;
    String s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__to__signup);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b8=(Button)findViewById(R.id.button8);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e3.getText().toString();
                s2=e4.getText().toString();
                s3=e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(GO_TO_SIGNUP.this, "FILL ALL FIELDS", Toast.LENGTH_SHORT).show();
                }
                else 
                {
                    if(s2.equals(s3))
                    {

                        SQLiteDatabase data=openOrCreateDatabase("net",MODE_PRIVATE,null);
                        data.execSQL("create table if not exists camp (name varchar,password varchar)");
                        String s4="select * from camp where name ='"+s1+"' and password='"+s2+"' ";
                        Cursor cursor =data.rawQuery(s4,null);
                        if(cursor.getCount()>0)
                        {
                            Toast.makeText(GO_TO_SIGNUP.this, "USER EXISTS", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            data.execSQL("insert into camp values('" + s1 + "','" + s2 + "')");
                            Toast.makeText(GO_TO_SIGNUP.this, "SUCCESSFULLY SIGNED IN", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(GO_TO_SIGNUP.this, GAME_2048.class);
                            startActivity(i);
                            finish();
                        }
                    }
                    else 
                    {
                        Toast.makeText(GO_TO_SIGNUP.this, "ENTER SAME PASSWORD", Toast.LENGTH_SHORT).show();
                        e5.setText("");
                        e4.setText("");
                    }
                }
                
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GO_TO_SIGNUP.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GO_TO_SIGNUP.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i=new Intent(GO_TO_SIGNUP.this,MainActivity.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
}

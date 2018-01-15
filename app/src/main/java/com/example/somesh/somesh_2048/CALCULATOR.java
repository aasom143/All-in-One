package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class CALCULATOR extends AppCompatActivity {
    EditText e6,e7,e8;
    Button b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;
    Float i1;
    Float i2;
    double i3;
    String s,s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        e6=(EditText)findViewById(R.id.editText6);
        e7=(EditText)findViewById(R.id.editText7);
        e8=(EditText)findViewById(R.id.editText8);
        b14=(Button)findViewById(R.id.button14);
        b15=(Button)findViewById(R.id.button15);
        b16=(Button)findViewById(R.id.button16);
        b17=(Button)findViewById(R.id.button17);
        b18=(Button)findViewById(R.id.button18);
        b19=(Button)findViewById(R.id.button19);
        b20=(Button)findViewById(R.id.button20);
        b21=(Button)findViewById(R.id.button21);
        b22=(Button)findViewById(R.id.button22);
        b23=(Button)findViewById(R.id.button23);
        b24=(Button)findViewById(R.id.button24);
        b25=(Button)findViewById(R.id.button25);

        //final String s1= e6.getText().toString();
        //e7.setText(e6.getText().toString());
         b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=i1+i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=i1-i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=i1*i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=i1%i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=i1/i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e6.setText("");
                e7.setText("");
                e8.setText("");
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                //e7.setText("");
                String ss="RESULT = ";
                e8.setText(ss+s1);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                s2=e7.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    e7.setText("");
                    i2=Float.parseFloat(s2);
                    i3=1.0;
                    for (int i=1;i<=i2;i++)
                    {
                        i3=i3*i1;
                    }
                    //i3=i1^i2;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    int i;
                    i3=1;
                    for(i=1;i<=i1;i++)
                    {
                        i3=i3*i;
                    }
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }

            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else {
                    i1=Float.parseFloat(s1);
                    i3=sqrt(i1);
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }
                }


        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else {
                    i1 = Float.parseFloat(s1);
                    i3 = 1 / i1;
                    s = Float.toString((float) i3);
                    e6.setText(s);
                }
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e6.getText().toString();
                if(s1.equals(""))
                {
                    Toast.makeText(CALCULATOR.this, "ENTER THE NUMBER", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    i1=Float.parseFloat(s1);
                    i3=i1*i1;
                    s=Float.toString((float) i3);
                    e6.setText(s);
                }

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i=new Intent(CALCULATOR.this,GAME_2048.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
}

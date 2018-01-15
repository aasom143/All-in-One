package com.example.somesh.somesh_2048;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GO_TO_LOGIN.class);
                startActivity(i);
                finish();
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GO_TO_SIGNUP.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int i=0;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            i++;
            if(i!=2)
            {
                Toast.makeText(MainActivity.this, "Press once again to exit", Toast.LENGTH_SHORT).show();
            }
            else{
                finish();
                System.exit(0);}
        }
        return super.onKeyDown(keyCode, event);}
}

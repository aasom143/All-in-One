package com.example.somesh.somesh_2048;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class GRAVITY_MISOC_PLAYER extends AppCompatActivity implements SensorEventListener{
    Button b30;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity__misoc__player);
        b30=(Button)findViewById(R.id.button30);
        mp=MediaPlayer.create(this,R.raw.a);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GRAVITY_MISOC_PLAYER.this,EXTRA_FUNCTION.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mp.reset();
            Intent i=new Intent(GRAVITY_MISOC_PLAYER.this,EXTRA_FUNCTION.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>1)
        {
            mp.pause();
        }
        else
        {
            mp.start();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}

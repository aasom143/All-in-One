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

public class SENSOR_MUSIC_PLAYER extends AppCompatActivity implements SensorEventListener {
    Button b29;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__music__player);
        b29=(Button)findViewById(R.id.button29);
        mp=MediaPlayer.create(this,R.raw.a);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);

        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                Intent i=new Intent(SENSOR_MUSIC_PLAYER.this,EXTRA_FUNCTION.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mp.reset();
            Intent i=new Intent(SENSOR_MUSIC_PLAYER.this,EXTRA_FUNCTION.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.values[0]>5)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

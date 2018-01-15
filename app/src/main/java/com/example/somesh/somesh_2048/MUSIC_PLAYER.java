package com.example.somesh.somesh_2048;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MUSIC_PLAYER extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST =1;


    ArrayList <String> arrayList;
    ListView listView;
    ArrayAdapter<String > adapter;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music__player);

        if(ContextCompat.checkSelfPermission(MUSIC_PLAYER.this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MUSIC_PLAYER.this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                ActivityCompat.requestPermissions(MUSIC_PLAYER.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(MUSIC_PLAYER.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
        }
        else
        {
            doStuff();
        }
    }

    private void doStuff() {
        listView =(ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        getMusic();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                MediaPlayer mp=(MediaPlayer)listView.getItemAtPosition(i);
//                mp.start();
//                String name=(String)listView.getItemAtPosition(i);
                //Toast.makeText(MUSIC_PLAYER.this, "+position+", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MUSIC_PLAYER.this, "Position :"+i+"    "+name, Toast.LENGTH_SHORT).show();
//                String file=(String)view.getTag();
//                mp.stop();
//                mp.reset();
//                try {
//                    mp.setDataSource(file);
//                    mp.prepare();
//                    mp.start();
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (IllegalStateException e)
//                {
//                    e.printStackTrace();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }

            }
        });
    }


    public void getMusic()
    {
        ContentResolver contentResolver=getContentResolver();
        Uri songUri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor=contentResolver.query(songUri,null,null,null,null);

        if (songCursor!=null&&songCursor.moveToFirst())
        {
            int songTitle =songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist=songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do{
                String currentTitle=songCursor.getString(songTitle);
                String currentArtist=songCursor.getString(songArtist);
                arrayList.add(currentTitle+"\n"+currentArtist);
                //mp.start();
            } while(songCursor.moveToNext());
        }
    }

    @Override

    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST:{
                if(grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MUSIC_PLAYER.this,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(MUSIC_PLAYER.this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                        doStuff();;
                    }
                }
                else{
                    Toast.makeText(MUSIC_PLAYER.this, "NO PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(MUSIC_PLAYER.this, GAME_2048.class);
            startActivity(i);
            finish();
            //System.exit(0);
        }

        return super.onKeyDown(keyCode, event);
    }
//    @Override
//    protected void onlistItemClick(ListView listView,View view,)
}
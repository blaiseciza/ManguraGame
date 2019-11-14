package com.blaiseciza.manguragame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //final MediaPlayer mySong = MediaPlayer.create(Splash.this, R.raw.song);
        //mySong.start();
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(4000);
                    ((Vibrator) getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500);

                }catch (InterruptedException e){
                    e.printStackTrace();

                }finally {

                    //mySong.stop();
                    Intent op=new Intent(Splash.this,PageGame.class);
                    startActivity(op);
                    finish();

                }
            }
        };timer.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

}

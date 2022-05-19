package com.example.gmapdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    ImageView appname;
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(6000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
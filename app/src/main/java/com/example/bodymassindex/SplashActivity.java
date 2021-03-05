package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread logoanimation=new Thread(){
            @Override
            public void run(){

                ImageView logo;
                logo = findViewById(R.id.imageView2);

                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fate_intro_logo);
                logo.startAnimation(animation);
            }


        };
        logoanimation.start();

        Thread redirect=new Thread(){
            @Override
            public void run(){

               try { sleep(3500);
                   Intent i= new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(i);
                   finish();

               }catch (InterruptedException e){
                   e.printStackTrace();

               }
               }
            };
        redirect.start();

    }
}

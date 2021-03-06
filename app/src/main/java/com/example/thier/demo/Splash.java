package com.example.thier.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by thier on 16-3-2016.
 */
public class Splash extends Activity {

    //OnCreate methode
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashh);

        //imageview voor "Method." en animatie voor het draaien
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);

        //starten animatie
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //animatie laten eindigen na ronddraaien
            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

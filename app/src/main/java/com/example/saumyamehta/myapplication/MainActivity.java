package com.example.saumyamehta.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private GifImageView gifImageView;
    private GifDrawable gifDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IntroManagerFragment frag2  = new IntroManagerFragment();


        fragmentTransaction.replace(R.id.main,frag2);
        fragmentTransaction.commit();
        button = (Button)findViewById(R.id.play);*/
        gifImageView = (GifImageView)findViewById(R.id.gif);
        gifDrawable = (GifDrawable) gifImageView.getDrawable();
        resetAnimation();
        button = (Button)findViewById(R.id.play);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifDrawable.start();
                /* mainFragment frag1  = new mainFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.commit();
                fragmentTransaction.replace(R.id.main,frag1);*/
            }
        });
        gifDrawable.addAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationCompleted(int loopNumber) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
    private void resetAnimation() {
        gifDrawable.stop();
        gifDrawable.setLoopCount(1);
        gifDrawable.seekToFrameAndGet(0);
        //toggleButton.setChecked(false);
    }
}

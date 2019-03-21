package com.example.crybaby;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import developer.shivam.library.WaveView;

public class sineWave extends AppCompatActivity {
    waveGenerator wavesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {this.getSupportActionBar().hide();}
        catch (Exception e){}
         setContentView(R.layout.activity_sine_wave);
        float stroke = dipToPixels(this, 2);
        wavesView = (waveGenerator) findViewById(R.id.view_sine_wave);
        wavesView.addWave(0.5f, 0.5f, 0, 0, 0); // Fist wave is for the shape of other waves.
        wavesView.addWave(0.4f, 2f, 0.5f,getResources().getColor(R.color.whitetrans), stroke);
        wavesView.addWave(0.1f, 2f, 0.7f, getResources().getColor(R.color.white), stroke);
        wavesView.addWave(0.3f, 2f, 0.6f, getResources().getColor(R.color.whitetrans), stroke);
        wavesView.setBaseWaveAmplitudeScale(1);
        wavesView.startAnimation();
    }

    @Override
    protected void onDestroy() {
        wavesView.stopAnimation();
        super.onDestroy();
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}

package com.example.thier.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by Wendy on 30-3-2016.
 */
public class Weight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_layout);

        Intent intent = getIntent();

        //Sliders instellen naar max 3
        SeekBar seekBar = (SeekBar) findViewById(R.id.weightBar);
        seekBar.setProgress(1);
        seekBar.setMax(2);

        SeekBar seekBar2 = (SeekBar) findViewById(R.id.weightBar2);
        seekBar2.setProgress(1);
        seekBar2.setMax(2);

        SeekBar seekBar3 = (SeekBar) findViewById(R.id.weightBar3);
        seekBar3.setProgress(1);
        seekBar3.setMax(2);

        SeekBar seekBar4 = (SeekBar) findViewById(R.id.weightBar4);
        seekBar4.setProgress(1);
        seekBar4.setMax(2);

        SeekBar seekBar5 = (SeekBar) findViewById(R.id.weightBar5);
        seekBar5.setProgress(1);
        seekBar5.setMax(2);

        SeekBar seekBar6 = (SeekBar) findViewById(R.id.weightBar6);
        seekBar6.setProgress(1);
        seekBar6.setMax(2);

        SeekBar seekBar7 = (SeekBar) findViewById(R.id.weightBar7);
        seekBar7.setProgress(1);
        seekBar7.setMax(2);

        SeekBar seekBar8 = (SeekBar) findViewById(R.id.weightBar8);
        seekBar8.setProgress(1);
        seekBar8.setMax(2);

        SeekBar seekBar9 = (SeekBar) findViewById(R.id.weightBar9);
        seekBar9.setProgress(1);
        seekBar9.setMax(2);
    }

    public void conclusion(View view){
        Intent intent = new Intent(Weight.this, PiechartActivity.class);
        startActivity(intent);
    }
}

package com.example.thier.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

/**
 * Created by Wendy on 30-3-2016.
 */
public class Weight extends AppCompatActivity implements OnSeekBarChangeListener {

    SeekBar weightBar;
    SeekBar weightBar2;
    SeekBar weightBar3;
    SeekBar weightBar4;
    SeekBar weightBar5;
    SeekBar weightBar6;
    SeekBar weightBar7;
    SeekBar weightBar8;
    SeekBar weightBar9;

    double seekBar;
    double seekBar2;
    double seekBar3;
    double seekBar4;
    double seekBar5;
    double seekBar6;
    double seekBar7;
    double seekBar8;
    double seekBar9;



    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_layout);

        Intent intent = getIntent();

        //getintents met doubles van seekbar uit mainactivity
        seekBar = getIntent().getDoubleExtra("s", 0);
        seekBar2 = getIntent().getDoubleExtra("s2", 0);
        seekBar3 = getIntent().getDoubleExtra("s3", 0);
        seekBar4 = getIntent().getDoubleExtra("s4", 0);
        seekBar5 = getIntent().getDoubleExtra("s5", 0);
        seekBar6 = getIntent().getDoubleExtra("s6", 0);
        seekBar7 = getIntent().getDoubleExtra("s7", 0);
        seekBar8 = getIntent().getDoubleExtra("s8", 0);
        seekBar9 = getIntent().getDoubleExtra("s9", 0);

        //weightbars initialisatie met onchangelisteners
        weightBar = (SeekBar) findViewById(R.id.weightBar);
        weightBar.setOnSeekBarChangeListener(this);

        weightBar2 = (SeekBar) findViewById(R.id.weightBar2);
        weightBar2.setOnSeekBarChangeListener(this);

        weightBar3 = (SeekBar) findViewById(R.id.weightBar3);
        weightBar3.setOnSeekBarChangeListener(this);

        weightBar4 = (SeekBar) findViewById(R.id.weightBar4);
        weightBar4.setOnSeekBarChangeListener(this);

        weightBar5 = (SeekBar) findViewById(R.id.weightBar5);
        weightBar5.setOnSeekBarChangeListener(this);

        weightBar6 = (SeekBar) findViewById(R.id.weightBar6);
        weightBar6.setOnSeekBarChangeListener(this);

        weightBar7 = (SeekBar) findViewById(R.id.weightBar7);
        weightBar7.setOnSeekBarChangeListener(this);

        weightBar8 = (SeekBar) findViewById(R.id.weightBar8);
        weightBar8.setOnSeekBarChangeListener(this);

        weightBar9 = (SeekBar) findViewById(R.id.weightBar9);
        weightBar9.setOnSeekBarChangeListener(this);




    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        value = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated  method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated  method stub
    }

    public void conclusion(View view){
        Intent FilterIntent = new Intent(Weight.this, Conclusion.class);
        //doorsturen van data weightbars en seekbars naar de conclusion.class

        FilterIntent.putExtra("w", weightBar.getProgress());
        FilterIntent.putExtra("w2", weightBar2.getProgress());
        FilterIntent.putExtra("w3", weightBar3.getProgress());
        FilterIntent.putExtra("w4", weightBar4.getProgress());
        FilterIntent.putExtra("w5", weightBar5.getProgress());
        FilterIntent.putExtra("w6", weightBar6.getProgress());
        FilterIntent.putExtra("w7", weightBar7.getProgress());
        FilterIntent.putExtra("w8", weightBar8.getProgress());
        FilterIntent.putExtra("w9", weightBar9.getProgress());

        FilterIntent.putExtra("s", seekBar);
        FilterIntent.putExtra("s2", seekBar2);
        FilterIntent.putExtra("s3", seekBar3);
        FilterIntent.putExtra("s4", seekBar4);
        FilterIntent.putExtra("s5", seekBar5);
        FilterIntent.putExtra("s6", seekBar6);
        FilterIntent.putExtra("s7", seekBar7);
        FilterIntent.putExtra("s8", seekBar8);
        FilterIntent.putExtra("s9", seekBar9);

        startActivity(FilterIntent);
    }
}

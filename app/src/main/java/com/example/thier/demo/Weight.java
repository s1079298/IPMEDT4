package com.example.thier.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

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

    TextView weightBarValue;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_layout);

        Intent intent = getIntent();

        weightBar = (SeekBar) findViewById(R.id.weightBar);
        weightBarValue = (TextView) findViewById(R.id.weightvalue);
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

        switch(seekBar.getId()) {
            case R.id.weightBar:
                weightBarValue.setText("Value 1: " + value + "\n");
                break;

            case R.id.weightBar2:
                weightBarValue.setText("Value 2: " + value + "\n");
                break;

            case R.id.weightBar3:
                weightBarValue.setText("Value 3: " + value + "\n");
                break;

            case R.id.weightBar4:
                weightBarValue.setText("Value 4: " + value + "\n");
                break;

            case R.id.weightBar5:
                weightBarValue.setText("Value 5: " + value + "\n");
                break;

            case R.id.weightBar6:
                weightBarValue.setText("Value 6: " + value + "\n");
                break;

            case R.id.weightBar7:
                weightBarValue.setText("Value 7: " + value + "\n");
                break;

            case R.id.weightBar8:
                weightBarValue.setText("Value 8: " + value + "\n");
                break;

            case R.id.weightBar9:
                weightBarValue.setText("Value 9: " + value + "\n");
                break;

        }
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
        Intent intent = new Intent(Weight.this, Conclusion.class);
        startActivity(intent);
    }
}

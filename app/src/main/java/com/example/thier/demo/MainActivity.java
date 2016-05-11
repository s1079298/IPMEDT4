package com.example.thier.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements OnSeekBarChangeListener, OnClickListener {

    Button button;
    Button button1;
    private static final String DEFAULT = "N/A";

    String jsend;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the view from activity_main.xml
            setContentView(R.layout.activity_main);

            // Locate the button in activity_main.xml
            button1 = (Button) findViewById(R.id.btn_laatste);

            // Capture button clicks
            button1.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {

                    // Start Conclusion.class
                    Intent myIntent = new Intent(MainActivity.this,
                            Conclusion.class);

                    //get de laatste string van jsondata vanuit Conclusion voor het maken van de mChart van het laatste advies
                    SharedPreferences jsondataConclusion = getSharedPreferences("jsondataConclusion", Context.MODE_PRIVATE);
                    jsend = jsondataConclusion.getString("jsondata", DEFAULT);
                    Log.d("TESTING MAIN", jsend);

                    //Intent putExtra zodat de Conclusion kan zien vanuit welke activity zijn klasse wordt aangeroepen
                    myIntent.putExtra("FROM_ACTIVITY", "D");

                    //set laatste jsondata doorsturen naar Conclusion zodat hij de goede laatste grafiek laat zien
                    SharedPreferences sharedMain = getSharedPreferences("jsonMain", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editMain = sharedMain.edit();
                    editMain.putString("jsondata", jsend);
                    editMain.apply();

                    startActivity(myIntent);
                }
            });

            // Locate the button in activity_main.xml
            button = (Button) findViewById(R.id.btn_nieuw);

            // Capture button clicks
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {

                    // Start SlidersActivity.class
                    Intent myIntent = new Intent(MainActivity.this,
                            SlidersActivity.class);
                    startActivity(myIntent);
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
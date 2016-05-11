package com.example.thier.demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements OnClickListener {

    //initialiseren van buttons en strings
    Button button, button1;
    private static final String DEFAULT = "N/A";
    String jsend;

    //onCreate methode
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // activity_main.xml inladen
            setContentView(R.layout.activity_main);

            //als er geen netwerk available is, toon toast tekst
            if(!isNetworkAvailable()){
                Toast.makeText(MainActivity.this, "Geen netwerk beschikbaar", Toast.LENGTH_LONG).show();
            } else {
                //nothing
            }

            // activity_main.xml button genaamd button1 zoeken
            button1 = (Button) findViewById(R.id.btn_laatste);

            // button1 functionaliteit
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

                    //start Conclusion klasse
                    startActivity(myIntent);
                }
            });

            // activity_main.xml button genaamd button zoeke
            button = (Button) findViewById(R.id.btn_nieuw);

            // button functionaliteit
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    Intent myIntent = new Intent(MainActivity.this,
                            SlidersActivity.class);

                    //Start Slideractivity klasse
                    startActivity(myIntent);
                }
            });
        }

    //methode om netwerk availability te checken
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    //standaard onClick methode
    @Override
    public void onClick(View v) {

    }
}
package com.example.thier.demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Wendy on 4-5-2016.
 */
public class SharedPrefsActivity extends Activity {

    public static final String PREFS_NAME = "Data";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        SharedPreferences settings = getSharedPreferences( PREFS_NAME, MODE_PRIVATE);

        //Writing data to sharedprefs
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("conclusiondata", "");
        editor.commit();

        //Reading data from sharedprefs
        String value = settings.getString("conclusiondata", "");
        Log.d("Test van sharedprefs", value);
    }
}

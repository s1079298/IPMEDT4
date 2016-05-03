package com.example.thier.demo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * UI SharedPreferences를
 * [UI SharedPreferences에
 *
 */
public class test extends AppCompatActivity {

    SharedPreferences sharedPreferences;


    Button btnSave, btnLoad, btnReset;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        initPreferences(); //SharedPreferences
        initView(); //View
        btn_Event(); //
        loadState(); //
        /**
         *onCreate sharedPreferences       */

    }

    /**
     * btn_Event()
     *
     *  btnSave : saveState() ->
     * btnLoad : loadState() ->
     * btnReset :      */
    private void btn_Event() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveState(); //
                Toast.makeText(getApplicationContext(), "Voorkeur opgeslagen", Toast.LENGTH_SHORT).show();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadState(); //
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seekBar.setProgress(0);
            }
        });

    }

    /**
     * loadState()
     *
     *
     * sharedPreferences.getString("key", defaultValue)  key defaultValue key
     *                   getInt
     *                   getBoolean     *
     * EditText String
     * CheckBox Boolean
     * seekBarInt
     */

    private void loadState() {

        seekBar.setProgress(sharedPreferences.getInt("seekBar",0));
    }

    /**
     * saveState()
     *
     *
     * SharedPreferences Editor
     * SharedPreferences.Editor editor = sharedPreferences.edit(); -> editor
     *
     * editor.putString("key", value)  key valuekey()
     *        putInt
     *        putBoolean      *
     *        EditTextString
     * CheckBoxBoolean
     * seekBarInt
     *
     * commit()SharedPreferences
     */

    private void saveState() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("seekBar", seekBar.getProgress());
        editor.commit();
    }

    /**
     * initPreferences()
     *
     * SharedPreferences
     * sharedPreferences = getSharedPreferences("
     * SharedPreferencesdata/data/[shared_prefs/xml"
     *
     * MODE_PRIVATE SharedPreferences
     */
    private void initPreferences() {
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
    }

    private void initView() {

        btnSave = (Button)findViewById(R.id.btnSave);
        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnReset = (Button)findViewById(R.id.btnReset);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
    }
}
package com.example.thier.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


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
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements OnSeekBarChangeListener, OnClickListener {

    private TextView textView;

    float value;
    //seekbars
    SeekBar seekBar;
    SeekBar seekBar2;
    SeekBar seekBar3;
    SeekBar seekBar4;
    SeekBar seekBar5;
    SeekBar seekBar6;
    SeekBar seekBar7;
    SeekBar seekBar8;
    SeekBar seekBar9;

    TextView seekBarValue;

    //info buttons
    ImageButton info1;
    ImageButton info2;
    ImageButton info3;
    ImageButton info4;
    ImageButton info5;
    ImageButton info6;
    ImageButton info7;
    ImageButton info8;
    ImageButton info9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //Sliders instellen naar max 5
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarValue = (TextView) findViewById(R.id.seekbarvalue);
        seekBar.setOnSeekBarChangeListener(this);

        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);

        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);

        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(this);

        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar5.setOnSeekBarChangeListener(this);

        seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
        seekBar6.setOnSeekBarChangeListener(this);

        seekBar7 = (SeekBar) findViewById(R.id.seekBar7);
        seekBar7.setOnSeekBarChangeListener(this);

        seekBar8 = (SeekBar) findViewById(R.id.seekBar8);
        seekBar8.setOnSeekBarChangeListener(this);

        seekBar9 = (SeekBar) findViewById(R.id.seekBar9);
        seekBar9.setOnSeekBarChangeListener(this);



        //pop ups met info button
        init();
    }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            value = ((float)progress / 4 );

            switch(seekBar.getId()) {
                case R.id.seekBar:
                    seekBarValue.setText("Value 1: " + value + "\n");
                    break;

                case R.id.seekBar2:
                    seekBarValue.setText("Value 2: " + value + "\n");
                    break;

                case R.id.seekBar3:
                    seekBarValue.setText("Value 3: " + value + "\n");
                    break;

                case R.id.seekBar4:
                    seekBarValue.setText("Value 4: " + value + "\n");
                    break;

                case R.id.seekBar5:
                    seekBarValue.setText("Value 5: " + value + "\n");
                    break;

                case R.id.seekBar6:
                    seekBarValue.setText("Value 6: " + value + "\n");
                    break;

                case R.id.seekBar7:
                    seekBarValue.setText("Value 7: " + value + "\n");
                    break;

                case R.id.seekBar8:
                    seekBarValue.setText("Value 8: " + value + "\n");
                    break;

                case R.id.seekBar9:
                    seekBarValue.setText("Value 9: " + value + "\n");
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

    /**
     * Method to make json object request where json response starts wtih {
     * */
    /*private void makeJsonObjectRequest() {

        showpDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest( Method.GET,
                urlJsonObj, (String)null, new Response.Listener<JSONObject>() {

            @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    try{
                    //Parsing json object response
                    // response will be a json object
                         String test = response.getString("test");

                         jsonResponse = "";
                         jsonResponse += "TestJSON: " + test + "\n\n";
                         jsonResponse += "TestExtra: " + test + "\n\n";

                         txtResponse.setText(jsonResponse);
                    } catch (JSONException e) {
                         e.printStackTrace();
                         Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
                                 Toast.LENGTH_LONG).show();
                    }
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                //hide progress dialog
                hidepDialog();
            }
        });

        //Adding request to request queue
        JSONadapter.getInstance().addToRequestQueue(jsonObjReq);
    }*/

    /**
     * Method to make json array request where response starts with [
     * */


       //onclicklistener voor alle info buttons instellen
        public void init() {
            info1 = (ImageButton) findViewById(R.id.info1);
            info1.setOnClickListener(this);

            info2 = (ImageButton) findViewById(R.id.info2);
            info2.setOnClickListener(this);

            info3 = (ImageButton) findViewById(R.id.info3);
            info3.setOnClickListener(this);

            info4 = (ImageButton) findViewById(R.id.info4);
            info4.setOnClickListener(this);

            info5 = (ImageButton) findViewById(R.id.info5);
            info5.setOnClickListener(this);

            info6 = (ImageButton) findViewById(R.id.info6);
            info6.setOnClickListener(this);

            info7 = (ImageButton) findViewById(R.id.info7);
            info7.setOnClickListener(this);

            info8 = (ImageButton) findViewById(R.id.info8);
            info8.setOnClickListener(this);

            info9 = (ImageButton) findViewById(R.id.info9);
            info9.setOnClickListener(this);

    }

    //if statements instellen voor de info buttons, zodat de goede info weergegeven wordt
    public void onClick(View v){
        if (v.getId() == R.id.info1){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Wat is belangrijk in het ontwikkelproces? Staan de stakeholders centraal of het bewaken van de processen en de uitvoering hiervan het belangrijkst?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info2){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Wil de methode vooral software ontwikkelen of moet er vanuit bijvoorbeeld kwaliteitbewaking vooral formele documenten geschreven worden?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue met applicatie
                                }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info3){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Hoe staat het projectteam in het proces. Is het vooral belangrijk om door samenwerking tot aansluitende software te komen, of moeten de requirements in de vorm van een contract overlegd worden?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info4){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Hoe wordt er ingespeeld op dynamische omgevingen en veranderende requirements. Is daar ruimte voor of moet alles van te voren gepland worden?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info5){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Moet de software als geheel product in een keer worden gepresenteerd en geimplementeerd, of kan dit in delen gebeuren?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info6){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Wordt er vanuit de stakeholders naar het proces gekeken of vanuit de techniek?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info7){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Moet het opgeleverde product voldoen aan de business eisen, of wordt er vanuit mogelijkheden gekeken naar de ontwikkeling?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info8){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Is het ontwikkelteam autonoom, of moet het proces beheerst en gestuurd kunnen worden van buitenaf?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else if(v.getId() == R.id.info9){
            new AlertDialog.Builder(this)
                    .setTitle("Information")
                    .setMessage("Ligt het hele ontwikkel proces vastgelegd door de methode of is er veel ruimte voor eigen invulling in het proces?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue met applicatie
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }

        else {
            // niets
        }

    }

    public void gewicht(View view){
        Intent intent = new Intent(MainActivity.this, Weight.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}

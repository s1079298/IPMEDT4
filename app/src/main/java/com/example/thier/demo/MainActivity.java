package com.example.thier.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private SeekBar seekBar;
    private TextView textView;

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

        //Sliders instellen naar max 4
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setMax(4);

        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setProgress(0);
        seekBar2.setMax(4);

        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.setProgress(0);
        seekBar3.setMax(4);

        SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar4.setProgress(0);
        seekBar4.setMax(4);

        SeekBar seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar5.setProgress(0);
        seekBar5.setMax(4);

        SeekBar seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
        seekBar6.setProgress(0);
        seekBar6.setMax(4);

        SeekBar seekBar7 = (SeekBar) findViewById(R.id.seekBar7);
        seekBar7.setProgress(0);
        seekBar7.setMax(4);

        SeekBar seekBar8 = (SeekBar) findViewById(R.id.seekBar8);
        seekBar8.setProgress(0);
        seekBar8.setMax(4);

        SeekBar seekBar9 = (SeekBar) findViewById(R.id.seekBar9);
        seekBar9.setProgress(0);
        seekBar9.setMax(4);

        //pop ups met info button
        init();
    }

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

        /**initializeVariables();

        // Initialize the textview with '0'.
        textView.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Covered: " + progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        }}
            };**/

    public void conclusion(View view){
        Toast.makeText(this, "This works!", Toast.LENGTH_SHORT).show();
    }


    // A private method to help us initialize our variables.
    private void initializeVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.vraag1);
    }


    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

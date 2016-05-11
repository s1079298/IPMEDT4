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
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SlidersActivity extends AppCompatActivity
        implements OnSeekBarChangeListener, OnClickListener {

    //value voor de seekBars
    float value;
    //seekbars
    SeekBar seekBar, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6, seekBar7, seekBar8, seekBar9;

    //info buttons
    ImageButton info1, info2, info3, info4, info5, info6, info7, info8, info9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //seekbars initialiseren
        seekBar = (SeekBar) findViewById(R.id.seekBar);
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

        //init voor de informatie imagebuttons
        init();
    }

    //value berekenen van de seekBars, deze moeten door 4 gedeeld worden aangezien de
    // uiteindelijke values tot max 1 komen (0.00, 0.25, 0.50, 0.75, 1.00)
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        value = ((float)progress / 4 );
    }
    //autogegenereerde methodes
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated  method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated  method stub
    }

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

    //if statements instellen voor de negen info buttons, zodat de goede info weergegeven wordt
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
    }

    public void gewicht(View view){
        //intent initialiseren
        Intent intent = new Intent(SlidersActivity.this, Weight.class);

        //doorsturen data van de seekbars naar weight.class
        intent.putExtra("s", ((double)seekBar.getProgress()));
        intent.putExtra("s2", ((double)seekBar2.getProgress()));
        intent.putExtra("s3", ((double)seekBar3.getProgress()));
        intent.putExtra("s4", ((double)seekBar4.getProgress()));
        intent.putExtra("s5", ((double)seekBar5.getProgress()));
        intent.putExtra("s6", ((double)seekBar6.getProgress()));
        intent.putExtra("s7", ((double)seekBar7.getProgress()));
        intent.putExtra("s8", ((double)seekBar8.getProgress()));
        intent.putExtra("s9", ((double)seekBar9.getProgress()));

        //start Weight klasse
        startActivity(intent);
    }
}
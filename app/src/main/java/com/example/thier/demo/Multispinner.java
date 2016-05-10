package com.example.thier.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class Multispinner extends Activity implements OnSeekBarChangeListener, OnClickListener {
	//buttons initialiseren van de spinners
	Button selectProjectTypenButton, selectOntwikkelStrategieButton, selectProcesActiviteitenButton, selectCMMButton;

	public static final String DEFAULT = "N/A";
	//value voor de seekbar
	public int value;

	//value van de checkboxes van Project Typen
    int value0, value1, value2, value3, value4, value5, value6, value7, value8, value9;

	//int value van de checkboxes van Ontwikkel Strategie
	int valueOS, valueOS1, valueOS2, valueOS3, valueOS4, valueOS5, valueOS6;

	//int value van de checkboxes van proces activiteiten
	int valuePA, valuePA1, valuePA2, valuePA3, valuePA4, valuePA5, valuePA6, valuePA7, valuePA8, valuePA9;

	//int value voor CMM
	int valueCM1, valueCM2, valueCM3, valueCM4, valueCM5;

	//gewichten
	SeekBar gewichtPT, gewichtOS, gewichtPA, gewichtCM;

	//project typen lijst initialiseren voor uiteindelijk gebruik in Alert Dialog Spinners
	protected CharSequence[] projecttypen = { "Commercieel (off the shelf)", "Data Warehouse",
			"Emergency release", "Integratie / vervanging", "OO applicatie ontwikkeling",
			"Procedurele applicatie ontwikkeling","Voortdurend onderhoud", "Outsourced",
			"Uitfasering", "Bedrijfs-kritische ontwikkeling"  };
	protected ArrayList<CharSequence> selectedProjectTypen = new ArrayList<CharSequence>();

	//ontwikkelstrategie lijst initialiseren voor uiteindelijk gebruik in Alert Dialog Spinners
	protected CharSequence[] ontwikkelstrategie = { "Code and Fix", "Waterval", "Agile", "Spiraal",
			"Extreme Programming", "Prototyping","Rapid Application Design" };
	protected ArrayList<CharSequence> selectedOntwikkelStrategie = new ArrayList<CharSequence>();

	//procesactiviteiten lijst initialiseren voor uiteindelijk gebruik in Alert Dialog Spinners
	protected CharSequence[] procesactiviteiten = { "Requirement definitie en analyse", "Project afbakening",
			"Architectuur en detail ontwerp", "Requirements specificeren", "Ontwikkelen (Programmeren)",
			"Integratie","Installatie", "Testen en acceptatie", "Training en documentatie", "Implementatie en onderhoud" };
	protected ArrayList<CharSequence> selectedProcesActiviteiten = new ArrayList<CharSequence>();

	//cmm level lijst initialiseren voor uiteindelijk gebruik in Alert Dialog Spinners
	protected CharSequence[] cmm = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5" };
	protected ArrayList<CharSequence> selectedCMM = new ArrayList<CharSequence>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_layout);

		//seekbars initialiseren van de gewichten
		gewichtPT = (SeekBar) findViewById(R.id.weightBar);
		gewichtPT.setOnSeekBarChangeListener(this);

		gewichtOS = (SeekBar) findViewById(R.id.weightBarOS);
		gewichtOS.setOnSeekBarChangeListener(this);

		gewichtPA = (SeekBar) findViewById(R.id.weightBarPA);
		gewichtPA.setOnSeekBarChangeListener(this);

		gewichtCM = (SeekBar) findViewById(R.id.weightBarCM);
		gewichtCM.setOnSeekBarChangeListener(this);

		//buttons initialiseren voor gebruik / openen van de spinners
		selectProjectTypenButton = (Button) findViewById(R.id.select_ProjectTypen);
        selectProjectTypenButton.setOnClickListener(this);

		selectOntwikkelStrategieButton = (Button) findViewById(R.id.select_OntwikkelStrategie);
		selectOntwikkelStrategieButton.setOnClickListener(this);

		selectProcesActiviteitenButton = (Button) findViewById(R.id.select_ProcesActiviteiten);
		selectProcesActiviteitenButton.setOnClickListener(this);

		selectCMMButton = (Button) findViewById(R.id.select_CMM);
		selectCMMButton.setOnClickListener(this);
	}

	//als op één van de buttons geklikt wordt, wordt de Dialog Spinner geopend
	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.select_ProjectTypen:
				showSelectProjectTypenDialog();
				break;
			case R.id.select_OntwikkelStrategie:
				showSelectOntwikkelStrategieDialog();
				break;
			case R.id.select_ProcesActiviteiten:
				showSelectProcesActiviteitenDialog();
				break;
			case R.id.select_CMM:
				showSelectCMMDialog();
				break;
			default:
				break;
		}
	}

	protected void onChangeSelectedProjectTypen() {
		StringBuilder stringBuilder = new StringBuilder();

		for(CharSequence ProjectTypen : selectedProjectTypen)
			stringBuilder.append(ProjectTypen + ",");

        selectProjectTypenButton.setText(stringBuilder.toString());
	}

	protected void showSelectProjectTypenDialog() {
		final boolean[] checkedProjectTypen = new boolean[projecttypen.length];
		int count = projecttypen.length;

		for(int i = 0; i < count; i++)
			checkedProjectTypen[i] = selectedProjectTypen.contains(projecttypen[i]);

		DialogInterface.OnMultiChoiceClickListener ProjectTypenDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				//als checkbox aangeklikt is en het gaat om "deze projecttype" value wordt 1 voor versturen json
				if(isChecked && projecttypen[which].equals("Commercieel (off the shelf)")){
					value0 = 1;
				} else if(isChecked && projecttypen[which].equals("Data Warehouse")){
					value1 = 1;
				} else if(isChecked && projecttypen[which].equals("Emergency release")){
					value2 = 1;
				} else if(isChecked && projecttypen[which].equals("Integratie / vervanging")){
					value3 = 1;
				} else if(isChecked && projecttypen[which].equals("OO applicatie ontwikkeling")){
					value4 = 1;
				} else if(isChecked && projecttypen[which].equals("Procedurele applicatie ontwikkeling")){
					value5 = 1;
				} else if(isChecked && projecttypen[which].equals("Voortdurend onderhoud")){
					value6 = 1;
				} else if(isChecked && projecttypen[which].equals("Outsourced")){
					value7 = 1;
				} else if(isChecked && projecttypen[which].equals("Uitfasering")){
					value8 = 1;
				} else if(isChecked && projecttypen[which].equals("Bedrijfs-kritische ontwikkeling")){
					value9 = 1;
				}
				//laat zien welke projecttypen in filter zijn aangeklikt
				if(isChecked){
					selectedProjectTypen.add(projecttypen[which]);
				} else {
					selectedProjectTypen.remove(projecttypen[which]);
				}
                onChangeSelectedProjectTypen();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Project Typen");
		builder.setMultiChoiceItems(projecttypen, checkedProjectTypen, ProjectTypenDialogListener);

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	protected void onChangeSelectedOntwikkelStrategie() {
		StringBuilder stringBuilderOS = new StringBuilder();

		for(CharSequence OntwikkelStrategie : selectedOntwikkelStrategie)
			stringBuilderOS.append(OntwikkelStrategie + ",");

		selectOntwikkelStrategieButton.setText(stringBuilderOS.toString());

	}

	protected void showSelectOntwikkelStrategieDialog() {
		boolean[] checkedOntwikkelStrategie = new boolean[ontwikkelstrategie.length];
		int count = ontwikkelstrategie.length;

		for(int i = 0; i < count; i++)
			checkedOntwikkelStrategie[i] = selectedOntwikkelStrategie.contains(ontwikkelstrategie[i]);

		DialogInterface.OnMultiChoiceClickListener OntwikkelStrategieDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {

				//als de bepaalde ontwikkel strategie is aangeklikt, value wordt 1
				if(isChecked && ontwikkelstrategie[which].equals("Code and Fix")){
					valueOS = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Waterval")) {
					valueOS1 = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Agile")) {
					valueOS2 = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Spiraal")) {
					valueOS3 = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Extreme Programming")) {
					valueOS4 = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Prototyping")) {
					valueOS5 = 1;
				} else if(isChecked && ontwikkelstrategie[which].equals("Rapid Application Design")) {
					valueOS6 = 1;
				}
				//laat zien welke ontwikkel strategie in filter zijn aangeklikt
				if(isChecked)
					selectedOntwikkelStrategie.add(ontwikkelstrategie[which]);
				else //anders verwijder het vinkje
					selectedOntwikkelStrategie.remove(ontwikkelstrategie[which]);

				onChangeSelectedOntwikkelStrategie();
			}
		};

		//initialiseren van de Alert Dialog voor het weergeven van de Ontwikkel Strategie filters
		AlertDialog.Builder builderOS = new AlertDialog.Builder(this);
		builderOS.setTitle("Selecteer Ontwikkel Strategie");
		builderOS.setMultiChoiceItems(ontwikkelstrategie, checkedOntwikkelStrategie, OntwikkelStrategieDialogListener);

		AlertDialog dialogOS = builderOS.create();
		dialogOS.show();
	}

	protected void onChangeSelectedProcesActiviteiten() {
		StringBuilder stringBuilderPA = new StringBuilder();

		for(CharSequence ProcesActiviteiten : selectedProcesActiviteiten)
			stringBuilderPA.append(ProcesActiviteiten + ",");

		selectProcesActiviteitenButton.setText(stringBuilderPA.toString());
	}

	protected void showSelectProcesActiviteitenDialog() {
		boolean[] checkedProcesActiviteiten = new boolean[procesactiviteiten.length];
		int count = procesactiviteiten.length;

		for(int i = 0; i < count; i++)
			checkedProcesActiviteiten[i] = selectedProcesActiviteiten.contains(procesactiviteiten[i]);

		DialogInterface.OnMultiChoiceClickListener ProcesActiviteitenDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {

				//als de bepaalde proces activiteit is aangeklikt, value wordt 1
				if(isChecked && procesactiviteiten[which].equals("Requirement definitie en analyse")){
					valuePA = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Project afbakening")){
					valuePA1 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Architectuur en detail ontwerp")){
					valuePA2 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Requirements specificeren")){
					valuePA3 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Ontwikkelen (Programmeren)")){
					valuePA4 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Integratie")){
					valuePA5 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Installatie")){
					valuePA6 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Testen en acceptatie")){
					valuePA7 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Training en documentatie")){
					valuePA8 = 1;
				} else if(isChecked && procesactiviteiten[which].equals("Implementatie en onderhoud")){
					valuePA9 = 1;
				}
				if(isChecked)
					selectedProcesActiviteiten.add(procesactiviteiten[which]);
				else
					selectedProcesActiviteiten.remove(procesactiviteiten[which]);

				onChangeSelectedProcesActiviteiten();
			}
		};

		AlertDialog.Builder builderPA = new AlertDialog.Builder(this);
		builderPA.setTitle("Selecteer Ontwikkel Strategie");
		builderPA.setMultiChoiceItems(procesactiviteiten, checkedProcesActiviteiten, ProcesActiviteitenDialogListener);

		AlertDialog dialogPA = builderPA.create();
		dialogPA.show();
	}

	protected void onChangeSelectedCMM() {
		StringBuilder stringBuilderCM = new StringBuilder();

		for(CharSequence CMM : selectedCMM)
			stringBuilderCM.append(CMM + ",");

		selectCMMButton.setText(stringBuilderCM.toString());
	}

	protected void showSelectCMMDialog() {
		boolean[] checkedCMM = new boolean[cmm.length];
		int count = cmm.length;

		for(int i = 0; i < count; i++)
			checkedCMM[i] = selectedCMM.contains(cmm[i]);

		DialogInterface.OnMultiChoiceClickListener CMMDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				//als de bepaalde CMM level is aangeklikt, value wordt 1
				if(isChecked && cmm[which].equals("Level 1")){
					valueCM1 = 1;
				} else if(isChecked && cmm[which].equals("Level 2")){
					valueCM2 = 1;
				} else if(isChecked && cmm[which].equals("Level 3")){
					valueCM3 = 1;
				} else if(isChecked && cmm[which].equals("Level 4")){
					valueCM4 = 1;
				} else if(isChecked && cmm[which].equals("Level 5")){
					valueCM5 = 1;
				}
				if(isChecked)
					selectedCMM.add(cmm[which]);
				else
					selectedCMM.remove(cmm[which]);

				onChangeSelectedCMM();
			}
		};

		AlertDialog.Builder builderCM = new AlertDialog.Builder(this);
		builderCM.setTitle("Selecteer Ontwikkel Strategie");
		builderCM.setMultiChoiceItems(cmm, checkedCMM, CMMDialogListener);

		AlertDialog dialog = builderCM.create();
		dialog.show();
	}

	//standaard methodes die geimplementeerd worden voor het gebruik van de seekbar
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		//initialisatie seekbar value progress voor uiteindelijk gebruik in het opsturen van de data
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

	//als op button bereken wordt gedrukt wordt conclusie opnieuw berekend
	public void berekenfilter(View v){
		//initialiseren intent
		Intent i = new Intent(Multispinner.this, Conclusion.class);

        //sharedpref ophalen vanaf conclusion klasse
        SharedPreferences sharedPreferences = getSharedPreferences("filterdata", Context.MODE_PRIVATE);
        String schalen = sharedPreferences.getString("filterdataschalen", DEFAULT);
        String schaalgewicht = sharedPreferences.getString("filterdataschaalgewicht", DEFAULT);

        //verwijderen van extra square brackets in string voor doorsturen nieuwe string
        String regex = "\\[|\\]";
        schalen = schalen.replaceAll(regex, "");
        schaalgewicht = schaalgewicht.replaceAll(regex, "");

        //toast voor als er geen data gevonden is
        if(schalen.equals(DEFAULT) || schaalgewicht.equals(DEFAULT)){
            Toast.makeText(this, "No data was found", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_LONG).show();
        }

        //doorsutren van goede string
		String jsend =
                //String voor projecttypen
                "[[" + String.valueOf(value0) + "," +
                String.valueOf(value1)+ "," +
                String.valueOf(value2)+ "," +
                String.valueOf(value3)+ "," +
                String.valueOf(value4)+ "," +
                String.valueOf(value5)+ "," +
                String.valueOf(value6)+ "," +
                String.valueOf(value7)+ "," +
                String.valueOf(value8)+ "," +
                String.valueOf(value9)+"]" + "," +
                //stringarray voor ontwikkel strategieen
                "[" +
                String.valueOf(valueOS) + "," +
                String.valueOf(valueOS1) + "," +
                String.valueOf(valueOS2) + "," +
                String.valueOf(valueOS3) + "," +
                String.valueOf(valueOS4) + "," +
                String.valueOf(valueOS5) + "," +
                String.valueOf(valueOS6) + "]" + "," +

                //stringarray voor proces activiteiten
                "[" + String.valueOf(valuePA) + "," +
                String.valueOf(valuePA1)+ "," +
                String.valueOf(valuePA2)+ "," +
                String.valueOf(valuePA3)+ "," +
                String.valueOf(valuePA4)+ "," +
                String.valueOf(valuePA5)+ "," +
                String.valueOf(valuePA6)+ "," +
                String.valueOf(valuePA7)+ "," +
                String.valueOf(valuePA8)+ "," +
                String.valueOf(valuePA9)+"]" + "," +

                //stringarray voor cmmi level
                "[" + String.valueOf(valueCM1) + "," +
                String.valueOf(valueCM2)+ "," +
                String.valueOf(valueCM3)+ "," +
                String.valueOf(valueCM4)+ "," +
                String.valueOf(valueCM5)+ "]" + "," +
                //schalen toevoegen
                "[" + schalen + "]" + "," +

                //gewicht toevoegen en daarin schaalgewicht
                "[" + gewichtPT.getProgress() + "," +
                gewichtOS.getProgress() + "," +
                gewichtPA.getProgress() + "," +
                gewichtCM.getProgress() + "," +
                "[" + schaalgewicht + "]]]";

        i.putExtra("FROM_ACTIVITY", "B");

        SharedPreferences msharedpref = getSharedPreferences("jsondata", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = msharedpref.edit();
        edit.putString("jsend", jsend);
        edit.apply();

        Log.d("Dit is de string", jsend);

		//start intent
		startActivity(i);
	}
}
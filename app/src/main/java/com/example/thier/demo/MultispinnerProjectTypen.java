package com.example.thier.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.SeekBar;

public class MultispinnerProjectTypen extends Activity implements OnSeekBarChangeListener, OnClickListener {
	protected Button selectProjectTypenButton;

	//value voor de seekbar
	public int value;

	//value van de checkboxes van Project Typen
	public int value0;
	public int value1;
	public int value2;
	public int value3;
	public int value4;
	public int value5;
	public int value6;
	public int value7;
	public int value8;
	public int value9;

	//gewichten
	SeekBar gewichtPT;
	SeekBar gewichtOS;
	SeekBar gewichtPA;
	SeekBar gewichtCM;

	protected CharSequence[] projecttypen = { "Commercieel (off the shelf)", "Data Warehouse",
			"Emergency release", "Integratie / vervanging", "OO applicatie ontwikkeling",
			"Procedurele applicatie ontwikkeling","Voortdurend onderhoud", "Outsourced",
			"Uitfasering", "Bedrijfs-kritische ontwikkeling"  };
	protected ArrayList<CharSequence> selectedProjectTypen = new ArrayList<CharSequence>();

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

		selectProjectTypenButton = (Button) findViewById(R.id.select_ProjectTypen);
        selectProjectTypenButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.select_ProjectTypen:
				showSelectProjectTypenDialog();
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
				if(isChecked)
                    selectedProjectTypen.add(projecttypen[which]);
				Log.d("Selected Project Typen", String.valueOf(selectedProjectTypen));

				//als checkbox aangeklikt is en het gaat om "deze projecttype" value wordt 1 voor versturen json
				if(isChecked && projecttypen[which].equals("Commercieel (off the shelf)")){
					value0 = 1;
				}

				if(isChecked && projecttypen[which].equals("Data Warehouse")){
					value1 = 1;
				}

				if(isChecked && projecttypen[which].equals("Emergency release")){
					value2 = 1;
				}

				if(isChecked && projecttypen[which].equals("Integratie / vervanging")){
					value3 = 1;
				}

				if(isChecked && projecttypen[which].equals("OO applicatie ontwikkeling")){
					value4 = 1;
				}

				if(isChecked && projecttypen[which].equals("Procedurele applicatie ontwikkeling")){
					value5 = 1;
				}

				if(isChecked && projecttypen[which].equals("Voortdurend onderhoud")){
					value6 = 1;
				}

				if(isChecked && projecttypen[which].equals("Outsourced")){
					value7 = 1;
				}

				if(isChecked && projecttypen[which].equals("Uitfasering")){
					value8 = 1;
				}

				if(isChecked && projecttypen[which].equals("Bedrijfs-kritische ontwikkeling")){
					value9 = 1;
				}

				else
                    selectedProjectTypen.remove(projecttypen[which]);

				Log.d("Test", String.valueOf(which));

                onChangeSelectedProjectTypen();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Project Typen");
		builder.setMultiChoiceItems(projecttypen, checkedProjectTypen, ProjectTypenDialogListener);
		Log.d("Wat print ie", String.valueOf(projecttypen));

		AlertDialog dialog = builder.create();
		dialog.show();
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

	//als op button bereken wordt gedrukt wordt conclusie opnieuw berekend
	public void berekenfilter(View v){
		//initialiseren intent
		Intent i = new Intent(MultispinnerProjectTypen.this, Conclusion.class);

		//verstuur data van de project typen checkboxes
		i.putExtra("value0", value0);
		i.putExtra("value1", value1);
		i.putExtra("value2", value2);
		i.putExtra("value3", value3);
		i.putExtra("value4", value4);
		i.putExtra("value5", value5);
		i.putExtra("value6", value6);
		i.putExtra("value7", value7);
		i.putExtra("value8", value8);
		i.putExtra("value9", value9);

		i.putExtra("g", gewichtPT.getProgress());
		i.putExtra("g2", gewichtOS.getProgress());
		i.putExtra("g3", gewichtPA.getProgress());
		i.putExtra("g4", gewichtCM.getProgress());
		//start intent
		startActivity(i);
	}
}
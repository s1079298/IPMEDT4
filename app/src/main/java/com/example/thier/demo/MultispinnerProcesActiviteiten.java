package com.example.thier.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

public class MultispinnerProcesActiviteiten extends Activity implements OnClickListener {
	protected Button selectProcesActiviteitenButton;

	protected CharSequence[] procesactiviteiten = { "Requirement definitie en analyse", "Project afbakening", "Architectuur en detail ontwerp", "Requirements specificeren", "Ontwikkelen (Programmeren)", "Integratie","Installatie", "Testen en acceptatie", "Training en documentatie", "Implementatie en onderhoud" };
	protected ArrayList<CharSequence> selectedProcesActiviteiten = new ArrayList<CharSequence>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_procesactiviteiten);

		selectProcesActiviteitenButton = (Button) findViewById(R.id.select_ProcesActiviteiten);
		selectProcesActiviteitenButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.select_ProcesActiviteiten:
				showSelectProcesActiviteitenDialog();
				break;

			default:
				break;
		}
	}

	protected void onChangeSelectedProcesActiviteiten() {
		StringBuilder stringBuilder = new StringBuilder();

		for(CharSequence ProcesActiviteiten : selectedProcesActiviteiten)
			stringBuilder.append(ProcesActiviteiten + ",");

	}

	protected void showSelectProcesActiviteitenDialog() {
		boolean[] checkedProcesActiviteiten = new boolean[procesactiviteiten.length];
		int count = procesactiviteiten.length;

		for(int i = 0; i < count; i++)
			checkedProcesActiviteiten[i] = selectedProcesActiviteiten.contains(procesactiviteiten[i]);

		DialogInterface.OnMultiChoiceClickListener ProcesActiviteitenDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if(isChecked)
					selectedProcesActiviteiten.add(procesactiviteiten[which]);
				else
					selectedProcesActiviteiten.remove(procesactiviteiten[which]);

				onChangeSelectedProcesActiviteiten();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Ontwikkel Strategie");
		builder.setMultiChoiceItems(procesactiviteiten, checkedProcesActiviteiten, ProcesActiviteitenDialogListener);

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
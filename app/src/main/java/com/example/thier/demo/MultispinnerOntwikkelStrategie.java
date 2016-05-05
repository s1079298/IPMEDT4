package com.example.thier.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

public class MultispinnerOntwikkelStrategie extends Activity implements OnClickListener {
	protected Button selectOntwikkelStrategieButton;

	protected CharSequence[] ontwikkelstrategie = { "Code and Fix", "Waterval", "Agile", "Spiraal", "Extreme programming", "Prototyping","Rapid Application Design" };
	protected ArrayList<CharSequence> selectedOntwikkelStrategie = new ArrayList<CharSequence>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_ontwikkelstrategie);

		selectOntwikkelStrategieButton = (Button) findViewById(R.id.select_OntwikkelStrategie);
        selectOntwikkelStrategieButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.select_OntwikkelStrategie:
				showSelectOntwikkelStrategieDialog();
				break;

			default:
				break;
		}
	}

	protected void onChangeSelectedOntwikkelStrategie() {
		StringBuilder stringBuilder = new StringBuilder();

		for(CharSequence OntwikkelStrategie : selectedOntwikkelStrategie)
			stringBuilder.append(OntwikkelStrategie + ",");

	}

	protected void showSelectOntwikkelStrategieDialog() {
		boolean[] checkedOntwikkelStrategie = new boolean[ontwikkelstrategie.length];
		int count = ontwikkelstrategie.length;

		for(int i = 0; i < count; i++)
			checkedOntwikkelStrategie[i] = selectedOntwikkelStrategie.contains(ontwikkelstrategie[i]);

		DialogInterface.OnMultiChoiceClickListener OntwikkelStrategieDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if(isChecked)
                    selectedOntwikkelStrategie.add(ontwikkelstrategie[which]);
				else
                    selectedOntwikkelStrategie.remove(ontwikkelstrategie[which]);

                onChangeSelectedOntwikkelStrategie();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Ontwikkel Strategie");
		builder.setMultiChoiceItems(ontwikkelstrategie, checkedOntwikkelStrategie, OntwikkelStrategieDialogListener);

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
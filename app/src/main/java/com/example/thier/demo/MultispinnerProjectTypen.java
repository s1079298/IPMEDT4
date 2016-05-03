package com.example.thier.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultispinnerProjectTypen extends Activity implements OnClickListener {
	protected Button selectProjectTypenButton;

	protected CharSequence[] projecttypen = { "Commercieel (off the shelf)", "Data Warehouse", "Emergency release", "Integratie / vervanging", "OO applicatie ontwikkeling", "Procedurele applicatie ontwikkeling","Voortdurend onderhoud", "Outsourced", "Uitfasering", "Bedrijfs-kritische ontwikkeling"  };
	protected ArrayList<CharSequence> selectedProjectTypen = new ArrayList<CharSequence>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_layout);

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
		boolean[] checkedProjectTypen = new boolean[projecttypen.length];
		int count = projecttypen.length;

		for(int i = 0; i < count; i++)
			checkedProjectTypen[i] = selectedProjectTypen.contains(projecttypen[i]);

		DialogInterface.OnMultiChoiceClickListener ProjectTypenDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if(isChecked)
                    selectedProjectTypen.add(projecttypen[which]);
				else
                    selectedProjectTypen.remove(projecttypen[which]);

                onChangeSelectedProjectTypen();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Project Typen");
		builder.setMultiChoiceItems(projecttypen, checkedProjectTypen, ProjectTypenDialogListener);

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
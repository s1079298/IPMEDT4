package com.example.thier.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

public class MultispinnerCMM extends Activity implements OnClickListener {
	protected Button selectCMMButton;

	protected CharSequence[] cmm = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5" };
	protected ArrayList<CharSequence> selectedCMM = new ArrayList<CharSequence>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_cmm);

		selectCMMButton = (Button) findViewById(R.id.select_CMM);
		selectCMMButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.select_CMM:
				showSelectCMMDialog();
				break;

			default:
				break;
		}
	}

	protected void onChangeSelectedCMM() {
		StringBuilder stringBuilder = new StringBuilder();

		for(CharSequence CMM : selectedCMM)
			stringBuilder.append(CMM + ",");

	}

	protected void showSelectCMMDialog() {
		boolean[] checkedCMM = new boolean[cmm.length];
		int count = cmm.length;

		for(int i = 0; i < count; i++)
			checkedCMM[i] = selectedCMM.contains(cmm[i]);

		DialogInterface.OnMultiChoiceClickListener CMMDialogListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if(isChecked)
					selectedCMM.add(cmm[which]);
				else
					selectedCMM.remove(cmm[which]);

				onChangeSelectedCMM();
			}
		};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecteer Ontwikkel Strategie");
		builder.setMultiChoiceItems(cmm, checkedCMM, CMMDialogListener);

		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
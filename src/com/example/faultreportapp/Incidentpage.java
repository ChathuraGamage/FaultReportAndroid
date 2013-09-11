package com.example.faultreportapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Incidentpage extends Activity {
	
	private Report rep;

	public Incidentpage() {
		super();
		rep = new Report(1);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incidentpage);			
	}
	
	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
		    .setIcon(android.R.drawable.ic_dialog_info)
	        .setTitle("Going back!")
	        .setMessage("Are you sure you want to go back? Current input data will be lost.")
	        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
	    {
	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	            finish();    
	        }
	    })
	    .setNegativeButton("No", null)
	    .show();
	}
}
package com.example.faultreportapp;

import android.app.Activity;
import android.os.Bundle;

public class Incidentpage extends Activity {
	
	private Report rep;

	public Incidentpage() {
		super();
		rep = new Report(1);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incidentpage);
				
	}
	
}
package com.example.faultreportapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Faultpage extends Activity {
	private Report rep;

	public Faultpage() {
		super();
		rep = new Report(2);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faultpage);
				
	}
	 
}

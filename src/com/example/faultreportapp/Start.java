package com.example.faultreportapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		Button fault=(Button)findViewById(R.id.Button01);
		Button incident=(Button)findViewById(R.id.button1);
		
		fault.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent inte =new Intent(Start.this, Faultpage.class);
				
				startActivity(inte);
				
				
			}
		});
		
		incident.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent inte =new Intent(Start.this, Incidentpage.class);
				
				startActivity(inte);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}

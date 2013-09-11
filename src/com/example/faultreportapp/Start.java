package com.example.faultreportapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		Button fault=(Button)findViewById(R.id.Button01);
		Button incident=(Button)findViewById(R.id.button1);
		
		fault.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent =new Intent(Start.this, Faultpage.class);
				
				startActivity(intent);
				
				
			}
		});
		
		incident.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent =new Intent(Start.this, Incidentpage.class);
				
				startActivity(intent);
							
			}
		});
		
		
		if (getIntent().getBooleanExtra("EXIT", false)) {
	         finish();
	    }
		
	}
	
	
	@Override
	public void onBackPressed() {
		Intent intent =new Intent(Start.this, Exitconfirm.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}

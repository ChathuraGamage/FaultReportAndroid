package com.example.faultreportapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Exitconfirm extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//avoiding appname from displaying
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exitconfirm);
		
		Button yes =(Button)findViewById(R.id.yesB);
		Button no =(Button)findViewById(R.id.noB);
		
		//On clicking yes exit the app
		yes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), Start.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);								
				
			}
		});
		
		//On clicking no stays on in the app
		no.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});	
	}	
}

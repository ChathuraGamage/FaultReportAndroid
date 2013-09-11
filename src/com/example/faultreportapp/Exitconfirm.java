package com.example.faultreportapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Exitconfirm extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exitconfirm);
		
		Button yes =(Button)findViewById(R.id.yesB);
		Button no =(Button)findViewById(R.id.noB);
		
				
		
		yes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				System.exit(0);
				
			}
		});
		no.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				System.exit(0);
				
			}
		});
		
	}
	

}

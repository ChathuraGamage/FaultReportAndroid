package com.example.faultreportapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Incidentpage extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incidentpage);
		
		final TextView name=(TextView)findViewById(R.id.entername1);
		final TextView place=(TextView)findViewById(R.id.enterplace1);
		final TextView description=(TextView)findViewById(R.id.description1);
		Button send = (Button)findViewById(R.id.send1);
		
		
		/*
		 * Store data in Json arrays when send is pressed.
		 * Then send the data.
		 */
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Toast.makeText(Incidentpage.this, "button was pressed",
	                    Toast.LENGTH_SHORT).show();
	            try {
	                JSONObject json = new JSONObject();
	                json.put("category",1);
	                json.put("name", ""+name.getText()); 
	                json.put("place", ""+place.getText());
	                json.put("description", ""+description.getText());
	                //postData(json);

	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
				
			}
		});
		
	}
	
	/*
	 * This method makes sure that the user confirms go back.
	 * Going back discards the data entered.
	 */
	
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
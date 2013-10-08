package com.faultreport.app;

import com.example.faultreportapp.R;
import com.faultreport.web.ServiceClient;

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

import java.lang.StringBuilder;

public class Incidentpage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incidentpage);

		final TextView name = (TextView) findViewById(R.id.entername1);
		final TextView place = (TextView) findViewById(R.id.enterplace1);
		final TextView description = (TextView) findViewById(R.id.description1);
		final String content = "";
		Button send = (Button) findViewById(R.id.send1);
		final StringBuilder str = new StringBuilder(content);
		final ServiceClient client = new ServiceClient();

		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				str.append("reporterid=");
				str.append(name.getText());
				str.append(";location=");
				str.append(place.getText());
				str.append(";description=");
				str.append(description.getText());
				str.append(";category=1");

				Toast.makeText(Incidentpage.this, "please wait..",
						Toast.LENGTH_SHORT).show();
				try {
					boolean success = client.sendReport(str.toString());
					if (success) {
						messege("Success",
								"Your report was successfully recorded.",
								"Exit", "Report another");
					}
					else
					{
						messege("Failed",
								"Something went wrong. Please do not leave any field blank and Please check your internet connection",
								"Exit", "Try again");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	/*
	 * This method makes sure that the user confirms go back. Going back
	 * discards the data entered.
	 */

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setIcon(android.R.drawable.ic_dialog_info)
				.setTitle("Going back!")
				.setMessage(
						"Are you sure you want to go back? Current input data will be lost.")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
							}
						}).setNegativeButton("No", null).show();
	}

	/*
	 * common messages
	 */
	public void messege(String state, String message, String yes, String no) {
		new AlertDialog.Builder(this)
				.setIcon(android.R.drawable.ic_dialog_info).setTitle(state)
				.setMessage(message)
				.setPositiveButton(yes, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(getApplicationContext(),
								Start.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						intent.putExtra("EXIT", true);
						startActivity(intent);
					}
				}).setNegativeButton(no, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				}).show();
	}
}
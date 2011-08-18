package com.android.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.AdapterView.OnItemSelectedListener;

// Class on Android Application that invokes the Android App UI
public class HelloAndroid1 extends Activity {

	final Button button1 = null;
	final Button button2 = null;
	String storeSelected = null;

	// Anonymous Class  that fetches the Store name Selected 
	private class MyOnItemSelectedListener implements OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
              storeSelected = parent.getItemAtPosition(pos).toString();
        }
        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        	storeSelected = null;
        }
    }
	
	/** Called when the activity is first created. */
	@Override
    
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final  TextView tv = (TextView) findViewById(R.id.TextView01);
		
		// Configuration Setting  on Android Application for invoking the Public Web Hosted Apache Tomcat And Mongo DB
		Configuration.setConfiguration("http://50.18.188.154:8080/WebService_Project/services/InputItemDetail");
		
		//Local Web Hosting
		//Configuration.setConfiguration("http://10.0.2.2:8080/WebService_Project/services/InputItemDetail");
		
		//Store Name Dropdown 
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.store_name_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);

	    spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	    
		//OK button
		final Button button1 = (Button) findViewById(R.id.ok);
		button1.setOnClickListener(new View.OnClickListener() {
			public String objectLoc;
			public void onClick(View v) {
				// Perform action on click
				final EditText et = (EditText) findViewById(R.id.entry);
				
				
				 
				final String content = et.getText().toString(); //gets you the contents of edit text
				if (content == null) {
					et.setText("Please enter the item name!!");
					return;
				}
				if (storeSelected == null) {
					et.setText("Please select a store");
					return;					
				}
				Thread itemLocatorThread = new Thread(new Runnable() {
					public void run() {
						objectLoc = InputItemDetail.getItemName(content+":"+storeSelected);
								}
				});
				itemLocatorThread.start();
				
				try {
					itemLocatorThread.join();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					et.setText("Unknow Error");
					return;
				}
				tv.setTypeface(null,Typeface.BOLD);
				tv.setText(objectLoc);
				tv.setTypeface(null,Typeface.BOLD);
			}
		});

		//Cancel Button
		final Button button2 = (Button) findViewById(R.id.xxl);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				EditText et = (EditText) findViewById(R.id.entry);
				et.setText("");
				tv.setText("");
			}
		});

} // End onCreate() 

}// End HelloAndroid1



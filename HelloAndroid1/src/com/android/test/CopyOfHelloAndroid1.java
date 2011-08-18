package com.android.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
//import com.android.test.StandaloneJavaClient;
//import com.android.test.InputItemDetailServiceStub;
//import com.android.test.InputItemDetailServiceCallbackHandler;


public class CopyOfHelloAndroid1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.main);
        TextView tv = new TextView(this);
        
        //tv. setText("Hello, Welcome to Object Locator Application !");
        //tv.setSoundEffectsEnabled(true);
        //tv.setText("@[com.android.test:]StandaloneJavaClient:getItemInAndriod()");
        //tv.setText(StandaloneJavaClient.getItemInAndriod());
        //StandaloneJavaClient.getItemInAndriod();
        Configuration.setConfiguration("http://10.0.2.2:8080/WebService_Project/services/InputItemDetail");
        tv.setText("Test is Running");
        setContentView(tv);
        Log.d("*******************", tv.toString());
        new Thread(new Runnable() {
            public void run() {
                Log.d("******************", InputItemDetail.getItemName("Apple"));
           }
          }).start();

    }
    
    //String myStaticString = StandaloneJavaClient.getItemInAndriod();
}
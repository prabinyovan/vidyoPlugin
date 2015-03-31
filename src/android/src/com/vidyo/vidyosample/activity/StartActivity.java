package com.vidyo.vidyosample.activity;

import com.vidyo.vidyosample.R;
import com.vidyo.vidyosample.app.ApplicationJni;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends Activity {
	
	private static final String TAG = "StartActivity";
		
	private FakeR fakeR;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "entering onCreate");
        super.onCreate(savedInstanceState);
        
		fakeR = new FakeR(this);
		
        // Only do this the first time
        if (savedInstanceState == null) {
			Object object = (Object)getApplication();
			ApplicationJni app;
			if (object instanceof ApplicationJni) {
				app = (ApplicationJni)object;
				
				
				// THIS MUST BE CALLED TO INITIALIZE THE VIDYOCLIENT JNI LIBRARY
				Log.d(TAG, "Initializing JNI");
				app.LmiAndroidJniInitialize();
			}
        }

        
        
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
						
		setContentView(fakeR.getId("layout", "custom_dialog")); 	
    	
		String portalInfoArray[] = { "http://rinsoft.sandboxga.vidyo.com", "admin", "rinsoftVd#1"};

		final StringBuffer serverString = new StringBuffer(portalInfoArray[0]);
		final StringBuffer usernameString = new StringBuffer(portalInfoArray[1]);
		final StringBuffer passwordString = new StringBuffer(portalInfoArray[2]);

		final Button login_button = (Button) findViewById(fakeR.getId("id", "login_button"));
		
		final TextView server = (TextView) findViewById(fakeR.getId("id", "vidyoportal_edit"));
		final TextView username = (TextView) findViewById(fakeR.getId("id", "username_edit"));
		final TextView password = (TextView) findViewById(fakeR.getId("id", "password_edit"));

		server.setText(serverString.subSequence(0, serverString.length()));
		username.setText(usernameString.subSequence(0, usernameString.length()));
		password.setText(passwordString.subSequence(0, passwordString.length()));

		login_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.e(TAG, ">>>>>>>>>>>>>>>>>>> Onclick event starts ");
				final Intent intent = new Intent(StartActivity.this, VidyoSampleActivity.class);
				Log.e(TAG, ">>>>>>>>>>>>>>>>>>> Intent defined!");
				intent.putExtra("server", server.getText().toString());
				intent.putExtra("username", username.getText().toString());
				intent.putExtra("password", password.getText().toString());
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				Log.e(TAG, ">>>>>>>>>>>>>>>>>>> Going to start activity using intent.");
				try{
					startActivity(intent);
					Log.e(TAG, ">>>>>>>>>>>>>>>>>>> Activity started!");
				}
				catch(Exception e){
					Log.e(TAG, ">>>>>>>>>>>>>>>>>>> Start activity fails");
					Log.e(TAG, ">>>>>>>>>>>>>>>>>>> " + e.getMessage());
				}
				
			}
		});
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
}

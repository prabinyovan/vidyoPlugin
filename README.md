# vidyoPlugin
### Create Ionic Project
  Open command prompt and run the following command  
  `ionic start MyApp blank`  
  
  `cd MyApp`  
  
  `ionic platform add android`  
  
  Make sure that your that your ionic app builds without any error at this point  by running the below command  
  
  `ionic build android`  
  
  Confirm that you have not recieved any error during build  
  
### Add Plugin to Ionic project
 Run the below command
 
 `ionic plugin add https://github.com/prabinyovan/vidyoPlugin.git`  
 
 This will add the plugin into your ionic project You can find that at
 `MyApp\Plugins\com.vidyo.vidyosample.activity`  
 
 Building the ionic project at this point will give you error, fix it by pasting the following xml nodes into `MyApp\Platforms\android\res\values\strings.xml` inside `<resources>` tag  
 
 `<string name="hello">Welcome to VidyoSampleActivity!</string>  
 
    <string name="login">Login</string>  
    <string name="join_button_text">Join Own Room</string>  
    <string name="join_dialog_title">Join My own room</string>  
    <string name="secured_checkbox">secured</string>  
    <string name="contacting_provider">You are the next patient to see {0}.</string>  
    <string name="be_patient">{0} is reviewing your information. Your visit will begin shortly.</string>  
    <string name="conversation_begin">Please wait.\nYour visit is about to begin.</string>  
    <string name="refresh_video_loading">Refreshing Video…\nThe provider can call you back if you lose your connection.</string>  
    <string name="ending_engagement_text">Please wait. \nYour visit is wrapping up.</string>  
    <string name="be_there_shortly">The provider will be with you shortly</string>  
    <string name="paged_with_request">This provider has been paged with your request.</string>  
    <string name="video_connect_failed">Connection Failed</string>  
    <string name="video_connect_failed_info">The connection to the video server failed.</string>  
    <string name="video_issue_request">If your visit is interrupted or dropped for any reason, the provider will call you back at the number you entered.</string>  
    <string name="confirm_cancel">Confirm Cancel</string>  
    <string name="console_title">Video Conversation</string>  
    <string name="console_endConversation">End Visit</string>  
    <string name="console_end">End</string>  
    <string name="console_refresh_video">Refresh Video</string>  
    <string name="console_end_engagement_message">This will end your visit.</string>  
    <string name="console_lost_video_message">This will end your visit.  We suggest waiting a few minutes to see if your video returns.</string>  
    <string name="console_the_end_is_near_message">You have less than 1 minute remaining.</string>  
    <string name="console_conversation_expired">The available time for this visit has expired.</string>  
    <string name="misc_cancel">Cancel</string>  
    <string name="misc_exit">Exit</string>`  
    
  Build the ionic project now, you will not get any error at this point. But the app won'r work as expected. You should modify the `application` part of  `AndroidManifest.xml` file to get it worked as expected. You should add **`android:name="com.vidyo.vidyosample.app.ApplicationJni"`**
  
  Replace  
  `<application android:hardwareAccelerated="true" android:icon="@drawable/icon" android:label="@string/app_name">`  
  into  
  `<application android:hardwareAccelerated="true" android:icon="@drawable/icon" android:label="@string/app_name" android:name="com.vidyo.vidyosample.app.ApplicationJni">`  

### Usage
 Add te following code into your `app.js`  
 
  `window.Hello.getPictures(  
		function(results) {  
		}, function (error) {  
			alert("Error: " + error);  
		}  
	);`
 
  
  
  

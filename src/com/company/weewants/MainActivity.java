package com.company.weewants;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //removes title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //configures go button
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(goHandler);
        // parse sdk initiliaze
        Parse.initialize(this, "FQEHCb7g6J0pPKokLMdYfyfDgG9CP1gkR9tgEhms", "FIokZyK7sf7vRmpoybJ8ZQeA5WkCQKj6LWOz8PbK");
        //specify default activity to handle push notifications
        PushService.setDefaultPushCallback(this, MainActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        //tracking
        ParseAnalytics.trackAppOpened(getIntent());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


private View.OnClickListener goHandler = new View.OnClickListener() {

    @Override
    public void onClick(final View v) {
        Intent myIntent = new Intent(MainActivity.this, HubActivity.class);
        startActivity(myIntent);

    }

};
}

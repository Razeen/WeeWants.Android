package com.company.weewants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class HubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hub);

        ImageButton plus = (ImageButton) findViewById(R.id.plus);
        plus.setOnClickListener(plusHandler);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View.OnClickListener plusHandler = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            Intent myIntent = new Intent(HubActivity.this, PostActivity.class);
            startActivity(myIntent);

        }

    };



    
}

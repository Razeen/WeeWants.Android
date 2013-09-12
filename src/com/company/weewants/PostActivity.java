package com.company.weewants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class PostActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_post);

        //configure save button
        //configures go button
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.save);
        imageButton1.setOnClickListener(saveHandler);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private View.OnClickListener saveHandler = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            // Create the Post object
            ParseObject post = new ParseObject("Post");
            post.put("textContent", "yes");

            // Create an author relationship with the current user
            post.put("author", ParseUser.getCurrentUser());

            // Save the post and return
            post.saveInBackground(new SaveCallback() {

                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        setResult(RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Error saving: " + e.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }

            });

            PostActivity.this.setResult(Activity.RESULT_OK);
            PostActivity.this.finish();


        }

    };



}

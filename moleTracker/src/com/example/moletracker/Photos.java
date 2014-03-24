package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Photos extends Activity
{
    
    public final static String EXTRA_BACK_LABEL = "com.example.moletracker.BACK_LABEL";
    String part;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.molephotos);
        Intent intent = getIntent();
        String backlabel = intent.getStringExtra(Area.EXTRA_FORWARD_LABEL);
        part = intent.getStringExtra(Area.EXTRA_LABEL);
        setTitle(backlabel);

    }

    public void takePhoto(View view) {
        Intent intent = new Intent(this, PhotoTaker.class);
        startActivity(intent);    
    } 

    public void back(View view) {
        Intent intent = new Intent(this, Area.class);
        intent.putExtra(EXTRA_BACK_LABEL, part);
        startActivity(intent);
    }


}

package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void about(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);    
    }

    public void profile(View view) {
        Intent intent = new Intent(this, SkinAreas.class);
        startActivity(intent);
    }


}

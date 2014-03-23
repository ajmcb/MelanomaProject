package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class SkinAreas extends Activity
{
    
    public final static String EXTRA_LABEL = "com.example.moletracker.LABEL";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skinareas);
    }

    public void back(View view) {
       Intent intent = new Intent(this, MainActivity.class);
       startActivity(intent);
    } 

    public void area1(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Head and Neck";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    } 
    public void area2(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Left Arm";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }  
    public void area3(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Right Arm";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }  
    public void area4(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Front Torso";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }  
    public void area5(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Back Torso";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }  
    public void area6(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Left Leg";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }  
    public void area7(View view) {
       Intent intent = new Intent(this, Area.class);
       String label = "Right Leg";
       intent.putExtra(EXTRA_LABEL, label);
       startActivity(intent);
    }     
}

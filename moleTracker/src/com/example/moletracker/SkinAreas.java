package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class SkinAreas extends Activity
{
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
       startActivity(intent);
    } 
    public void area2(View view) {
       Intent intent = new Intent(this, Area2.class);
       startActivity(intent);
    }  
    public void area3(View view) {
       Intent intent = new Intent(this, Area3.class);
       startActivity(intent);
    }  
    public void area4(View view) {
       Intent intent = new Intent(this, Area4.class);
       startActivity(intent);
    }  
    public void area5(View view) {
       Intent intent = new Intent(this, Area5.class);
       startActivity(intent);
    }  
    public void area6(View view) {
       Intent intent = new Intent(this, Area6.class);
       startActivity(intent);
    }  
    public void area7(View view) {
       Intent intent = new Intent(this, Area7.class);
       startActivity(intent);
    }  
    public void area8(View view) {
       Intent intent = new Intent(this, Area8.class);
       startActivity(intent);
    }  
    public void area9(View view) {
       Intent intent = new Intent(this, Area9.class);
       startActivity(intent);
    }   
}

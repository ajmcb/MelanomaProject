package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.content.SharedPreferences;

public class Area2 extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area2);
    }

    public void back(View view) {
       finish();
    } 

    public void add(View view) {
        EditText editText = (EditText) findViewById(R.id.location);
        String location = editText.getText().toString();
        Button myButton = new Button(this);
        myButton.setText(location);
        LinearLayout ll = (LinearLayout) findViewById(R.id.area2);
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
        editText.setText("");
    }     
}

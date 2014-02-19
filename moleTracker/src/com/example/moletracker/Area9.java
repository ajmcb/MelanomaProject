package com.example.moletracker;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class Area9 extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);
    }

    public void back(View view) {
       Intent intent = new Intent(this, SkinAreas.class);
       startActivity(intent);
    } 

    public void add(View view) {
        Intent intent = new Intent(this, Area.class);
        EditText editText = (EditText) findViewById(R.id.location);
        String location = editText.getText().toString();
        Button btn = new Button(this);
        btn.setText(location);
    }       
}

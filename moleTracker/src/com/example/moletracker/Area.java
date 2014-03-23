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

public class Area extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area2);
        Intent intent = getIntent();
        String label = intent.getStringExtra(SkinAreas.EXTRA_LABEL);
        setTitle(label);        
    }

    public void back(View view) {
       Intent intent = new Intent(this, SkinAreas.class);
       startActivity(intent);
    } 

    public void add(View view) {
        EditText editText = (EditText) findViewById(R.id.location);
        String location = editText.getText().toString();
        Button myButton = new Button(this);
        myButton.setText(location);
        LinearLayout ll = (LinearLayout) findViewById(R.id.area2);
        LayoutParams lp = new LayoutParams(150, 60);
        ll.addView(myButton, lp);
        editText.setText("");
        editText.setHint("Enter location of mole");
    }       
}

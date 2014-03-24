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
import android.widget.ImageView;
import android.graphics.Color;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;

public class Area extends Activity
{
    public final static String EXTRA_LABEL = "com.example.moletracker.LABEL";
    public final static String EXTRA_FORWARD_LABEL = "com.example.moletracker.FORWARD_LABEL";
    String part;
    /** Called when the activity is first created. */
    int id = 0;
    String label;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        id = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area2);
        Intent intent = getIntent();
        label = intent.getStringExtra(SkinAreas.EXTRA_LABEL);
        if (label != null && !label.isEmpty()) {

        } else {
            label = intent.getStringExtra(Photos.EXTRA_BACK_LABEL);
        }
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
        myButton.setId(id);
        id = id+1;
        myButton.setBackgroundResource(R.drawable.custom_button);
        try {
            XmlResourceParser parser = getResources().getXml(R.drawable.text_colour);
            ColorStateList colors = ColorStateList.createFromXml(getResources(), parser);
            myButton.setTextColor(colors);
        }  catch (Exception e) {
            // handle exceptions
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.area2);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150, 60);
        lp.setMargins(0, 5, 0, 5);
        ll.addView(myButton, lp);

        final Button button = (Button) findViewById(id-1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                part = (String) button.getText();
                photos(v);
            }
        });

        editText.setText("");
        editText.setHint("Enter location of mole");
    }

    public void photos(View view) {
        Intent intent = new Intent(this, Photos.class);
        intent.putExtra(EXTRA_FORWARD_LABEL, part);
        intent.putExtra(EXTRA_LABEL, label);
        startActivity(intent);
    }
       
}

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
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Area extends Activity
{
    
	AddMoleAdapter addmole;

	public SQLiteDatabase db;
	private DataBaseHelper dbHelper;

    public final static String EXTRA_LABEL = "com.example.moletracker.LABEL";
    public final static String EXTRA_FORWARD_LABEL = "com.example.moletracker.FORWARD_LABEL";
    String part;
    /** Called when the activity is first created. */
    int id = 0;
    String label;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area2);
        Intent intent = getIntent();
        label = intent.getStringExtra(SkinAreas.EXTRA_LABEL);
        if (label != null && !label.isEmpty()) {

        } else {
            label = intent.getStringExtra(Photos.EXTRA_BACK_LABEL);
        }
        setTitle(label);


        addmole = new AddMoleAdapter(this);
        addmole = addmole.open();
        int bc = addmole.countButtons(label);
        id = bc;

        LinearLayout ll = (LinearLayout) findViewById(R.id.area2);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150, 60);
        lp.setMargins(0, 5, 0, 5);

        if (bc>0) {
        		System.out.println(bc);
        
        		for (int i=0; i<bc; i++) {
        			Button button = new Button(this);
        			button.setText(addmole.buttonName(label) [i]);
        			button.setId(i);

        			ll.addView(button, lp);
        			button.setBackgroundResource(R.drawable.custom_button);

                	try {
                    	XmlResourceParser parser = getResources().getXml(R.drawable.text_colour);
                    	ColorStateList colors = ColorStateList.createFromXml(getResources(), parser);
                    	button.setTextColor(colors);
                	} catch (Exception e) {
                    	// handle exceptions
                	}
                
                    final Button myButton = (Button) findViewById(i);
        			myButton.setOnClickListener(new View.OnClickListener() {
				
        				@Override
        				public void onClick(View v) {
        					// TODO Auto-generated method stub
                            part = (String) myButton.getText();
        					photos(v);
        				}
        			});
        		}
        	}


        
    }

    public void back(View view) {
       Intent intent = new Intent(this, SkinAreas.class);
       startActivity(intent);
    } 

    public void add(View view) {
        
    	addmole = new AddMoleAdapter(this);
        addmole = addmole.open();

        EditText editText = (EditText) findViewById(R.id.location);
        String location = editText.getText().toString();
		String mlocation = location;
		String marea = label;

        if ((mlocation.equals(""))) {
          	Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();  
        } else {
            addmole.insertEntry(mlocation, marea);
			Toast.makeText(getApplicationContext(), "Mole Added", Toast.LENGTH_LONG).show();
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

    }

    public void photos(View view) {
        Intent intent = new Intent(this, Photos.class);
        intent.putExtra(EXTRA_FORWARD_LABEL, part);
        intent.putExtra(EXTRA_LABEL, label);
        startActivity(intent);
    }
       
}

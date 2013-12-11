/*
 * AddExerciseActivity.java
 * 
 */
package com.example.workoutcompanion;

import java.util.ArrayList;

import com.example.workoutcompanion.dom.Profile;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class AddExerciseActivity extends ListActivity {

	private String exercise_selected = "";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        // storing string resources into Array
        String[] exercises = {"Running", "Swimming", "Bench Press", "Push-Ups", "Sit-Ups"};
         
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.lblListItem, exercises));
         
        ListView lv = getListView();
 
        
        // listening to single list item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view,
        		int position, long id) {
               
	            // selected item 
	            LinearLayout lay = (LinearLayout) view;
	            TextView text = (TextView) lay.getChildAt(0);
	            exercise_selected = text.getText().toString();
	            WorkoutFragment.exercises.add(exercise_selected);
	           
	            finish();
	            // Launching new Activity on selecting single List Item
              
             
        		}
        });
    }

}

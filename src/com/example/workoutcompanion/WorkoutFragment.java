/*
 * WorkoutFragment.java
 * 
 */
package com.example.workoutcompanion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WorkoutFragment extends Fragment {
	
	private Button add;
	
	private Button schedule;
	
	private ListView workout;
	
	public static ArrayList<String> exercises;
	
	private ArrayAdapter<String> adapter;
	
	public WorkoutFragment() {}
	
	@Override
	public View onCreateView(final LayoutInflater inflater, 
			final ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_workout,
				container, false);
		
		add = (Button) view.findViewById(R.id.addExercise);
		add.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				getActivity().startActivityForResult(new Intent(getActivity(), AddExerciseActivity.class), 0);
			}
		});
		
		workout = (ListView) view.findViewById(R.id.favlist);
		
		workout.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				LinearLayout lay = (LinearLayout) arg1;
	            TextView text = (TextView) lay.getChildAt(0);
	            String exercise_selected = text.getText().toString();
	            exercises.remove(exercise_selected);
	            adapter.notifyDataSetChanged();
				
			}


			
		});
		
		exercises = new ArrayList<String>();
		
		adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.lblListItem, exercises);
		
		workout.setAdapter(adapter);

		schedule = (Button) view.findViewById(R.id.button1);
		
		schedule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText entry = (EditText) getActivity().findViewById(R.id.workout_entry);
				
				WorkoutActivity act = (WorkoutActivity) getActivity();
				List<String >work = act.workout;
				HashMap<String, List<String>>exercise = act.exercise;
				if (!(work.contains((String) entry.getText().toString()))){
					work.add((String) entry.getText().toString());
				}
				ArrayList<String> exercises = new ArrayList<String>();
				System.out.println(workout.getChildCount());
				for(int i = 0; i < workout.getChildCount(); i++){
					LinearLayout view = (LinearLayout) workout.getChildAt(i);
					TextView text = (TextView) view.getChildAt(0);
					exercises.add(text.getText().toString());
				}
				System.out.println(exercises.size());
				exercise.put((String) entry.getText().toString(), exercises);
				
				act.listAdapter.notifyDataSetChanged();
				
			}
		});
		return view;
			
	}
	
	@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		

		System.out.println("here");
        if(requestCode == 0) {
        	if(resultCode == Activity.RESULT_OK){
        		
        		String exercise = data.getStringExtra("exercise");
        		System.out.println(exercise);
        		exercises.add(exercise);
        		adapter.notifyDataSetChanged();
        	}
        }
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		adapter.notifyDataSetChanged();
		System.out.println("RESUME");
	}
	

	
	
	

}

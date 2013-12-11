/*
 * ProfileFragment.java
 */

package com.example.workoutcompanion;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.workoutcompanion.dom.Profile;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;


public class ProfileFragment extends Fragment {

	private Button edit;

	private SectionsPagerAdapter adapter;
	
	private TextView user;

	
	private Profile profile;
	public ProfileFragment(){
		this.profile=Profile.getProfile();
		
	}
	
	@Override
	public View onCreateView(final LayoutInflater inflater, 
			final ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile,
				container, false);
		

		user = (TextView) view.findViewById(R.id.welcome_view);
		
		
		edit = (Button) view.findViewById(R.id.editButton);
		edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SectionsPagerAdapter.getInstance().setEditScreen();
				
			}
		});
		
		ExpandableListView exp_list = (ExpandableListView) view.findViewById(R.id.workouts);
		
		
		
		//Example Data
		
		WorkoutActivity act = (WorkoutActivity) getActivity();

		
		
		
		exp_list.setAdapter(act.listAdapter);
		
		return view;
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		//Get the text from the textview and the name from the singleton profile
		String welcome_string = "Welcome";
		String name = Profile.getProfile().getName();
	    try{
	    	System.out.println(name);
	    } catch (NullPointerException e){
	    	name = "User2";
	    }
		if(name.equals("")){
			welcome_string = welcome_string.concat(" User!");
		} else {
			welcome_string = welcome_string.concat(" " + name + "!");
		}
		
		user.setText(welcome_string);
		WorkoutActivity act = (WorkoutActivity) getActivity();
		act.listAdapter.notifyDataSetChanged();
		
	}

}

/*
 * ProfileFragment.java
 */

package com.example.workoutcompanion;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;


public class ProfileFragment extends Fragment {

	private Button edit;

	
	public ProfileFragment(){}
	
	@Override
	public View onCreateView(final LayoutInflater inflater, 
			final ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile,
				container, false);
		edit = (Button) view.findViewById(R.id.editButton);
		edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				inflater.inflate(R.layout.fragment_edit_profile, container, false);
				
			}
		});
		return view;
	}
	
	

}

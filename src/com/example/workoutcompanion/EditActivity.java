/*
 * EditFragment.java
 * 
 */
package com.example.workoutcompanion;

import com.example.workoutcompanion.dom.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EditActivity extends Activity {
		
	private EditText name_field;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_edit_profile);
		
		name_field = (EditText) this.findViewById(R.id.editText1);
		
		
		Button ok = (Button) this.findViewById(R.id.edit_ok);
		ok.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Editable entry = name_field.getText();
				System.out.println("lngth: " + Integer.toString(entry.length()));
				System.out.println("name: " + entry.toString());
				Profile.getProfile().setName(entry.toString());
				finish();
				
			}
		});

	}
	
	@Override
	public void onResume(){
		super.onResume();
		name_field.setText(Profile.getProfile().getName());
	}
	

	
}

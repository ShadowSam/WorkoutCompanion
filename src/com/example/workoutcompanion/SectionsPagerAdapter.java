/*
 * FragmentAdapter.java
 * 
 */
package com.example.workoutcompanion;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */

import java.util.Locale;

import com.example.workoutcompanion.WorkoutActivity.DummySectionFragment;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private WorkoutActivity activity;
	
	private static SectionsPagerAdapter instance;
	
	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public SectionsPagerAdapter(FragmentManager fm, WorkoutActivity activity){
		super(fm);
		this.activity = activity;
		SectionsPagerAdapter.instance = this;
	}
	
	public static SectionsPagerAdapter getInstance(){
		return SectionsPagerAdapter.instance;
	}
	
	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a DummySectionFragment (defined as a static inner class
		// below) with the page number as its lone argument.
		Fragment fragment;
		switch (position){
			case 0:
				fragment = new ProfileFragment();
				Bundle args = new Bundle();
				args.putString("name", this.activity.profile.getName());
				System.out.println(this.activity.profile);
				fragment.setArguments(args);
				break;
			case 1:
				fragment = new WorkoutFragment();
				break;
			default:
				fragment = new DummySectionFragment();
				
		}
		
		return fragment;
	}
	
	public void setEditScreen(){
		Intent intent = new Intent(this.activity, EditActivity.class);
	    this.activity.startActivity(intent);
	    
	}

	@Override
	public int getCount() {
		// Show 2 total pages.
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return activity.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return activity.getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return activity.getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
}
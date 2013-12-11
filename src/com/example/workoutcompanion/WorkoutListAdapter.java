/*
 * WorkoutListAdapter.java
 * 
 */
package com.example.workoutcompanion;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class WorkoutListAdapter extends BaseExpandableListAdapter{

	private Context context;
	
	private List<String> workout_names;
	
	private HashMap<String, List<String>> exercise_names;
	
	public WorkoutListAdapter(Context context, List<String> workouts, HashMap<String, List<String>> exercise_map){
		this.context = context;
		this.workout_names = workouts;
		this.exercise_names = exercise_map;
	}
	
	
	/**
	 * @param groupPosition
	 * @param childPosition
	 * @return
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return this.exercise_names.get(this.workout_names.get(groupPosition)).get(childPosition);
	}

	/**
	 * @param groupPosition
	 * @param childPosition
	 * @return
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	/**
	 * @param groupPosition
	 * @param childPosition
	 * @param isLastChild
	 * @param convertView
	 * @param parent
	 * @return
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		final String childText = (String) getChild(groupPosition, childPosition);
		 
	     if (convertView == null) {
	    	 LayoutInflater infalInflater = (LayoutInflater) this.context
	    			 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	         convertView = infalInflater.inflate(R.layout.list_item, null);
	     }
	 
	     TextView txtListChild = (TextView) convertView
	             .findViewById(R.id.lblListItem);
	 
        txtListChild.setText(childText);
        return convertView;
	}

	/**
	 * @param groupPosition
	 * @return
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return this.exercise_names.get(this.workout_names.get(groupPosition)).size();
	}

	/**
	 * @param groupPosition
	 * @return
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return this.workout_names.get(groupPosition);
	}

	/**
	 * @return
	 */
	@Override
	public int getGroupCount() {
		return this.workout_names.size();
	}

	/**
	 * @param groupPosition
	 * @return
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	/**
	 * @param groupPosition
	 * @param isExpanded
	 * @param convertView
	 * @param parent
	 * @return
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
 
        return convertView;
	}

	/**
	 * @return
	 */
	@Override
	public boolean hasStableIds() {
		return false;
	}

	/**
	 * @param groupPosition
	 * @param childPosition
	 * @return
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		
		return true;
	}

}

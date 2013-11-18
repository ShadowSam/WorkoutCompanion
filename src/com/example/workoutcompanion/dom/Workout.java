package com.example.workoutcompanion.dom;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "workouts")
public class Workout {
	
	public static final String WORKOUT_NAME_COLUMN_FIELD = "name";
	
	@DatabaseField(id = true, columnName = WORKOUT_NAME_COLUMN_FIELD, canBeNull = false)
	private String name;
	@ForeignCollectionField
	private ForeignCollection<Exercise> exercises;
	
	public Workout(String a_sName) {
		name = a_sName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ForeignCollection<Exercise> getExercises() {
		return exercises;
	}
}

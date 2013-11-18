package com.example.workoutcompanion.dom;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "exercises")
public class Exercise {

	public static final String EXERCISE_NAME_COLUMN_FIELD = "name";
	
	@DatabaseField(id = true, columnName = EXERCISE_NAME_COLUMN_FIELD, canBeNull = false)
	private String name;
	@ForeignCollectionField
	private ForeignCollection<Workout> workouts;
	
	public Exercise(String a_sName) {
		name = a_sName;
	}

	public ForeignCollection<Workout> getWorkouts() {
		return workouts;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
}

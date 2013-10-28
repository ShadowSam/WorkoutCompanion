package com.example.workoutcompanion.dom;

public abstract class TableRecord {
	protected Long m_nID;
	
	protected TableRecord() {}
	
	public Long getID() {
		return m_nID;
	}

	public void setID(Long a_nID) {
		m_nID = a_nID;
	}
	
	
}

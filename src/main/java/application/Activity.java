package application;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Activity implements Serializable {

	private static final long serialVersionUID = 6969694201337L;
	private  String name;
	int startWeek = 0, endWeek = 0;
	int hours = 0;
	protected HashMap<String, Employee> employees = new HashMap<String, Employee>();

	public Activity(String name) {
		this.name = name;
	}

	public Activity(String name, int startWeek) {
		this.name = name;
		this.startWeek = startWeek;
	}

	public Activity(String name, int startWeek, int endWeek) {
		this.name = name;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
	}
	public Activity(String name, int startWeek, int endWeek, int hours) {
		this.name = name;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.hours = hours;
	}

	//---
	
	
	// Getters and setters ---------
	
	public String getName() {
		return name;
	}
	
	public int getStartWeek() {
		return startWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}
	public int getHours() {
		return hours;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
	
	public void setHours(int hours) {
		this.hours= hours;
	}

	public boolean containsEmployee(String initials) {
		return employees.containsKey(initials);
	}

}

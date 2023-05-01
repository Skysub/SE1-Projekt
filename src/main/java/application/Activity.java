package application;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Activity implements Serializable {

	private static final long serialVersionUID = 6969694201337L;
	private  String name;
	int startWeek, endWeek;
	protected ArrayList<Employee> employees = new ArrayList<Employee>();

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

	public Object getName() {
		return name;
	}

	// Getters and setters ---------
	public Object getStartWeek() {
		return this.startWeek;
	}

	public Object getEndWeek() {
		return this.endWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public boolean containsEmployee(String initials) {
		for (Employee employee : employees) {
			if (employee.getInitials().equals(initials)) {
				return true;
			}
		}
		return false;
	}

}

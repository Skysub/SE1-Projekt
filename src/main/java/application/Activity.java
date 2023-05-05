package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.util.Pair;

public abstract class Activity implements Serializable {

	private static final long serialVersionUID = 6969694201337L;
	private String name;
	int startWeek = 0, endWeek = 0;
	int hours = 0;
	protected HashMap<String, Employee> employees = new HashMap<String, Employee>();
	protected HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>> registeredTime = new HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>>();

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

	// ---
	// Adds an additional amount of hours to the appropriate employee's registered time
	public float RegisterTime(Employee employee, Float hours, LocalDate date) throws IllegalOperationException {
		if (hours < 0) {
			throw new IllegalOperationException("Cannot register negative time on an activity.");
		}
		float t = 0;
		if (registeredTime.containsKey(employee.getInitials())) {
			if (registeredTime.get(employee.getInitials()).containsKey(date.hashCode())) {
				t = registeredTime.get(employee.getInitials()).get(date.hashCode()).getValue();
			}
		} else {
			registeredTime.put(employee.getInitials(), new HashMap<Integer, Pair<LocalDate, Float>>());
		}
		registeredTime.get(employee.getInitials()).put(date.hashCode(), new Pair<LocalDate, Float>(date, t + hours));
		return employee.registerTime(this, hours, date);
	}

	// Getters and setters ---------

	public String toString(){
		return name;
	}
	
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
		this.hours = hours;
	}

	public boolean containsEmployee(Employee  employee) {
		return employees.containsKey(employee.getInitials());
	}

	public float getTotalTimeRegistered() {
		float totalHours = 0;
		for (Entry<String, HashMap<Integer, Pair<LocalDate, Float>>> entry : registeredTime.entrySet()) {
			HashMap<Integer, Pair<LocalDate, Float>> val = entry.getValue();
			
			for (Entry<Integer, Pair<LocalDate, Float>> entry2 : val.entrySet()) {
				Pair<LocalDate, Float> val2 = entry2.getValue();
				totalHours += val2.getValue();
			}
		}
		return totalHours;
	}

	public float getTotalTimeRegistered(LocalDate date) {
		float totalHours = 0;
		for (Entry<String, HashMap<Integer, Pair<LocalDate, Float>>> entry : registeredTime.entrySet()) {
			HashMap<Integer, Pair<LocalDate, Float>> val = entry.getValue();
			totalHours += val.get(date.hashCode()).getValue();
		}
		return totalHours;
	}

	public float getTimeRegistered(Employee  employee) {
		float totalHours = 0;
		for (Entry<Integer, Pair<LocalDate, Float>> entry2 : registeredTime.get(employee.getInitials()).entrySet()) {
			Pair<LocalDate, Float> val2 = entry2.getValue();
			totalHours += val2.getValue();
		}
		return totalHours;
	}

	public float getTimeRegistered(Employee  employee, LocalDate date) {
		return registeredTime.get(employee.getInitials()).get(date.hashCode()).getValue();
	}

}

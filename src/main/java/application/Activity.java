package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.util.Pair;

//Klassen er skrevet af Frederik Cayré Hede-Andersen på nær de metoder hvor et andet navn står
public abstract class Activity implements Serializable {

	private static final long serialVersionUID = 6969694201337L;
	String name;
	String description;
	int startWeek = 0, endWeek = 0;
	float expectedDuration = -1;
	protected HashMap<String, Employee> employees = new HashMap<String, Employee>();
	protected HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>> registeredTime = new HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>>();

	// Metoden er skrevet af Frederik Hvarregaard
	public Activity(String name) {
		this.name = name;
	}

	// Metoden er skrevet af Frederik Hvarregaard
	public Activity(String name, int startWeek) {
		this.name = name;
		this.startWeek = startWeek;
	}

	// Metoden er skrevet af Frederik Hvarregaard
	public Activity(String name, int startWeek, int endWeek) throws IllegalOperationException {
		if (endWeek < startWeek)
			throw new IllegalOperationException("Endweek cannot be before startweek");
		this.name = name;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
	}

	// ---
	// Adds an additional amount of hours to the appropriate employee's registered time
	// Metoden er skrevet af Frederik Cayré Hede-Andersen
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

	public String toString() {
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

	public void setStartWeek(int startWeek) throws IllegalOperationException {
		if (endWeek < startWeek && endWeek != 0)
			throw new IllegalOperationException("Endweek cannot be before startweek");

		this.startWeek = startWeek;
	}

	public void setEndWeek(int endWeek) throws IllegalOperationException {
		if (endWeek < startWeek && startWeek != 0)
			throw new IllegalOperationException("Endweek cannot be before startweek");

		this.endWeek = endWeek;
	}

	public void setTimeFrame(int startWeek, int endWeek) throws IllegalOperationException {
		if (endWeek < startWeek)
			throw new IllegalOperationException("Endweek cannot be before startweek");

		this.startWeek = startWeek;
		this.endWeek = endWeek;
	}

	public boolean containsEmployee(Employee employee) {
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

	public float getTimeRegistered(Employee employee) {
		float totalHours = 0;
		for (Entry<Integer, Pair<LocalDate, Float>> entry2 : registeredTime.get(employee.getInitials()).entrySet()) {
			Pair<LocalDate, Float> val2 = entry2.getValue();
			totalHours += val2.getValue();
		}
		return totalHours;
	}

	public float getTimeRegistered(Employee employee, LocalDate date) {
		return registeredTime.get(employee.getInitials()).get(date.hashCode()).getValue();
	}

	public void setDescription(String d) {
		description = d + "";
	}

	public String getDescription() {
		return description;
	}

	public float getExpectedDuration() {
		return expectedDuration;
	}
}

package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;

public class Employee implements Serializable {
	private static final long serialVersionUID = -7608060694345485735L;

	HashMap<String, Activity> personalActivities = new HashMap<String, Activity>();
	HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>> registeredTime = new HashMap<String, HashMap<Integer, Pair<LocalDate, Float>>>();
	HashMap<Integer, Project> isManagerFor = new HashMap<Integer, Project>();
	private String initials;
	private String title;
	private static int maxActivities = 20;

	int workHours;

	public Employee(String initials) {
		this.initials = initials;
	}

	public void addActivity(Activity activity) throws IllegalOperationException {
		if (!Overburdened()) {
			personalActivities.put(activity.getName(), activity);
		} else {
			throw new IllegalOperationException("Employees cannot be assigned more than 20 activities in a given week");
		}
	}

	//Adds time registered for activity, returns total time worked
	public float registerTime(Activity activity, float hours, LocalDate date) {
		float t = 0;
		if (registeredTime.containsKey(activity.getName())) {
			if (registeredTime.get(activity.getName()).containsKey(date.hashCode())) {
				t = registeredTime.get(activity.getName()).get(date.hashCode()).getValue();
			} 
		}else {
			registeredTime.put(activity.getName(), new HashMap<Integer, Pair<LocalDate, Float>>());
		}
		registeredTime.get(activity.getName()).put(date.hashCode(), new Pair<LocalDate, Float>(date, t + hours));
		return t + hours;
	}

	// Checks if the employee is about to be assigned an activity when they're at capacity
	public boolean Overburdened() {
		if (personalActivities.size() < maxActivities)
			return false;

		// Makes a HashMap and adds the weeks where there are activities, then increments the week
		// If any of the weeks have to many activities, the function returns true
		HashMap<Integer, Integer> w = new HashMap<Integer, Integer>();
		for (HashMap.Entry<String, Activity> entry : personalActivities.entrySet()) {
			Activity x = entry.getValue();
			for (int i = x.getStartWeek(); i <= x.getEndWeek(); i++) {
				if (!w.containsKey(i))
					w.put(i, 0);
				if (w.put(i, w.get(i) + 1) + 1 >= maxActivities)
					return true;
			}
		}
		return false;
	}

	public boolean hasActivity(String activityName) {
		return personalActivities.containsKey(activityName); // Uses the built-in function found in HashMap
	}

	// Getters and Setters -----
	public String getInitials() {
		return initials;
	}

	public String toString(){
		return initials;
	}

	public ArrayList<Activity> getActivities() {
		ArrayList<Activity> out = new ArrayList<Activity>();
		for (HashMap.Entry<String, Activity> x : personalActivities.entrySet()) {
			out.add(x.getValue());
		}
		return out;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setManagerFor(Project project) {
		isManagerFor.put(project.getID(), project);
	}

	public static void setMaxActivities(int value) {
		maxActivities = value;
	}

	public static int getMaxActivities() {
		return maxActivities;
	}

	public float getTimeRegisteredToday() {
		LocalDate today = LocalDate.now();
		float totalHours = 0;
		for (HashMap.Entry<String, HashMap<Integer, Pair<LocalDate, Float>>> entry : registeredTime.entrySet()) {
			HashMap<Integer, Pair<LocalDate, Float>> val = entry.getValue();
			totalHours += val.get(today.hashCode()).getValue();
		}
		return totalHours;
	}

}

package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

//Klassen er skrevet af Frederik Cayré Hede-Andersen
public class Project extends Template implements Serializable {
	private static final long serialVersionUID = 6537227987620711347L;

	// HashMap<String, WorkActivity> activities = new HashMap<String, WorkActivity>();
	HashMap<String, Employee> employees = new HashMap<String, Employee>();
	Employee projectManager = null;

	public Project(int ID, String name) {
		super(ID, name);
	}

	public WorkActivity addActivity(WorkActivity activity) throws IllegalOperationException {
		if (HasManager())
			throw new IllegalOperationException("No employee passed while the project has a manager");
		if (!activities.containsKey(activity.getName())) {
			activities.put(activity.getName(), activity);
			activity.setParentProject(this);
		} else {
			throw new IllegalOperationException("An activity with the name " + activity.getName() + " already exists");
		}
		return activity;
	}

	public WorkActivity addActivity(WorkActivity activity, Employee authority) throws IllegalOperationException {
		if (projectManager == null || (authority != null && projectManager.getInitials() == authority.getInitials())) {
			if (!activities.containsKey(activity.getName())) {
				activities.put(activity.getName(), activity);
				activity.setParentProject(this);
			} else {
				throw new IllegalOperationException("An activity with the name " + activity.getName() + " already exists");
			}
		} else {
			throw new IllegalOperationException("Only the project manager can create activities when there exists a project manager");
		}
		return activity;
	}

	public void addEmployee(Employee e) {
		employees.put(e.getInitials(), e);
	}

	public Template ConvertToTemplate(Integer templateID) throws IllegalOperationException {
		Template out = new Template(templateID, "New template");
		out.transferActivities(activities);
		return out;
	}

	// ----

	public boolean HasManager() {
		return projectManager != null;
	}

	public String toString() {
		return ID + " " + name;
	}

	public String getName() {
		return this.name;
	}

	public Integer getID() {
		return this.ID;
	}

	public WorkActivity getActivity(String ID) {
		return activities.get(ID);
	}

	public ArrayList<WorkActivity> getActivities() {
		ArrayList<WorkActivity> out = new ArrayList<WorkActivity>();
		for (HashMap.Entry<String, WorkActivity> x : activities.entrySet()) {
			out.add(x.getValue());
		}
		return out;
	}

	public Employee setManager(Employee employee) {
		projectManager = employee;
		employee.setManagerFor(this);
		return employee;
	}

	public Employee getManager() {
		return projectManager;
	}

	public float getTotalRegisteredTime() {
		float hoursTotal = 0;
		for (HashMap.Entry<String, WorkActivity> x : activities.entrySet()) {
			hoursTotal += x.getValue().getTotalTimeRegistered();
		}
		return hoursTotal;
	}

	public float getTotalRegisteredTime(Employee employee) {
		float hoursTotal = 0;
		for (HashMap.Entry<String, WorkActivity> x : activities.entrySet()) {
			hoursTotal += x.getValue().getTimeRegistered(employee);
		}
		return hoursTotal;
	}

}

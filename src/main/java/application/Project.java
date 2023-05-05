package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Project extends Template implements Serializable {
	private static final long serialVersionUID = 6537227987620711347L;

	//HashMap<String, WorkActivity> activities = new HashMap<String, WorkActivity>();
	HashMap<String, Employee> employees = new HashMap<String, Employee>();
	Employee projectManager = null;

	public Project(int ID, String name) {
		super(ID, name);
	}

	public WorkActivity addActivity(WorkActivity activity) {
		activities.put(activity.getName(), activity);
		return activity;
	}

	public void addEmployee(Employee e) {
		employees.put(e.getInitials(),e);
	}

	public Template ConvertToTemplate(Integer templateID) {
		Template out = new Template(templateID, "New template");
		out.transferActivities(activities);
		return out;
	}
	
	//----

	public String toString(){
		return this.name;
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
}

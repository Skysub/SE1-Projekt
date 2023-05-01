package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Database implements Serializable {
	@java.io.Serial
	private static final long serialVersionUID = 7449338984745986944L;

	HashMap<String, Employee> employees;
	HashMap<Integer, Project> projects; // Vi kan overveje om de skal gemmes som ID eller navn

	public Database() {
		employees = new HashMap<String, Employee>();
		projects = new HashMap<Integer, Project>();
	}

	public Employee CreateEmployee(String initials) throws Exception {
		if (initials.length() > 4)
			throw new Exception("Employee has too many initials");
		if (employees.containsKey(initials)) {
			throw new Exception("An employee with the ID already exists");
		} else {
			employees.put(initials, new Employee(initials));
		}
		return employees.get(initials);
	}

	public void deleteEmployee(Object initials) {
		employees.remove(initials);
	}

	public boolean hasEmployee(Object initials) {
		return employees.containsValue(initials);
	}

	public Project CreateProject(int ID) {
		projects.put(ID, new Project(ID, null));
		return projects.get(ID);
	}

	public Project CreateProject(int ID, String name) throws IllegalOperationException{
		if (projects.get(ID) == null) {
			projects.put(ID, new Project(ID, name));
			return projects.get(ID);
		} else {
			throw new IllegalOperationException("Project already exists");
		}
	}

	public boolean doesTheProjectExist(int ID, String name) {
		boolean doesTheProjectExist = false;

		for (Project project : projects.values()) {
			if (project.getID().equals(ID) && project.getName().equals(name)) {
				doesTheProjectExist = true;
				// System.out.println("Project with number " + ID + "name " + name + " exist");
			}
		}
		return doesTheProjectExist;
	}

	// Getters ---
	public Employee getEmployee(String initials) {
		return employees.get(initials);
	}

	public Project getProject(Integer iD) {
		return projects.get(iD);
	}

	public ArrayList<Employee> getAvailableEmployees(Integer week) {
		ArrayList<Employee> out = new ArrayList<Employee>();

		for (String x : employees.keySet()) {
			out.add(employees.get(x));
			for (Activity y : employees.get(x).getActivities()) {
				if (!((y.endWeek == 0 && y.startWeek == 0) || (y.endWeek < week && y.endWeek != 0)
						|| (y.startWeek > week && y.startWeek != 0))) {
					out.remove(employees.get(x));
					break;
				}
			}
		}

		return out;
	}
}

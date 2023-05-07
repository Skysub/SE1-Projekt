package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Database implements Serializable {
	@java.io.Serial
	private static final long serialVersionUID = 7449338984745986944L;

	HashMap<String, Employee> employees;
	HashMap<Integer, Project> projects; // Vi kan overveje om de skal gemmes som ID eller navn
	HashMap<Integer, Template> templates;

	public Database() {
		employees = new HashMap<String, Employee>();
		projects = new HashMap<Integer, Project>();
		templates = new HashMap<Integer, Template>();
	}

	public Employee CreateEmployee(String initials) throws Exception {
		assert (initials != null);
		Employee result = null;

		if (initials.length() > 4) //1
			throw new Exception("Employee has too many initials");//2
		if (hasEmployee(initials)) { //3
			throw new Exception("An employee with the ID already exists");//4
		} else {
			result = new Employee(initials);
			employees.put(initials, result); // 5
		}
		assert (employees.containsKey(initials) && 
				result.getInitials().equals(initials) &&
				employees.get(initials).equals(result));
		return result; //6
	}

	public boolean hasEmployee(Object initials) {
		return employees.containsValue(initials);
	}

	public void deleteEmployee(Object initials) {
		employees.remove(initials);
	}


	public Project CreateProject(int ID) {
		projects.put(ID, new Project(ID, null));
		return projects.get(ID);
	}

	public Project CreateProject(int ID, String name) throws IllegalOperationException {
		if (projects.get(ID) == null) {
			projects.put(ID, new Project(ID, name));
			return projects.get(ID);
		} else {
			throw new IllegalOperationException("Project already exists");
		}
	}

	public Template MakeTemplate(Project project, int templateID) throws IllegalOperationException {
		Template template = project.ConvertToTemplate(templateID);
		templates.put(templateID, template);
		return template;
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

	public boolean hasTemplate(int ID) {
		return templates.containsKey(ID);
	}

	// Getters ---
	public Employee getEmployee(String initials) {
		return employees.get(initials);
	}

	public Project getProject(Integer iD) {
		return projects.get(iD);
	}

	public Template getTemplate(Integer iD) {
		return templates.get(iD);
	}

	public ArrayList<Employee> getAvailableEmployees(Integer week) {
		ArrayList<Employee> out = new ArrayList<Employee>();

		for (String x : employees.keySet()) {
			out.add(employees.get(x));
			for (Activity y : employees.get(x).getActivities()) {
				if (!((y.endWeek == 0 && y.startWeek == 0) || (y.endWeek < week && y.endWeek != 0) || (y.startWeek > week && y.startWeek != 0))) {
					out.remove(employees.get(x));
					break;
				}
			}
		}

		return out;
	}

}

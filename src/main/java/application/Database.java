package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

//Klassen er skrevet af Frederik Cayré Hede-Andersen på nær de metoder hvor et andet navn står
public class Database implements Serializable {
	@java.io.Serial
	private static final long serialVersionUID = 7449338984745986944L;

	HashMap<String, Employee> employees;
	HashMap<Integer, Project> projects;
	HashMap<Integer, Template> templates;

	public Database() {
		employees = new HashMap<String, Employee>();
		projects = new HashMap<Integer, Project>();
		templates = new HashMap<Integer, Template>();
	}

	//Skrevet af Frederik Hvarregaard 
	public Employee CreateEmployee(String initials) throws IllegalOperationException {
		assert (initials != null);
		Employee result = null;

		if (initials.length() > 4) //1
			throw new IllegalOperationException("Employee has too many initials");//2
		if (hasEmployee(initials)) { //3
			throw new IllegalOperationException("An employee with the ID already exists");//4
		} else {
			result = new Employee(initials);
			employees.put(initials, result); // 5
		}

		assert (result.getInitials().length() <= 4);
		assert (result.getInitials().equals(initials));
		assert (employees.containsValue(result) && employees.containsKey(initials)
				&& employees.get(initials).equals(result));
		return result; //6
	}

	public boolean hasEmployee(String initials) {
		return employees.containsKey(initials);
	}

	public void deleteEmployee(String initials) {
		employees.remove(initials);
	}

	//Skrevet af Frederik Hvarregaard
	public Project CreateProject(int ID) {
		projects.put(ID, new Project(ID, null));
		return projects.get(ID);
	}

	//Skrevet af Naila Aoussar
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
	
	public int CalcNextProjectID() {
		int highest = 0;
		for (Entry<Integer, Project> entry : projects.entrySet()) {
			int ID = entry.getKey();
			if(ID > highest) ID = highest;
		}
		float t = highest/1000f;
		int year = (int) t;
		int nowyear = LocalDate.now().getYear();
		int outID;
		if(year != nowyear) {
			outID = (nowyear * 1000 + 1);
		}
		else {
			outID = highest++;
		}
		return outID;
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
	
	public HashMap<Integer, Project> getProjects(){
		return projects;
	}

}

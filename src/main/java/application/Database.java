package application;

import java.io.Serializable;
import java.util.HashMap;

public class Database implements Serializable {
	@java.io.Serial
	private static final long serialVersionUID = 7449338984745986944L;
	
    HashMap<String, Employee> employees;
    HashMap<Integer, Project> projects;
    
    public Database() {
    	employees = new HashMap<String, Employee>();
    	projects = new  HashMap<Integer, Project>();
    }
    
    public Employee CreateEmployee(String initials) {
    	employees.put(initials, new Employee(initials));
    	return employees.get(initials);
    }
    
    public Project CreateProject(int ID) {
    	projects.put(ID, new Project(ID));
    	return projects.get(ID);
    }

    // Getters ---
    public Employee getEmployee(String initials) {
        return employees.get(initials);
    }
}

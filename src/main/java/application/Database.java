package application;

import java.io.Serializable;
import java.util.HashMap;

public class Database implements Serializable {
	@java.io.Serial
	private static final long serialVersionUID = 7449338984745986944L;
	
    HashMap<String, Employee> employees;
    HashMap<Integer, Project> projects; //Vi kan overveje om de skal gemmes som ID eller navn
    
    public Database() {
    	employees = new HashMap<String, Employee>();
    	projects = new  HashMap<Integer, Project>();
    }
    
    public Employee CreateEmployee(String initials) throws Exception {
        if(employees.containsKey(initials)){
            throw new Exception("An employee with the ID already exists");
        }
        else{
            employees.put(initials, new Employee(initials));
        }
    	return employees.get(initials);
    }
    
    public Project CreateProject(int ID) {
    	projects.put(ID, new Project(ID, null));
    	return projects.get(ID);
    }

    public Project CreateProject(int ID, String name) {
    	projects.put(ID, new Project(ID, name));
    	return projects.get(ID);
    }

    // Getters ---
    public Employee getEmployee(String initials) {
        return employees.get(initials);
    }

    public Project getProject(Integer iD) {
        return projects.get(iD);
    }
}

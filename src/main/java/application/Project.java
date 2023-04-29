package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable{
	private static final long serialVersionUID = 6537227987620711347L;
	
	ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    Employee projectManager = null;
    int ID;
    String name;

    public Project(int ID, String name) {
    	this.ID = ID;
        this.name = name;
    }
    
    public void addActivity(Activity activity){
        this.activities.add(activity);
    }

    public void addEmployee(Employee e){
        this.employees.add(e);
    }

    public Object getName() {
        return this.name;
    }

    public Integer getID() {
        return this.ID;
    }
}

package application;

import java.util.ArrayList;

public class Project {
    ArrayList<Activity> activities = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    Employee projectManager = null;
    int ID;

    public Project(int ID) {
    	this.ID = ID;
    }
    
    public void addActivity(Activity activity){
        this.activities.add(activity);
    }

    public void addEmployee(Employee e){
        this.employees.add(e);
    }
}

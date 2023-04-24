package application;

import java.util.ArrayList;

public class WorkActivity extends Activity{
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    //Constructors ---------------------------------------------------------
    public WorkActivity(String name) {
        super(name);
    }

    public WorkActivity(String name, int startWeek){
        super(name,startWeek);
    }

    public WorkActivity(String name, Integer startWeek, Integer endWeek) {
        super(name, startWeek,  endWeek);
    }
    // ----------------------------------------------------------------------

    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.addActivity(this);
    }


    //Getters and setters ---------
    public Object getStartWeek() {
        return this.startWeek;
    }

    public Object getEndWeek() {
        return this.endWeek;
    }

    public boolean containsEmployee(String initials) {
        for(Employee employee : employees){
            if (employee.getInitials().equals(initials)){
                return true;
            } 
        }
        return false;
    }
    
}

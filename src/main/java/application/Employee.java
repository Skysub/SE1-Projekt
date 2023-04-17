package application;

import java.util.ArrayList;

public class Employee {
	ArrayList<Activity> personalActivities = new ArrayList<>();
    String initials;

    public Employee(String initials){
        this.initials = initials;
    }

    public void addActivity(Activity activity){
        this.personalActivities.add(activity);
    }

    public void registerTime(Activity activity, int Time){

    }
}

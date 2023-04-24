package application;

import java.util.ArrayList;

public class Employee {
	ArrayList<Activity> personalActivities = new ArrayList<>();
    private static String initials;
    int workHours;

    public Employee(String initials){
        this.initials = initials;
    }

    public void addActivity(Activity activity){
        this.personalActivities.add(activity);
    }

    public void registerTime(Activity activity, int Time){

    }

    public static Object getInitials() {
        return initials;
    }

}

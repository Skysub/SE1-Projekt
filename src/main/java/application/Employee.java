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

    public void registerTime(Activity activity, int Time){ //TODO

    }

    //Getters and Setters -----
    public Object getInitials() {
        return initials;
    }


    public boolean hasActivity(String activityName) {
        for(Activity activity : personalActivities){
            if (activity.getName().equals(activityName)){
                return true;
            }
        }
        return false;
    }

}

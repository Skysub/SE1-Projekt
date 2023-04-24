package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
	private static final long serialVersionUID = -7608060694345485735L;
	
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

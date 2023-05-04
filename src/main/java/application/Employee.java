package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Employee implements Serializable {
	private static final long serialVersionUID = -7608060694345485735L;
	
	HashMap<String, Activity> personalActivities = new HashMap<String, Activity>();
	HashMap<Integer, Project> isManagerFor = new HashMap<Integer, Project>();
    private String initials;
    private String title;
    private static int maxActivities = 20;

    int workHours;

    public Employee(String initials){
        this.initials = initials;
    }


    public void addActivity(Activity activity){
        personalActivities.put(activity.getName(), activity);
    }

    public void registerTime(Activity activity, int Time){

    }

    //Getters and Setters -----
    public String getInitials() {
        return initials;
    }

    public boolean hasActivity(String activityName) {
        return personalActivities.containsKey(activityName);
    }

    public ArrayList<Activity> getActivities() {
		ArrayList<Activity> out = new ArrayList<Activity>();
        for (HashMap.Entry<String, Activity> x : personalActivities.entrySet()) {
			out.add(x.getValue());
		}
        return out;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

    public String getTitle(){
        return title;
    }

	public void setManagerFor(Project project) {
		isManagerFor.put(project.getID() ,project);
	}
	
	public static void setMaxActivities(int value) {
		maxActivities = value;
	}
	
	public static int getMaxActivities() {
		return maxActivities;
	}

}

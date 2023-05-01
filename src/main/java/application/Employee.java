package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
	private static final long serialVersionUID = -7608060694345485735L;
	
	ArrayList<Activity> personalActivities = new ArrayList<>();
	ArrayList<Project> isManagerFor = new ArrayList<>();
    private String initials;
    private String title;

    int workHours;

    public Employee(String initials){
        this.initials = initials;
    }


    public void addActivity(Activity activity){
        this.personalActivities.add(activity);
    }

    public void registerTime(Activity activity, int Time){

    }

    //Getters and Setters -----
    public Object getInitials() {
        return initials;
    }

    public boolean hasActivity(String activityName) {
        //System.out.println(personalActivities.get(0).getName());
        for(Activity activity : personalActivities){
            if (activity.getName().equals(activityName)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Activity> getActivities() {
        return personalActivities;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }

    public String getTitle(){
        return title;
    }

	public void setManagerFor(Project project) {
		isManagerFor.add(project);
	}


}

package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Template implements Serializable {
	private static final long serialVersionUID = 6537222563620711347L;

	HashMap<String, WorkActivity> activities = new HashMap<String, WorkActivity>();
	int ID;
	String name;

	public Template(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public WorkActivity addActivity(WorkActivity activity) {
		activities.put(activity.getName(), activity);
		return activity;
	}

	public String getName() {
		return this.name;
	}

	public Integer getID() {
		return this.ID;
	}
	
	public WorkActivity getActivity(String ID) {
		return activities.get(ID);
    }

	public ArrayList<WorkActivity> getActivities() {
		ArrayList<WorkActivity> out = new ArrayList<WorkActivity>();
        for (HashMap.Entry<String, WorkActivity> x : activities.entrySet()) {
			out.add(x.getValue());
		}
        return out;
    }
}

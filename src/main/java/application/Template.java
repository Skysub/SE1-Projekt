package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

//Klassen er skrevet af Frederik Cayré Hede-Andersen på nær de metoder hvor et andet navn står
public class Template implements Serializable {
	private static final long serialVersionUID = 6537222563620711347L;

	HashMap<String, WorkActivity> activities = new HashMap<String, WorkActivity>();
	int ID;
	String name;
	String description;

	public Template(int ID) {
		this.ID = ID;
	}

	public Template(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	//Metoden er skrevet af Frederik Hvarregaard
	public WorkActivity addActivity(WorkActivity activity) throws IllegalOperationException {
		activities.put(activity.getName(), activity);
		activity.setParentTemplate(this);
		return activity;
	}
	
	//------
	
	protected void transferActivities(HashMap<String, WorkActivity> a) throws IllegalOperationException {
		for (HashMap.Entry<String, WorkActivity> entry : a.entrySet()) {
			WorkActivity x = entry.getValue();
			addActivity(new WorkActivity(x.getName()));
		}
	}
	
	public Project ConvertToProject() throws IllegalOperationException {
		Project out = new Project(ID, name);
		out.transferActivities(activities);
		return out;
	}
	
	//Metoden er skrevet af Naila Aoussar
	public boolean hasActivity(String name) {
		return activities.containsKey(name);
	}
	
	//----

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public void setDescription(String d) {
		description = d + "";
	}
	
	public String getDescription() {
		return description;
	}
}

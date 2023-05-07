package application;

import java.io.Serializable;

public class PersonalActivity extends Activity implements Serializable {
	private static final long serialVersionUID = 83121472403813271L;
	PAType type = PAType.OTHER;
		
	public PersonalActivity(String name, Employee employee) {
		super(name);
		employees.put(employee.getInitials(), employee);
	}
	
	public PersonalActivity(String name, PAType type, Employee employee) {
		super(name);
		this.type = type;
		employees.put(employee.getInitials(), employee);
	}
	
	public PersonalActivity(String name, int startWeek, int endWeek , PAType type, Employee employee) {
		super(name, startWeek, endWeek);
		this.type = type;
		employees.put(employee.getInitials(), employee);
	}

	// -------

	public void setType(PAType type){
		this.type = type;
	}
	
	public PAType getType(){
		return type;
	}
	
	public void setExpectedDuration(float exp) {
		expectedDuration = exp;
	}
}

package application;

//Klassen er skrevet af Frederik Hvarregaard på nær de metoder hvor et andet navn står

public class WorkActivity extends Activity {
	private static final long serialVersionUID = 6207085657016298521L;

	Project parentProject;
	Template parentTemplate;
	// Constructors ---------------------------------------------------------
	public WorkActivity(String name) {
		super(name);
	}

	public WorkActivity(String name, int startWeek) {
		super(name, startWeek);
	}

	public WorkActivity(String name, int startWeek, int endWeek) throws IllegalOperationException {
		super(name, startWeek, endWeek);
	}
	// ---------------------------------------------------------------------
	
	//-----
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	public void addEmployee(Employee employee, Employee authority) throws IllegalOperationException {
		if (parentProject.getManager() == null || (authority != null && parentProject.getManager().getInitials() == authority.getInitials())) {
			if (!employees.containsKey(employee.getInitials())) {
				employee.addActivity(this);
				employees.put(employee.getInitials(), employee);
			} else {
				throw new IllegalOperationException(
						"The employee with ID " + employee.getInitials() + " is already assigned to this activity");
			}
		} else {
			throw new IllegalOperationException("Only the project manager can assign employees when a project manager exists");
		}
	}
	
	//--------------------
	
	public void setParentProject(Project project) {
		parentProject = project;
	}
	
	public void setParentTemplate(Template template) {
		parentTemplate = template;
	}

	//Metoden er skrevet af Abdul Haseeb Farooq
	public void setExpectedDuration(float hours, Employee authority) throws IllegalOperationException {
		if(hours<0) {
			throw new IllegalOperationException("You can not register the expected duration as a negative value");
		}
		
		if(authority == parentProject.getManager() || !parentProject.HasManager() ) {
			 expectedDuration = hours;
		}
		else {
			throw new IllegalOperationException("Only the project manager can register expected duration");
		}
		
	}



}

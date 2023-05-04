package application;

import java.util.ArrayList;
import java.util.Map;

public class WorkActivity extends Activity {

	Project parentProject;

	// Constructors ---------------------------------------------------------
	public WorkActivity(String name, Project project) {
		super(name);
		parentProject = project;
		project.addActivity(this);
	}

	public WorkActivity(String name, int startWeek, Project project) {
		super(name, startWeek);
		parentProject = project;
		project.addActivity(this);
	}

	public WorkActivity(String name, Integer startWeek, Integer endWeek, Project project) {
		super(name, startWeek, endWeek);
		parentProject = project;
		project.addActivity(this);
	}
	// ---------------------------------------------------------------------

	public void addEmployee(Employee employee, Employee authority) throws IllegalOperationException {
		if (parentProject.getManager() == null || parentProject.getManager().getInitials() == authority.getInitials()) {
			if (!employees.containsKey(employee.getInitials())) {
				employee.addActivity(this);
				employees.put(employee.getInitials(), employee);
			} else {
				throw new IllegalOperationException(
						"The employee with ID " + employee.getInitials() + " is already assigned to this activity");
			}
		} else {
			throw new IllegalOperationException("Only the project manager can assign employees");
		}
	}
}

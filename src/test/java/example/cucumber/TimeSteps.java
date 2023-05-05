package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import application.Database;
import application.Employee;
import application.IllegalOperationException;
import application.Project;
import application.WorkActivity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimeSteps {

	Database database;
	ErrorMessageHolder errorMessageHolder;
	WorkActivity recentWorkedOnActivity;
	Employee recentEmployee;

	public TimeSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("the employee with the ID {string} registers {int} hours worked on the activity with the name {string} in the project with ID {int}")
	public void theEmployeeWithTheIDRegistersHoursWorkedOnTheActivityWithTheNameInTheProjectWithID(String initials, Integer hours, String name,
			Integer projectID) {
		recentWorkedOnActivity = database.getProject(projectID).getActivity(name);
		recentEmployee = database.getEmployee(initials);
		try {
			recentWorkedOnActivity.RegisterTime(recentEmployee, (float) hours, LocalDate.now());
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the time the employee has worked on the activity is {int} hours")
	public void theTimeTheEmployeeHasWorkedOnTheActivityIsHours(Integer hours) {
		assertEquals((float) hours, recentWorkedOnActivity.getTimeRegistered(recentEmployee), 0.0166f);
	}

	@Then("the activity has {int} hours of work registered for the employee with the ID {string}")
	public void theActivityHasHoursOfWorkRegisteredForTheEmployeeWithTheID(Integer hours, String initials) {
		assertEquals((float) hours, recentWorkedOnActivity.getTimeRegistered(database.getEmployee(initials)), 0.0166f);
		// Checks if the amount worked is accurate to within one minute
	}

	@Then("the employee with the ID {string} has {int} hours of work registered that day")
	public void theEmployeeWithTheIDHasHoursOfWorkRegisteredThatDay(String initials, Integer hours) {
		assertEquals((float) hours, database.getEmployee(initials).getTimeRegisteredToday(), 0.0166f);
		// Checks if the amount worked is accurate to within one minute
	}
	
	@Then("the time the project with ID {int} has been worked on is {int} hours")
	public void theTimeTheProjectWithIDHasBeenWorkedOnIsHours(Integer ID, Integer hours) {
		assertEquals((float) hours, database.getProject(ID).getTotalRegisteredTime(), 0.0166f);
	}
	
	@Then("the employee with the ID {string} has {int} hours of work registered on the project with ID {int}")
	public void theEmployeeWithTheIDHasHoursOfWorkRegisteredOnTheProjectWithID(String initials, Integer hours, Integer ID) {
		assertEquals((float) hours, database.getProject(ID).getTotalRegisteredTime(database.getEmployee(initials)), 0.0166f);
	}
}

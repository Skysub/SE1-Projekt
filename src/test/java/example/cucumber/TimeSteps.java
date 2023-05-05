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

	public TimeSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("the employee with the ID {string} registers {int} hours worked on the activity with the name {string} in the project with ID {int}")
	public void theEmployeeWithTheIDRegistersHoursWorkedOnTheActivityWithTheNameInTheProjectWithID(String initials,
			Integer hours, String name, Integer projectID) {
		recentWorkedOnActivity = database.getProject(projectID).getActivity(name);
		try {
			recentWorkedOnActivity.RegisterTime(database.getEmployee(initials), (float) hours, LocalDate.now());
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has {int} hours of work registered for the employee with the ID {string}")
	public void theActivityHasHoursOfWorkRegisteredForTheEmployeeWithTheID(Integer hours, String initials) {
		assertEquals((float) hours, recentWorkedOnActivity.getTimeRegistered(initials), 0.0166f);
		//Checks if the amount worked is accurate to within one minute
	}

	@Then("the employee with the ID {string} has {int} hours of work registered that day")
	public void theEmployeeWithTheIDHasHoursOfWorkRegisteredThatDay(String initials, Integer hours) {
		assertEquals((float) hours, database.getEmployee(initials).getTimeRegisteredToday(), 0.0166f);
		//Checks if the amount worked is accurate to within one minute
	}
}

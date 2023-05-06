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

public class ExpectedDurationSteps {

	Database database;
	ErrorMessageHolder errorMessageHolder;
	Employee recentManager;
	WorkActivity recentWorkActivity;
	Project recentProject;

	public ExpectedDurationSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("the project manager registers {int} hours expected duration on the activity with the name {string} in the project with ID {int}")
	public void projectManagerRegistersExpectedDurationOnTheActivityWithTheNameInTheProjectWithID(String initials, Integer hours, String name,
			Integer projectID, String managerID) {
		recentWorkActivity = new WorkActivity(name, database.CreateProject(23001));
		recentManager = database.getProject(projectID).setManager(database.getEmployee(managerID));
		try {
			recentWorkActivity.RegisterTime(recentManager, (float) hours, LocalDate.now());
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has {int} hours of expected duration registered ")
	public void theActivityHasHoursOfExpectedDuration(Integer hours, String managerID) {
		assertEquals((float) hours, recentWorkActivity.getTimeRegistered(database.getEmployee(managerID)), 0.0166f);
	}

}

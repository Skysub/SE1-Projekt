package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import application.Database;
import application.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	public Employee recentEmployee;

	public EmployeeSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("a new employee profile with the ID {string} is made")
	public void aNewEmployeeProfileWithTheIDIsMade(String initials) {
		try {
			recentEmployee = database.CreateEmployee(initials);
		} catch (Exception e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("The employee has the initials {string}")
	public void theEmployeeHasTheInitials(String expectedInitials) {
		assertEquals(expectedInitials, recentEmployee.getInitials());
	}

	@Given("an employee with the ID {string} exists")
	public void anEmployeeWithTheIDExists(String initials) throws Exception {
		recentEmployee = database.CreateEmployee(initials);
	}

	@Then("the employee with the ID {string} has the activity with name {string}")
	public void theEmployeeHasTheActivityWithName(String initials, String activityName) {
		assertTrue(database.getEmployee(initials).hasActivity(activityName));
	}

	@Then("the error message {string} is given")
	public void theErrorMessageIsGiven(String error) {
		assertEquals(error, errorMessageHolder.getErrorMessage());
	}

	@When("the employee sets the title of the employee to {string}")
	public void theEmployeeSetsTheTitleOfTheEmployeeTo(String title) {
		recentEmployee.setTitle(title);
	}

	@Then("the title of the employee is {string}")
	public void theTitleOfTheEmployeeIs(String expectedTitle) {
		assertEquals(expectedTitle, recentEmployee.getTitle());
	}

	@Given("the employee has the title {string}")
	public void theEmployeeHasTheTitle(String title) {
		recentEmployee.setTitle(title);
	}

	@When("the employee deletes the employee profile")
	public void theEmployeeDeletesTheEmployeeProfile() {
		database.deleteEmployee(recentEmployee.getInitials());
	}

	@Then("an employee with the ID {string} does not exist")
	public void anEmployeeWithTheIDDoesNotExist(String initials) {
		assertFalse(database.hasEmployee(initials));
	}
}

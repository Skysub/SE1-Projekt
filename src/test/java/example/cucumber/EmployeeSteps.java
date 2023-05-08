package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import application.Database;
import application.Employee;
import application.IllegalOperationException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	Employee recentEmployee;
	ArrayList<Employee> empList;

	public EmployeeSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("a new employee profile with the ID {string} is made")
	public void aNewEmployeeProfileWithTheIDIsMade(String initials) {
		try {
			recentEmployee = database.CreateEmployee(initials);
		} catch (IllegalOperationException e) {
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

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
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
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@When("the employee searches for available employees around week {int}")
	public void theEmployeeSearchesForAvailableEmployeesAroundWeek(Integer week) {
	    empList = database.getAvailableEmployees(week);
	}

	@Then("an employee with the ID {string} does not exist")
	public void anEmployeeWithTheIDDoesNotExist(String initials) {
		assertFalse(database.hasEmployee(initials));
	}
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Then("the employee gets a list of employees with the IDs {string} and {string} and {string}")
	public void theEmployeeGetsAListOfEmployeesWithTheIDsAndAnd(String ID1, String ID2, String ID3) {
	    assertTrue(empList.contains(database.getEmployee(ID1)));
	    assertTrue(empList.contains(database.getEmployee(ID2)));
	    assertTrue(empList.contains(database.getEmployee(ID3)));
	}
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Then("the employee gets an empty employee list")
	public void theEmployeeGetsAnEmptyEmployeeList() {
		assertTrue(empList.isEmpty());
	}
	
	
}

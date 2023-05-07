package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import application.Database;
import application.Employee;
import application.IllegalOperationException;
import application.PersonalActivity;
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
	PersonalActivity recentPersonalActivity;
	Project recentProject;
	


	public ExpectedDurationSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}
	
//	@Given("a project with project number {int} and project name {string} exists")
//	public void aProjectWithProjectNumberAndProjectNameExists(int ID, String name) {
//		recentProject = database.CreateProject(ID, name);
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("an employee sets the expected duration {float} of the personal activity")
	public void anEmployeeSetsTheExpectedDurationOfPersonalActivity(float ExpectedDurationPA) {
		recentPersonalActivity.setExpectedDurationPA(ExpectedDurationPA);
	}
	
	@Then("the personal activity has the expected duration {int}")
	public void thePersonalActivityHasTheExpectedDuration(int expectedDurationPA) {
		assertEquals(expectedDurationPA, recentPersonalActivity.getExpectedDuration(), 0.0166f);
	}
	
	@When("a project manager sets the expected duration {float} of the work activity")
	public void anEmployeeSetsTheExpectedDurationOfActivity(float expectedDuration) {
		recentWorkActivity.setExpectedDurationWA(expectedDuration);
	}
	
	@Then("the work activity has the expected duration {int}")
	public void theWorkActivityHasTheExpectedDuration(int expectedDuration) {
		assertEquals(expectedDuration, recentWorkActivity.getExpectedDuration(), 0.0166f);
	}
	
	@When("the employee with the ID {string} registers {int} hours as the expected duration in the workActivity with the name {string} in the project with ID {int}")
	public void theEmployeeWithTheIDRegistersHoursAsTheExpectedDurationInTheWorkActivityWithTheNameInTheProjectWithID(String initials, Integer hours, String name, Integer ID) {
		recentWorkActivity = database.getProject(ID).getActivity(name);
		recentWorkActivity.setExpectedDuration((float)hours,database.getEmployee(initials));
	}
	
	@Then("the activity has {int} hours as the expected duration")
	public void theActivityHasHoursAsTheExpectedDuration(Integer hours) {
		assertEquals((float)hours,recentWorkActivity.getExpectedDuration(),0.0166f);
	}

}

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

	@When("an employee sets the expected duration {float} of the personal activity")
	public void anEmployeeSetsTheExpectedDurationOfPersonalActivity(float ExpectedDurationPA) {
		recentPersonalActivity.setExpectedDurationPA(ExpectedDurationPA);
	}
	
	@Then("the personal activity has the expected duration {int}")
	public void theActivityHasTheExpectedDuration(float expectedDurationPA) {
		assertEquals(expectedDurationPA, recentPersonalActivity.getExpectedDuration(), 0.0166f);
	}
	
	@When("a project manager sets the expected duration {float} of the work activity")
	public void anEmployeeSetsTheExpectedDurationOfActivity(int expectedDuration) {
		recentWorkActivity.setExpectedDurationWA(expectedDuration);
	}
	
	@Then("the activity has the expected duration {int}")
	public void theActivityHasTheExpectedDuration(int expectedDuration) {
		assertEquals(expectedDuration, recentWorkActivity.getExpectedDuration(), 0.0166f);
	}
}

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
		
	//Metoden er skrevet af Abdul Haseeb Farooq
	@When("the employee with the ID {string} registers {int} hours as the expected duration in the workActivity with the name {string} in the project with ID {int}")
	public void theEmployeeWithTheIDRegistersHoursAsTheExpectedDurationInTheWorkActivityWithTheNameInTheProjectWithID(String initials, Integer hours, String name, Integer ID) {
		recentWorkActivity = database.getProject(ID).getActivity(name);
		try {
			recentWorkActivity.setExpectedDuration((float)hours,database.getEmployee(initials));
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	//Metoden er skrevet af Abdul Haseeb Farooq
	@Then("the activity has {int} hours as the expected duration")
	public void theActivityHasHoursAsTheExpectedDuration(Integer hours) {
		assertEquals((float)hours,recentWorkActivity.getExpectedDuration(),0.0166f);
	}

}

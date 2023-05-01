package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Activity;
import application.Database;
import application.IllegalOperationException;
import application.WorkActivity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	WorkActivity recentActivity;
	WorkActivity recentWorkActivity;

	public ActivitySteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("a new workActivity with the name {string} is made")
	public void aNewWorkActivityWithTheNameIsMade(String name) {
		recentWorkActivity = new WorkActivity(name, database.CreateProject(23001));
		recentActivity = recentWorkActivity;
	}

	@Then("the activity has the name {string}")
	public void theActivityHasTheName(String name) {
		assertEquals(name, recentActivity.getName());
	}

	@When("a new workActivity with the name {string} and start week {int} is made")
	public void aNewWorkActivityWithTheNameAndStartWeekIsMade(String name, int startWeek) {
		recentActivity = new WorkActivity(name, startWeek, database.CreateProject(23001));
	}

	@Then("the activity has the start week {int}")
	public void theWorkActivityHasTheStartWeek(int startWeek) {
		assertEquals(startWeek, recentActivity.getStartWeek());
	}

	@When("a new workActivity with the name {string}, start week {int} is made and end week {int}")
	public void aNewWorkActivityWithTheNameStartWeekIsMadeAndEndWeek(String name, Integer startWeek, Integer endWeek) {
		recentActivity = new WorkActivity(name, startWeek, endWeek, database.CreateProject(23001));
	}

	@Then("the activity has the end week {int}")
	public void theActivityHasTheEndWeek(Integer endWeek) {
		assertEquals(endWeek, recentActivity.getEndWeek());
	}

	@Given("an activity with the name {string} exists")
	public void anActivityWithTheNameExists(String name) {
		recentActivity = new WorkActivity(name, database.CreateProject(23001));
	}
	
	@Given("the activity has a start week of {int} and an end week of {int}")
	public void theActivityHasAStartWeekOfAndAnEndWeekOf(Integer start, Integer end) {
		recentActivity.setStartWeek(start);
		recentActivity.setEndWeek(end);
	}

	@When("the employee with the ID {string} is added to the activity")
	public void theEmployeeIsAddedToTheActivity(String initials) throws IllegalOperationException {
		recentActivity.addEmployee(database.getEmployee(initials), null);
	}

	@Then("the activity has the employee with initials {string}")
	public void theActivityHasTheEmployeeWithInitials(String initials) {
		assertTrue(recentActivity.containsEmployee(initials));
	}

	@When("the employee sets the start week to {int}")
	public void theEmployeeSetsTheStartWeekTo(Integer startWeek) {
	    recentActivity.setStartWeek(startWeek);
	}
	@When("the employee sets the end week to {int}")
	public void theEmployeeSetsTheEndWeekTo(Integer endWeek) {
		recentActivity.setEndWeek(endWeek);
	}
}

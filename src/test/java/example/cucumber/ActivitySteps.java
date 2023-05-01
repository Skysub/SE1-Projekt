package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Activity;
import application.Database;
import application.WorkActivity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	Activity recentActivity;
	WorkActivity recentWorkActivity;

	public ActivitySteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@When("a new workActivity with the name {string} is made")
	public void aNewWorkActivityWithTheNameIsMade(String name) {
		recentWorkActivity = new WorkActivity(name);
		recentActivity = recentWorkActivity;
	}

	@Then("the activity has the name {string}")
	public void theActivityHasTheName(String name) {
		assertEquals(name, recentActivity.getName());
	}

	@When("a new workActivity with the name {string} and start week {int} is made")
	public void aNewWorkActivityWithTheNameAndStartWeekIsMade(String name, int startWeek) {
		recentActivity = new WorkActivity(name, startWeek);
	}

	@Then("the activity has the start week {int}")
	public void theWorkActivityHasTheStartWeek(int startWeek) {
		assertEquals(startWeek, recentActivity.getStartWeek());
	}

	@When("a new workActivity with the name {string}, start week {int} is made and end week {int}")
	public void aNewWorkActivityWithTheNameStartWeekIsMadeAndEndWeek(String name, Integer startWeek, Integer endWeek) {
		recentActivity = new WorkActivity(name, startWeek, endWeek);
	}

	@Then("the activity has the end week {int}")
	public void theActivityHasTheEndWeek(Integer endWeek) {
		assertEquals(endWeek, recentActivity.getEndWeek());
	}

	@Given("an activity with the name {string} exists")
	public void anActivityWithTheNameExists(String name) {
		recentActivity = new WorkActivity(name);
	}

	@When("the employee with the ID {string} is added to the activity")
	public void theEmployeeIsAddedToTheActivity(String initials) {
		recentActivity.addEmployee(database.getEmployee(initials));
	}

	@Then("the activity has the employee with initials {string}")
	public void theActivityHasTheEmployeeWithInitials(String initials) {
		assertTrue(recentActivity.containsEmployee(initials));
	}

}

package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Database;
import application.Employee;
import application.IllegalOperationException;
import application.Project;
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

	@Given("an activity with the name {string} exists")
	public void anActivityWithTheNameExists(String name) {
		recentActivity = new WorkActivity(name, database.CreateProject(23001));
	}

	@Given("the activity has a start week of {int} and an end week of {int}")
	public void theActivityHasAStartWeekOfAndAnEndWeekOf(Integer start, Integer end) {
		recentActivity.setStartWeek(start);
		recentActivity.setEndWeek(end);
	}

	@Given("{int} activities with start week {int} and end week {int} in the project with the ID {int} exist")
	public void activitiesNamedThroughWithStartWeekAndEndWeekExist(Integer n, Integer sW, Integer eW, Integer pN) {
		Project p = database.CreateProject(pN);
		for (int i = 0; i < n; i++) {
			new WorkActivity(i + "", sW, eW, p);
		}
	}

	@Given("employees can be assigned a maximum of {int} activities per week")
	public void employeesCanBeAssignedAMaximumOfActivitiesPerWeek(Integer maxActivities) {
		Employee.setMaxActivities(maxActivities);
	}

	@Given("the employee is assigned the {int} activities")
	public void theEmployeeIsAssignedAllActivitiesNamedThrough(Integer amount) throws Exception {
		for (int i = 0; i < amount; i++) {
			database.getProject(23001).getActivity(i + "").addEmployee(database.getEmployee("JJCB"), null);
		}
	}

	@When("a new workActivity with the name {string} is made")
	public void aNewWorkActivityWithTheNameIsMade(String name) {
		recentWorkActivity = new WorkActivity(name, database.CreateProject(23001));
		recentActivity = recentWorkActivity;
	}

	@When("a new workActivity with the name {string} and start week {int} is made")
	public void aNewWorkActivityWithTheNameAndStartWeekIsMade(String name, int startWeek) {
		recentActivity = new WorkActivity(name, startWeek, database.CreateProject(23001));
	}

	@When("a new workActivity with the name {string}, start week {int} is made and end week {int}")
	public void aNewWorkActivityWithTheNameStartWeekIsMadeAndEndWeek(String name, Integer startWeek, Integer endWeek) {
		recentActivity = new WorkActivity(name, startWeek, endWeek, database.CreateProject(23001));
	}

	@When("the employee with the ID {string} is added to the activity")
	public void theEmployeeIsAddedToTheActivity(String initials) throws IllegalOperationException {
		recentActivity.addEmployee(database.getEmployee(initials), null);
	}

	@When("the employee sets the start week to {int}")
	public void theEmployeeSetsTheStartWeekTo(Integer startWeek) {
		recentActivity.setStartWeek(startWeek);
	}

	@When("the employee sets the end week to {int}")
	public void theEmployeeSetsTheEndWeekTo(Integer endWeek) {
		recentActivity.setEndWeek(endWeek);
	}

	@When("the employee sets the hours spent to {int}")
	public void theEmployeeSetsTheHoursTo(Integer Hours) {
		recentActivity.setHours(Hours);
	}

	@When("an employee with the ID {string} is assigned the activity named {string} in the project with ID {int}")
	public void anEmployeeWithTheIDIsAssignedTheActivityNamed(String ID, String name, Integer project) {
		try {
			database.getProject(project).getActivity(name).addEmployee(database.getEmployee(ID), null);
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the activity has the name {string}")
	public void theActivityHasTheName(String name) {
		assertEquals(name, recentActivity.getName());
	}

	@Then("the activity has the start week {int}")
	public void theWorkActivityHasTheStartWeek(int startWeek) {
		assertEquals(startWeek, recentActivity.getStartWeek());
	}

	@Then("the activity has the end week {int}")
	public void theActivityHasTheEndWeek(Integer endWeek) {
		assertEquals(endWeek, (Integer) recentActivity.getEndWeek());
	}

	@Then("the activity has the hours spent{int}")
	public void theEmployeeSetsTheHours(Integer Hours) {
		assertEquals(Hours, (Integer) recentActivity.getEndWeek());
	}

	@Then("the activity has the employee with initials {string}")
	public void theActivityHasTheEmployeeWithInitials(String initials) {
		assertTrue(recentActivity.containsEmployee(database.getEmployee(initials)));
	}

	@Then("the employee with initials {string} is assigned to all the {int} activities of the project with ID {int}")
	public void theEmployeeIsAssignedToAllTheActivities(String initials, Integer n, Integer ID) {
		for (int i = 0; i < n; i++) {
			assertTrue(database.getProject(ID).getActivity(i + "").containsEmployee(database.getEmployee(initials)));
		}
	}

}

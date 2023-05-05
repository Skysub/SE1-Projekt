package example.cucumber;

import static org.junit.Assert.assertTrue;

import application.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalActivitySteps {

	Database database;
	ErrorMessageHolder errorMessageHolder;
	Employee recentEmployee;
	PersonalActivity recentPA;

	public PersonalActivitySteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@Given("a the employee with the ID {string} has a personal activity with the name {string}")
	public void aTheEmployeeWithTheIDHasAPersonalActivityWithTheName(String initials, String name) throws Exception {
		recentEmployee = database.getEmployee(initials);
		PersonalActivity t = new PersonalActivity(name, recentEmployee);
		recentEmployee.addActivity(t);
		recentPA = t;
	}

	@Given("the personal activity has a start week of {int} and an end week of {int}")
	public void thePersonalActivityHasAStartWeekOfAndAnEndWeekOf(Integer startWeek, Integer endWeek) {
		recentPA.setStartWeek(startWeek);
		recentPA.setEndWeek(endWeek);
	}

	@When("the employee marks the personal activity as a vacation")
	public void theEmployeeWithTheIDMarksThePersonalActivityAsAVacation() {
		recentPA.setType(PAType.VACATION);
	}

	@Then("the employee with the ID {string} has a registered vacation from week {int} until week {int}")
	public void theEmployeeWithTheIDHasARegisteredVacationFromWeekUntilWeek(String initials, Integer sw, Integer ew) {
		assertTrue(database.getEmployee(initials).hasVacation(sw, ew));
	}
}

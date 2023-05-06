package example.cucumber;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.TreeSet;

import application.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.Pair;

public class PersonalActivitySteps {

	Database database;
	ErrorMessageHolder errorMessageHolder;
	Employee recentEmployee;
	PersonalActivity recentPA;
	Pair<Float, TreeSet<Integer>> sicknessReport;

	public PersonalActivitySteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	@Given("the employee with the ID {string} has a personal activity with the name {string}")
	public void TheEmployeeWithTheIDHasAPersonalActivityWithTheName(String initials, String name) throws Exception {
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
	
	@Given("the employee registers {int} sick workhours during week {int}")
	public void theEmployeeRegistersSickWorkhoursDuringWeek(Integer sickshours, Integer week) throws IllegalOperationException {
	    recentEmployee.RegisterSickHours((float) sickshours, week, LocalDate.now());
	}

	@When("the employee marks the personal activity as a vacation")
	public void theEmployeeWithTheIDMarksThePersonalActivityAsAVacation() {
		recentPA.setType(PAType.VACATION);
	}

	@When("the employee with ID {string} registers as sick during week {int}")
	public void theEmployeeRegistersAsSickDuringWeek(String initials, Integer week) throws IllegalOperationException {
		recentEmployee = database.getEmployee(initials);
		recentPA = recentEmployee.RegisterSick(week);
	}
	
	@When("the employee gets a sickness report between week {int} and week {int}")
	public void theEmployeeAsksToSeeSicknessBetweenWeekAndWeek(Integer sw, Integer ew) {
	    sicknessReport = recentEmployee.getSicknessReport(sw, ew);
	}

	@Then("the report states the employee has been sick in week {int}")
	public void theEmployeeHasBeenSickInWeek(Integer week) {
		assertTrue(sicknessReport.getValue().contains(week));
	}

	@Then("the report states the employee has has {int} sick hours in the period")
	public void theEmployeeHasHasSickHoursInThePeriod(Integer hours) {
		assertTrue(sicknessReport.getKey() == (float) hours);
	}

	@Then("the employee with the ID {string} has the personal activity with the name {string}")
	public void theEmployeeWithTheIDHasThePersonalActivityWithTheName(String initials, String name) {
		assertTrue(database.getEmployee(initials).hasActivity(name));
	}

	@Then("the personal activity has the type {string}")
	public void thePersonalActivityHasTheType(String type) {
		assertTrue(recentPA.getType().toString().equals(type));
	}

	@Then("the employee with the ID {string} has a registered vacation from week {int} until week {int}")
	public void theEmployeeWithTheIDHasARegisteredVacationFromWeekUntilWeek(String initials, Integer sw, Integer ew) {
		assertTrue(database.getEmployee(initials).hasVacation(sw, ew));
	}
}

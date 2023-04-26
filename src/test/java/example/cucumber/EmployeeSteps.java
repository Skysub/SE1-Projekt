package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Database;
import application.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {
    Database database;
    ErrorMessageHolder errorMessageHolder;
    Employee employee;

    public EmployeeSteps(Database database, ErrorMessageHolder errorMessageHolder){
        this.database = database;
        this.errorMessageHolder = errorMessageHolder;
    }

    @When("a new employee profile with the ID {string} is made")
public void aNewEmployeeProfileWithTheIDIsMade(String initials) {
    // Write code here that turns the phrase above into concrete actions
    database.CreateEmployee(initials);
}
    @Then("The employee has the initials {string}")
public void theEmployeeHasTheInitials(String expectedInitials) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(expectedInitials, database.getEmployee(expectedInitials).getInitials());
}

@Given("an employee with the ID {string} exists")
public void anEmployeeWithTheIDExists(String initials) {
    database.CreateEmployee(initials);
}

@Then("the employee with the ID {string} has the activity with name {string}")
public void theEmployeeHasTheActivityWithName(String initials, String activityName) {
    // Write code here that turns the phrase above into concrete actions
    assertTrue(database.getEmployee(initials).hasActivity(activityName));
}
}

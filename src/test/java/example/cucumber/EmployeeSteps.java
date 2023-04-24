package example.cucumber;

import static org.junit.Assert.assertEquals;

import application.Employee;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {
    Employee employee;

    @When("a new employee profile with the ID {string} is made")
public void aNewEmployeeProfileWithTheIDIsMade(String initials) {
    // Write code here that turns the phrase above into concrete actions
    employee = new Employee(initials);
}
    @Then("The employee has the initials {string}")
public void theEmployeeHasTheInitials(String expectedInitials) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(expectedInitials, Employee.getInitials());
}

}

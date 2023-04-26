package example.cucumber;

import application.Database;
import application.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {

    Database database;

    ErrorMessageHolder errorMessageHolder;

    @Given("an employee with the ID {string} exists")
    public void anEmployeeWithTheIdExists(String string) {
        Employee employee =
        throw new io.cucumber.java.PendingException();
    }
    @When("the employee creates a project with project number {int} and project name {string}")
    public void the_employee_creates_a_project_with_project_number_and_project_name(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the project with project number {int} and project name {string} exists")
    public void the_project_with_project_number_and_project_name_exists(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

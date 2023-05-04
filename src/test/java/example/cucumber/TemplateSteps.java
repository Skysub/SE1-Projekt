package example.cucumber;

import static org.junit.Assert.assertEquals;

import application.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TemplateSteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	

	public TemplateSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}
	
	@When("an employee saves the project with ID {string} as a template with the ID {int}")
	public void anEmployeeSavesTheProjectWithIDAsATemplateWithTheID(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the employee gives the template the name {string}")
	public void theEmployeeGivesTheTemplateTheName(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the template with ID {int} exists")
	public void theTemplateWithIDExists(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the template with ID {int} has the name {string}")
	public void theTemplateWithIDHasTheName(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the template with  ID {int} has an activity named {string}")
	public void theTemplateWithIDHasAnActivityNamed(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}

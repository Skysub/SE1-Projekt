package example.cucumber;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import application.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Klassen er skrevet af Frederik Cayré Hede-Andersen
public class TemplateSteps {
	Database database;
	ErrorMessageHolder errorMessageHolder;
	Template recentTemplate;
	
	public TemplateSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}
	
	////Hele klassen er skrevet af Frederik Cayré Hede-Andersen
	
	@When("an employee saves the project with ID {int} as a template with the ID {int}")
	public void anEmployeeSavesTheProjectWithIDAsATemplateWithTheID(Integer pID, Integer tID) throws IllegalOperationException {
	    recentTemplate =  database.MakeTemplate(database.getProject(pID), tID);
	}

	@When("the employee gives the template the name {string}")
	public void theEmployeeGivesTheTemplateTheName(String name) {
	    recentTemplate.setName(name);
	}

	@Then("the template with ID {int} exists")
	public void theTemplateWithIDExists(Integer ID) {
	    assertTrue(database.hasTemplate(ID)); 
	}

	@Then("the template with ID {int} has the name {string}")
	public void theTemplateWithIDHasTheName(Integer ID, String name) {
	   assertEquals(name, database.getTemplate(ID).getName());
	}

	@Then("the template with  ID {int} has an activity named {string}")
	public void theTemplateWithIDHasAnActivityNamed(Integer ID, String name) {
		assertTrue(database.getTemplate(ID).hasActivity(name));
	}
}

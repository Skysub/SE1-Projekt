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

public class ProjectSteps {

	Database database;
	ErrorMessageHolder errorMessageHolder;
	Project recentProject;
	Employee recentManager;
	WorkActivity recentWorkActivity;

	public ProjectSteps(Database database, ErrorMessageHolder errorMessageHolder) {
		this.database = database;
		this.errorMessageHolder = errorMessageHolder;
	}

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Given("the project with project number {int} has a project manager with the ID {string}")
	public void theProjectWithProjectNumberHasAProjectManagerWithTheID(Integer projectID, String managerID) {
		recentManager = database.getProject(projectID).setManager(database.getEmployee(managerID));
	}

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Given("the project has a workActivity with the name {string}")
	public void theProjectHasAnActivityWithTheName(String name) throws IllegalOperationException {
		recentWorkActivity = recentProject.addActivity(new WorkActivity(name), recentManager);
	}

	//Metoden er skrevet af Naila Aoussar
	@Given("a project with project number {int} and project name {string} exists")
	public void theProjectWithProjectNumberAndProjectNameExists(Integer ID, String name) throws Exception{
		recentProject = database.CreateProject(ID, name);
	}

	//Metoden er skrevet af Naila Aoussar
	@When("the employee creates a project with project number {int} and project name {string}")
	public void the_employee_creates_a_project_with_project_number_and_project_name(Integer ID, String name) {
		try {
			recentProject = database.CreateProject(ID, name);
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@When("the project manager assigns the employee with the ID {string} to the workActivity")
	public void theProjectManagerAssignsTheEmployeeWithTheIDToTheActivity(String ID) {
		try {
			recentWorkActivity.addEmployee(database.getEmployee(ID), recentManager);
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@When("the employee with the ID {string} assigns the employee with the ID {string} to the workActivity")
	public void theEmployeeWithTheIDAssignsTheEmployeeWithTheIDToTheWorkActivity(String ID1, String ID2) {
		try {
			recentWorkActivity.addEmployee(database.getEmployee(ID1), database.getEmployee(ID2));
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@When("an employee sets the description {string} to the project")
	public void anEmployeeSetsTheDescriptionToTheProject(String description) {
		recentProject.setDescription(description);
	}

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Then("the project has the description {string}")
	public void theProjectHasTheDescription(String description) {
	    assertEquals(description, recentProject.getDescription());
	}

	//Metoden er skrevet af Naila Aoussar
	@Then("the project with project number {int} and project name {string} exists")
	public void the_project_with_project_number_and_project_name_exists(Integer ID, String name) {
		Project project = database.getProject(ID);
		assertEquals(project.getName(), name);
	}

	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Then("the activity in the project has the employee with initials {string}")
	public void theActivityInTheProjectHasTheEmployeeWithInitials(String initials) {
		assertTrue(recentWorkActivity.containsEmployee(database.getEmployee(initials)));
	}
	
	//Metoden er skrevet af Frederik Cayré Hede-Andersen
	@Then("the project with ID {int} has an activity with the name {string}")
	public void theProjectHasAnActivity(Integer ID, String name) {
		assertTrue(database.getProject(ID).hasActivity(name));
	}
}

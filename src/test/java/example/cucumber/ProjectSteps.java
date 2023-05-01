package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.*;
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

	@Given("the project with project number {int} has a project manager with the ID {string}")
	public void theProjectWithProjectNumberHasAProjectManagerWithTheID(Integer projectID, String managerID) {
		recentManager = database.getProject(projectID).setManager(database.getEmployee(managerID));
	}

	@Given("the project has a workActivity with the name {string}")
	public void theProjectHasAnActivityWithTheName(String name) {
		recentWorkActivity = recentProject.addActivity(new WorkActivity(name, recentProject));
	}

	@Given("a project with project number {int} and project name {string} exists")
	public void theProjectWithProjectNumberAndProjectNameExists(Integer ID, String name) {
		recentProject = database.CreateProject(ID, name);
	}

	@When("the employee creates a project with project number {int} and project name {string}")
	public void the_employee_creates_a_project_with_project_number_and_project_name(Integer ID, String name) {
		// Write code here that turns the phrase above into concrete actions
		recentProject = database.CreateProject(ID, name);
	}

	@When("the project manager assigns the employee with the ID {string} to the workActivity")
	public void theProjectManagerAssignsTheEmployeeWithTheIDToTheActivity(String ID) {
		try {
			recentWorkActivity.addEmployee(database.getEmployee(ID), recentManager);
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the employee with the ID {string} assigns the employee with the ID {string} to the workActivity")
	public void theEmployeeWithTheIDAssignsTheEmployeeWithTheIDToTheWorkActivity(String ID1, String ID2) {
		try {
			recentWorkActivity.addEmployee(database.getEmployee(ID1), database.getEmployee(ID2));
		} catch (IllegalOperationException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}


	@Then("the project with project number {int} and project name {string} exists")
	public void the_project_with_project_number_and_project_name_exists(Integer ID, String name) {
		Project project = database.getProject(ID);
		assertEquals(project.getName(), name);
	}

	@Then("the activity in the project has the employee with initials {string}")
	public void theActivityInTheProjectHasTheEmployeeWithInitials(String ID) {
		assertTrue(recentWorkActivity.containsEmployee(ID));
	}
}

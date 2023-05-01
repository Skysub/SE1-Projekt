package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Database;
import application.Employee;
import application.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps {

    Database database;
    ErrorMessageHolder errorMessageHolder;
    Project recentProject;

    public ProjectSteps(Database database, ErrorMessageHolder errorMessageHolder){
        this.database = database;
        this.errorMessageHolder = errorMessageHolder;
    }

    @When("the employee creates a project with project number {int} and project name {string}")
    public void the_employee_creates_a_project_with_project_number_and_project_name(Integer ID, String name) {
        // Write code here that turns the phrase above into concrete actions
    	recentProject = database.CreateProject(ID, name);
    }
    @Then("the project with project number {int} and project name {string} exists")
    public void the_project_with_project_number_and_project_name_exists(Integer ID, String name) {
        // Write code here that turns the phrase above into concrete actions
        Project project = database.getProject(ID);
        assertEquals(project.getName(),name);
    }


}

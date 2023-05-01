package example.cucumber;

import application.Database;
import application.Project;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CreateProjectSteps {

    Database database;

    ErrorMessageHolder errorMessageHolder;

    public CreateProjectSteps(Database database, ErrorMessageHolder errorMessageHolder){
        this.database = database;
        this.errorMessageHolder = errorMessageHolder;
    }


    @When("the employee creates a project with project number {int} and project name {string}")
    public void theEmployeeCreatesAProjectWithProjectNumberAndProjectName(Integer ID, String name) {
        // Write code here that turns the phrase above into concrete actions
        database.CreateProject(ID, name);
    }
    @Then("the project with project number {int} and project name {string} exists")
    public void theProjectWithProjectNumberAndProjectNameExists(Integer ID, String name) {
        // Write code here that turns the phrase above into concrete actions
        Project project = database.getProject(ID);
        assertEquals(project.getName(),name);
    }

    @Given("project with project number {int} and project name {string} exists")
    public void projectWithProjectNumberAndProjectNameExists(Integer ID, String name) {
        database.doesTheProjectExist(ID,name);
    }

    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String name) {
        boolean existingProject = database.doesTheProjectExist(23001, "Time registration");
        assertTrue(name, existingProject);

    }




}

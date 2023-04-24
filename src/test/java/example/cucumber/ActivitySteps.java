package example.cucumber;

import static org.junit.Assert.assertEquals;


import application.WorkActivity;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps {
    WorkActivity workActivity;

@When("a new workActivity with the name {string} is made")
public void aNewWorkActivityWithTheNameIsMade(String name) {
    workActivity = new WorkActivity(name);
}
@Then("The workActivity has the name {string}")
public void theWorkActivityHasTheName(String name) {
    assertEquals(name, workActivity.getName());
}
}

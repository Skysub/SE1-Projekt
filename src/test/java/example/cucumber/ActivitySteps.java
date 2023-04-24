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


@When("a new workActivity with the name {string} and start week {int} is made")
public void aNewWorkActivityWithTheNameAndStartWeekIsMade(String name, int startWeek) {
    // Write code here that turns the phrase above into concrete actions
    workActivity = new WorkActivity(name,startWeek);
}
@Then("The workActivity has the start week {int}")
public void theWorkActivityHasTheStartWeek(int startWeek) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(startWeek, workActivity.getStartWeek());
}

@When("a new workActivity with the name {string}, start week {int} is made and end week {int}")
public void aNewWorkActivityWithTheNameStartWeekIsMadeAndEndWeek(String name, Integer startWeek, Integer endWeek) {
    // Write code here that turns the phrase above into concrete actions
    workActivity = new WorkActivity(name, startWeek, endWeek);
}
@Then("The workActivity has the end week {int}")
public void theWorkActivityHasTheEndWeek(Integer endWeek) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(endWeek, workActivity.getEndWeek());
}

}

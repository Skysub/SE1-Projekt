package example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import application.Database;
import application.WorkActivity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps {
    Database database;
    ErrorMessageHolder errorMessageHolder;
    WorkActivity workActivity;

    public ActivitySteps(Database database, ErrorMessageHolder errorMessageHolder){
        this.database = database;
        this.errorMessageHolder = errorMessageHolder;
    }

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
        workActivity = new WorkActivity(name,startWeek);
}
    @Then("The workActivity has the start week {int}")
        public void theWorkActivityHasTheStartWeek(int startWeek) {
        assertEquals(startWeek, workActivity.getStartWeek());
}

    @When("a new workActivity with the name {string}, start week {int} is made and end week {int}")
        public void aNewWorkActivityWithTheNameStartWeekIsMadeAndEndWeek(String name, Integer startWeek, Integer endWeek) {
        workActivity = new WorkActivity(name, startWeek, endWeek);
}
    @Then("The workActivity has the end week {int}")
        public void theWorkActivityHasTheEndWeek(Integer endWeek) {
        assertEquals(endWeek, workActivity.getEndWeek());
}

    @Given("an activity with the name {string} exists")
        public void anActivityWithTheNameExists(String name) {
        workActivity = new WorkActivity(name);
}

    @When("the employee with the ID {string} is added to the activity")
        public void theEmployeeIsAddedToTheActivity(String initials) {
        workActivity.addEmployee(database.getEmployee(initials));
}

    @Then("the activity has the employee with initials {string}")
        public void theActivityHasTheEmployeeWithInitials(String initials) {
        assertTrue(workActivity.containsEmployee(initials));
}

}

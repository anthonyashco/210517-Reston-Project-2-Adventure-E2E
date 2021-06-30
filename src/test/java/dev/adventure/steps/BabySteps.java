package dev.aashco.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BabySteps {
    @Given("I am somewhere")
    public void somewhere() {
        System.out.println("I am somewhere");
    }

    @When("I do something")
    public void something() {
        System.out.println("I do something");
    }

    @Then("Something should appear")
    public void appear() {
        System.out.println("Something appeared");
    }
}

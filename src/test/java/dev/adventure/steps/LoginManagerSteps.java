package dev.adventure.steps;

import dev.adventure.Config;
import dev.adventure.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginManagerSteps {

    String path = Config.server;

    @Given("The manager is on the login page")
    public void the_manager_is_on_the_login_page() {
        BasicRunner.driver.get(path);
    }

    @When("the manager enters their correct username")
    public void the_manager_enters_their_correct_username() {
        BasicRunner.loginPage.userName.sendKeys("validInput");
    }

    @When("the manager enters their correct password")
    public void the_manager_enters_their_correct_password() {
        BasicRunner.loginPage.password.sendKeys("validInput");
    }
    @When("the manager clicks the manager login button")
    public void the_manager_clicks_the_manager_login_button() {
        BasicRunner.loginPage.managerButton.click();
    }

    @When("the manager enters their incorrect password")
    public void the_manager_enters_their_incorrect_password() {
        BasicRunner.loginPage.password.sendKeys("Not Valid");
    }

    @When("the manager enters their incorrect username")
    public void the_manager_enters_their_incorrect_username() {
        BasicRunner.loginPage.userName.sendKeys("Not Valid");
    }

    @Then("the browser navigates to the Manager UI")
    public void the_browser_navigates_to_the_Manager_UI() {
        String managerText = BasicRunner.claimsPage.planBody.getText();
        System.out.println(managerText);
        Assert.assertEquals(managerText, "Manager");
    }



}

package dev.adventure.steps;

import dev.adventure.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import dev.adventure.Config;

public class LoginSteps {

    String path = Config.server;

    @Given("the customer is at the login portal")
    public void loginPortal() {
        BasicRunner.driver.get(path);
    }

    @When("the customer enters their correct username")
    public void enterUserName() {
        BasicRunner.loginPage.userName.sendKeys("User");
    }

    @When("the customer enters their correct password")
    public void enterPassword() {
        BasicRunner.loginPage.password.sendKeys("pass");
    }

    @When("the customer clicks the login button")
    public void clickSubmit() {
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("the browser navigates to the customer UI")
    public void isClaims() {
        // Write code here that turns the phrase above into concrete actions
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Adventure Insurance Claims");
    }
}

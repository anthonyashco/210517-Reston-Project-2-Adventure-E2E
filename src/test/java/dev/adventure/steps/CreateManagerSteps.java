package dev.adventure.steps;

import dev.adventure.Config;
import dev.adventure.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateManagerSteps {

    String path = Config.server;

    @Given("The manager is on the create account page")
    public void the_manager_is_on_the_create_account_page() {
        BasicRunner.driver.get(path);
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver,2);
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.loginPage.createManager));
        BasicRunner.loginPage.createManager.click();
    }

    @When("The manager enters their name as {string}")
    public void the_manager_enters_their_name_as(String string) {
        BasicRunner.createManagerPage.name.sendKeys(string);
    }
    @When("The manager enters their username as {string}")
    public void the_manager_enters_their_username_as(String string) {
        BasicRunner.createManagerPage.username.sendKeys(string);
    }
    @When("The manager enters their password as {string}")
    public void the_manager_enters_their_password_as(String string) {
        BasicRunner.createManagerPage.password.sendKeys(string);
        BasicRunner.createManagerPage.passwordConfirm.sendKeys(string);
    }
    @When("The manager clicks the checkbox")
    public void the_manager_clicks_the_checkbox() {
        BasicRunner.createManagerPage.checkBox.click();
    }
    @When("The manager clicks the create account button")
    public void the_manager_clicks_the_create_account_button() {
        BasicRunner.createManagerPage.createButton.click();
    }
    @Then("The manager should be notified that something {string} went wrong.")
    public void the_manager_should_be_notified_that_something_went_wrong(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager enters almost all appropriate information")
    public void the_manager_enters_almost_all_appropriate_information() {
        BasicRunner.createManagerPage.name.sendKeys("validInput");
        BasicRunner.createManagerPage.username.sendKeys("validInput");
        BasicRunner.createManagerPage.password.sendKeys("validInput");
        BasicRunner.createManagerPage.passwordConfirm.sendKeys("validInput");
    }

    @Then("The manager should be notified that checkbox needs to be clicked.")
    public void the_manager_should_be_notified_that_checkbox_needs_to_be_clicked() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = BasicRunner.driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("check"));
    }

    @When("The manager enters appropriate information")
    public void the_manager_enters_appropriate_information() {
        BasicRunner.createManagerPage.name.sendKeys("validInput");
        BasicRunner.createManagerPage.username.sendKeys("validInput");
        BasicRunner.createManagerPage.password.sendKeys("validInput");
        BasicRunner.createManagerPage.passwordConfirm.sendKeys("validInput");
        BasicRunner.createManagerPage.checkBox.click();
    }

    @Then("The manager should be notified the account was created and should be redirected to the login page")
    public void the_manager_should_be_notified_the_account_was_created_and_should_be_redirected_to_the_login_page() {
        WebDriverWait wait = new WebDriverWait(BasicRunner.driver,2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = BasicRunner.driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("sure"));
        alert.dismiss();
        wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.loginPage.createCustomer));
        Assert.assertEquals(BasicRunner.driver.getTitle(),"Adventure Insurance Login");
    }


}

package dev.adventure.steps;

import dev.adventure.Config;
import dev.adventure.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CustSubmitClaimsSteps {

    String path = Config.server;

    @Given("the customer is on the claims page")
    public void claimsPortal() {
        BasicRunner.driver.get(path);
        BasicRunner.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        BasicRunner.loginPage.userName.sendKeys("Tester3");
        BasicRunner.loginPage.password.sendKeys("Tester3");
        BasicRunner.loginPage.loginButton.click();
        FluentWait wait = new FluentWait(BasicRunner.driver);
        wait.withTimeout(10, TimeUnit.SECONDS);
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.urlContains("claim"));
    }

    @When("the customer selects a claim in the dropdown")
    public void claimDropdown() {
        WebElement dropdown = BasicRunner.claimsPage.claim;
        Select dropClaims = new Select(dropdown);
        dropClaims.selectByVisibleText("Broken Sword");
    }

    @When("the customer inputs a claim amount")
    public void claimAmount() {
        BasicRunner.claimsPage.amount.sendKeys("500");
    }

    @When("the customer clicks the submit button")
    public void claimSubmit() {
        BasicRunner.claimsPage.claimButton.click();
    }
}

package dev.adventure.runners;

import dev.adventure.pages.ClaimsPage;
import dev.adventure.pages.CreateManagerPage;
import dev.adventure.pages.CreateUserPage;
import dev.adventure.pages.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/createManager.feature", glue = "dev.adventure.steps")
public class BasicRunner {

    public static WebDriver driver = null;
    public static LoginPage loginPage = null;
    public static ClaimsPage claimsPage = null;
    public static CreateUserPage createUserPage = null;
    public static CreateManagerPage createManagerPage = null;
    public static WebDriverWait explicitWait = null;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        claimsPage = new ClaimsPage(driver);
        createUserPage = new CreateUserPage(driver);
        createManagerPage = new CreateManagerPage(driver);
        explicitWait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        

    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}

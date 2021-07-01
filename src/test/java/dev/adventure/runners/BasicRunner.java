package dev.adventure.runners;

import dev.adventure.pages.ClaimsPage;
import dev.adventure.pages.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "dev.adventure.steps")
public class BasicRunner {

    public static WebDriver driver = null;
    public static LoginPage loginPage = null;
    public static ClaimsPage claimsPage = null;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        claimsPage = new ClaimsPage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}

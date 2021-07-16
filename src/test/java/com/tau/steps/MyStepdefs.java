package com.tau.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MyStepdefs {
    private WebDriver driver;

    @Before()
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\leoso\\Documents\\Training sofka\\Training calidad\\Automatizacion de pruebas\\cucuber\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I am in the Login page")
    @Given("I am in the Login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {


        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidCredentials(DataTable table) {

        List<String> loginForm = table.asList();

        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("username")).submit();

    }

    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() throws InterruptedException {

        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/div/div/h1")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();

    }
@After()
    public void quitBrowser(){
        driver.quit();
}

}

package StepDefinition;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.security.util.Password;

import java.sql.Driver;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;



public class LoginStep {
    WebDriver driver;

        @And("Verify User is logged-out message is displayed")
        public void verifyLockedOutMsg(String ErrorMsg)
        {
       ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
       Assert.assertEquals(ErrorMsg,"" );
        }


    @Given("^Open I launch chrome browser$")
    public void open_I_launch_chrome_browser() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\IdeaProjects\\TEST\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-challenge.codesubmit.io");
    }

    @When("^I enter a valid \"(.*?)\" and Valid \"(.*?)\"$")
    public void i_enter_a_valid_and_Valid(String Username, String Password) throws Throwable {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(Username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Password);
    }

    @Then("^The I click Login button$")
    public void the_I_click_Login_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @Then("^I verify that the user is succefully logged in$")
    public void i_verify_that_the_user_is_succefully_logged_in() throws Throwable {
        Boolean found  = driver.findElement(By.xpath("//*[@id='react-burger-menu-btn'])")).isDisplayed();
        if(found)
        {
            System.out.println("User has been successfully logged in");
        }
        else {
            System.out.println("User was not logged in successfully");
        }

    }

    @Then("^I verify that the \"(.*?)\" message is displayed$")
    public void i_verify_that_the_message_is_displayed(String arg1) throws Throwable {
           driver.findElement(By.xpath("//H3[@data-test='error']"));
        }

    @Then("^I verify that the images are loaded$")
    public void i_verify_that_the_images_are_loaded() throws Throwable {
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
    }

    @Then("^I verify that an error message is displayedd$")
    public void i_verify_that_an_error_message_is_displayedd() throws Throwable {
        driver.findElement(By.xpath("//H3[@data-test='error']"));
    }


}

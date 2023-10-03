import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class SdaTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanss\\Desktop\\sda\\Kody\\Selenium\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I open SDA dev website")
    public void iOpenSDADevWebsite() {
        driver.get("https://sdacademy.dev/");
    }

    @When("I redirect to contact")
    public void iRedirectToContact() {
        driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[5]/a")).click();
    }


    @Then("I see something")
    public void iSeeSomething() {

    }
}

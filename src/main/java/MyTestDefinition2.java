import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class MyTestDefinition2 {
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

    @Given("I open website")
    public void iOpenWebsite() {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        driver.manage().window().setSize(new Dimension(1936, 1048));
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }


    @When("I add first name")
    public void iAddFirstName() {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("Jan");
    }

    @And("I add last name")
    public void iAddLastName() {
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("Sima");
    }

    @And("I check my gender")
    public void iCheckMyGender() {
        driver.findElement(By.name("sex")).click();
    }

    @Then("I close my webdriver")
    public void iCloseMyWebdriver() {
        driver.close();
    }

    @When("I add first {string} name")
    public void iAddFirstName(String firstname) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(firstname);
    }

    @And("I add last {string} name")
    public void iAddLastName(String lastname) {
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
    }
}

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MyTestsDefinition {
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

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    @Given("^Open web browser$")
    public void openWebBrowser() {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @Then("I add my first and last name")
    public void iAddMyFirstAndLastName() {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("Jan");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("Sima");
    }

    @And("I fill all the others inputs")
    public void iFillAllTheOthersInputs() {
        driver.findElement(By.name("sex")).click();
        driver.findElement(By.cssSelector("span:nth-child(5) > input")).click();
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[3]/div/form/div/table/tbody/tr[5]/td[2]/input")).sendKeys("11.06.1993");
        driver.findElement(By.cssSelector("tr:nth-child(6) span:nth-child(2) > input")).click();
        driver.findElement(By.cssSelector("tr:nth-child(8) span:nth-child(2) > input")).click();
        driver.findElement(By.name("continents")).click();
        {
            WebElement dropdown = driver.findElement(By.name("selenium_commands"));
            dropdown.findElement(By.xpath("//option[. = 'Wait Commands']")).click();
        }
        driver.findElement(By.cssSelector("tr:nth-child(10) option:nth-child(4)")).click();
        driver.findElement(By.cssSelector("tr:nth-child(10) option:nth-child(4)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("tr:nth-child(10) option:nth-child(4)"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
    }
}

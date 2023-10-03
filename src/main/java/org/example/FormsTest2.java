package org.example;


import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class FormsTest2 {
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


  @Test
  public void forms() {

    driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");

    driver.manage().window().setSize(new Dimension(1936, 1048));

    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();

    driver.findElement(By.name("firstname")).click();

    driver.findElement(By.name("firstname")).sendKeys("Jan");

    driver.findElement(By.name("lastname")).click();

    driver.findElement(By.name("lastname")).sendKeys("Sima");

    driver.findElement(By.name("sex")).click();

  }
}

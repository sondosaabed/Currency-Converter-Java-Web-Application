// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ChoseDataSourceTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void choseDataSource() {
    driver.get("http://localhost:8080/currencyConvert/");
    driver.manage().window().setSize(new Dimension(774, 843));
    driver.findElement(By.cssSelector("button:nth-child(2)")).click();
    driver.findElement(By.name("source")).click();
    driver.findElement(By.cssSelector("button:nth-child(2)")).click();
    driver.findElement(By.id("fromCurrency")).click();
    {
      WebElement dropdown = driver.findElement(By.id("fromCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'AED - 1.0122']")).click();
    }
    driver.findElement(By.cssSelector("#fromCurrency > option:nth-child(2)")).click();
    driver.findElement(By.id("toCurrency")).click();
    {
      WebElement dropdown = driver.findElement(By.id("toCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'AED - 1.0122']")).click();
    }
    driver.findElement(By.cssSelector("#toCurrency > option:nth-child(2)")).click();
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.cssSelector("button:nth-child(2)")).click();
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.id("amount")).sendKeys("12");
    driver.findElement(By.id("fromCurrency")).click();
    driver.findElement(By.cssSelector("#fromCurrency > option:nth-child(1)")).click();
    driver.findElement(By.id("toCurrency")).click();
    {
      WebElement dropdown = driver.findElement(By.id("toCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'ANG - 0.4934']")).click();
    }
    driver.findElement(By.cssSelector("#toCurrency > option:nth-child(6)")).click();
    driver.findElement(By.cssSelector("button:nth-child(7)")).click();
    driver.findElement(By.id("result")).click();
    driver.findElement(By.id("resetButton")).click();
    driver.findElement(By.id("fromCurrency")).click();
    {
      WebElement dropdown = driver.findElement(By.id("fromCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'AMD - 106.6547']")).click();
    }
    driver.findElement(By.cssSelector("#fromCurrency > option:nth-child(5)")).click();
    driver.findElement(By.id("toCurrency")).click();
    {
      WebElement dropdown = driver.findElement(By.id("toCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'AFN - 23.5696']")).click();
    }
    driver.findElement(By.cssSelector("#toCurrency > option:nth-child(3)")).click();
    driver.findElement(By.cssSelector("button:nth-child(7)")).click();
    driver.findElement(By.id("currencyForm")).click();
    driver.findElement(By.cssSelector("button:nth-child(7)")).click();
    driver.findElement(By.id("amount")).sendKeys("12");
    driver.findElement(By.cssSelector("button:nth-child(7)")).click();
    driver.findElement(By.cssSelector("html")).click();
  }
}

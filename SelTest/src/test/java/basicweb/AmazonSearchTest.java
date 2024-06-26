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
public class AmazonSearchTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void amazonSearch() {
    driver.get("https://www.amazon.com/");
    driver.manage().window().setSize(new Dimension(1734, 1410));
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    assertThat(driver.getTitle(), is("Amazon.com : iphone"));
    driver.findElement(By.cssSelector("#nav-cart-text-container > .nav-line-2")).click();
    assertThat(driver.findElement(By.cssSelector(".a-row > .a-spacing-top-base")).getText(), is("Your Amazon Cart is empty."));
    driver.findElement(By.cssSelector("#nav-link-accountList > .nav-line-2")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Your Account"));
  }
}

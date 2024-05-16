package basicweb;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SeleniumFeaturesTest {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	//launch browser
	public void LaunchBrowser() {
		System.setProperty("webdriver.chomedriver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
	}
	
	@Test
	public void SizingTest() throws InterruptedException, IOException{
		driver.manage().window().maximize();
	}
	
	@Test
	public void MouseHover() throws InterruptedException, IOException{
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='gh-minicart-hover']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		//Capture screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/ebayCapture.png");
		Files.copy(source,  dest);
	}
	
	@Test
	public void getCssProp() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[4]/div[1]/div/div[1]")).getCssValue("font-size"));
		String actualSize = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[4]/div[1]/div/div[1]")).getCssValue("font-size");
		String expectedSize = "14px";
		Assert.assertEquals(actualSize, expectedSize, "Font mismatch");	
		//Thread.sleep(5000);
	}
	
	@Test
	public void SelectDropDown() throws InterruptedException{
		WebElement catDrop = driver.findElement(By.id("gh-cat"));
		Select cat_sel = new Select(catDrop);
		cat_sel.selectByValue("267");
		System.out.println("Selected category is: " + cat_sel.getFirstSelectedOption().getText());
		cat_sel.selectByIndex(0);
		System.out.println("Selected category is: " + cat_sel.getFirstSelectedOption().getText());
		cat_sel.selectByVisibleText("Crafts");
		System.out.println("Selected category is: " + cat_sel.getFirstSelectedOption().getText());
		Thread.sleep(2000);		
	}
	
	@Test
	public void EnterSearchText() throws InterruptedException{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('gh-ac').value='Death Dealer'");
		Thread.sleep(2000);
		driver.findElement(By.id("gh-btn")).click();
		driver.navigate().back();
	}
	
	@Test
	public void ScrollBrowser() throws InterruptedException{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		System.out.println("The title of the page is: " + driver.getTitle());
	}
	
	@Test
	public void VerifyTitle() throws InterruptedException{
		String actualTitle = driver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");		
	}
	
	@Test
	public void FindAllInputs() throws InterruptedException{
		List<WebElement> elements = driver.findElements(By.xpath("//input[starts-with(@class, 'gh')]"));
		System.out.println("Made it here");
		for(WebElement ele:elements) {
			System.out.println(ele.getAttribute("id"));
		}
	}
	
	@AfterTest
	//close browser
	public void closebrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		SeleniumFeaturesTest obj = new SeleniumFeaturesTest();
		obj.LaunchBrowser();
		obj.SizingTest();
		obj.MouseHover();
		obj.getCssProp();
		obj.SelectDropDown();
		obj.EnterSearchText();
		obj.ScrollBrowser();
		obj.VerifyTitle();
		obj.FindAllInputs();
		obj.closebrowser();
	}
}
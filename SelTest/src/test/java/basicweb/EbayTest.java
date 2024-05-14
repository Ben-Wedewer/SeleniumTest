package basicweb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayTest {

	// TODO Auto-generated method stub
	WebDriver driver = new ChromeDriver();
	
	//launch browser
	public void LaunchBrowser() {
		System.setProperty("webdriver.chomedriver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
	}
	//search selenium training
	public void SearchProduct() throws InterruptedException {
		driver.findElement(By.id("gh-ac")).sendKeys("JBL Speakers");
		Thread.sleep(3000);
		driver.findElement(By.id("gh-btn")).click();
		//driver.findElement(By.xpath("//span[@class='search_icon input-search-icon']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//h2[text()='Automation Testing Masters Program']")).click();
		driver.findElement(By.linkText("Daily Deals")).click();
		Thread.sleep(3000);
		System.out.println("The page title is: " + driver.getTitle());		
	}
	
	public void Navigate() throws InterruptedException{
		Thread.sleep(2000);
		driver.navigate().to("https://www.simplilearn.com/");
		Thread.sleep(2000);
		System.out.println("The title of the page is: " + driver.getTitle());
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	//close browser
	public void closebrowser() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		EbayTest obj = new EbayTest();
		obj.LaunchBrowser();
		obj.SearchProduct();
		obj.Navigate();
		obj.closebrowser();
		//Test complete
		//Adding a second commit to test commits of changed source
	
	}
}
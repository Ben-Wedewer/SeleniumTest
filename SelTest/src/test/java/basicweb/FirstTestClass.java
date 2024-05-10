package basicweb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {

	// TODO Auto-generated method stub
	WebDriver driver = new ChromeDriver();
	
	//launch browser
	public void LaunchBrowser() {
		System.setProperty("webdriver.chomedriver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
	}
	//search selenium training
	public void SearchTraining() throws InterruptedException {
		driver.findElement(By.id("header_srch")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='search_icon input-search-icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='Automation Testing Masters Program']")).click();
		System.out.println("The page title is: " + driver.getTitle());		
	}
	//close browser
	public void closebrowser() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		FirstTestClass obj = new FirstTestClass();
		obj.LaunchBrowser();
		obj.SearchTraining();
		obj.closebrowser();
		//Test complete
		//Adding a second commit to test commits of changed source
	
	}
}
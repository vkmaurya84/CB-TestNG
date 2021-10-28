package CBApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public static WebDriver driver = null;
	
	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vineet kumar\\Downloads\\Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeClass(dependsOnMethods = {"testSetup"})
	public static void openBrowser() {
		driver.get("https://web.cardbyte.ai/login");
		System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl() , "https://web.cardbyte.ai/login");
	}
	
	public void loginCred() throws InterruptedException
	{
		driver.findElement(By.name("email")).sendKeys("vkmaurya847@gmail.com" , Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("1234567");
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		
		WebDriverWait w = new WebDriverWait(driver , 20);
		w.until(ExpectedConditions.urlMatches("https://web.cardbyte.ai/contacts"));
	
		toastMessage();
		
	}
	
	public void toastMessage()
	{
		driver.findElement(By.className("Toastify__close-button")).click();
	}
	
	public void contactBlock()
	{
		
		driver.findElement(By.xpath("//div/button[@aria-label='block']")).click(); 
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
	}
	
	public void contactFavourite()
	{
		
		driver.findElement(By.xpath("//button[@aria-label='favourite']")).click();
	}
	
	public void tagsUpdate()
	{
		
		driver.findElement(By.xpath("//button[@aria-label='tags']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'work')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
	}
	
	public void cardPath()
	{
//		driver.findElement(By.xpath("//label[contains(text(),'K')]")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'#')]")).click();
		driver.findElement(By.cssSelector("[data-id='0']")).click();
	}
	
	public void companyPath()
	{
		driver.findElement(By.cssSelector("[data-id='1']")).click();
	}
	
	public void sendCard()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Send my card')]")).click();
		driver.findElement(By.xpath("//div[@id='send_card_component']/div[2]/div/div[3]/button")).click();
	}
}

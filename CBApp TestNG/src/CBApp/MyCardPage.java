package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyCardPage extends Base{
	
	public void login() throws InterruptedException
	{
		Base b = new Base();
		b.loginCred();
	}
	
	@Test  (priority = 1)
	public void Card() throws InterruptedException
	{
		login();
		Thread.sleep(4000);
		navigate();
		
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'My Cards')]")).click();
	}
	
	@Test(dependsOnMethods = {"Card"})
	public void shareCard()
	{
		driver.findElement(By.xpath("//div[@class='myCards__main']/div/div/button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
	}
	
//	@Test(dependsOnMethods = {"view"})
//	public void edit()
//	{
//		driver.findElement(By.xpath("//div/span[@aria-label='edit-card']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		driver.findElement(By.xpath("//div[@id='1']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); 
//	  	driver.findElement(By.xpath("//span[contains(text(),'Looks Good!')]")).click();
//	}
	
	@Test(dependsOnMethods = {"shareCard"})
	public void view()
	{
		driver.findElement(By.xpath("//div/span[@aria-label='view-card']")).click();
		driver.findElement(By.xpath("//div[@class='card_creation_form shared-container']/div[2]/div[2]/button")).click();
	}
	
	@Test(dependsOnMethods = {"view"}, dataProvider="newCard")
	public void newCard(String FName, String LName ,String address, String pin, String mobile ,String facebook) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//h3[contains(text(),'Add a new card')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Prefix')]")).click();
		driver.findElement(By.cssSelector("#react-select-3-option-3")).click();
		
//		WebElement fname = driver.findElement(By.name("firstName"));
//		fname.clear();
//		fname.sendKeys("FName");
//		
//		WebElement lname = driver.findElement(By.name("lastName"));
//		lname.clear();
//		lname.sendKeys("LName");
		
		driver.findElement(By.xpath("//div/div[text()='Business name*']")).click();
		driver.findElement(By.cssSelector("#react-select-4-option-5")).click();
		
		driver.findElement(By.xpath("//div/div[text()='Designation*']")).click();
		driver.findElement(By.cssSelector("#react-select-5-option-2")).click();
		
		driver.findElement(By.name("addressLine1")).sendKeys(address);
		Thread.sleep(2000);
		driver.findElement(By.name("pincode")).sendKeys(pin);
		driver.findElement(By.name("mobileNumber")).sendKeys(mobile);
		
		driver.findElement(By.name("facebook")).sendKeys(facebook);
		
		driver.findElement(By.xpath("//div/div[text()='Profession']")).click();
		driver.findElement(By.cssSelector("#react-select-6-option-1")).click();
		
		driver.findElement(By.xpath("//div/div[text()='Industry*']")).click();
		driver.findElement(By.cssSelector("#react-select-7-option-1")).click();
		
		driver.findElement(By.xpath("//div/div[text()='Experience Level']")).click();
		driver.findElement(By.cssSelector("#react-select-8-option-1")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	}
	
	@Test(dependsOnMethods = {"newCard"})
	public void newCardTheme()
	{
		driver.findElement(By.xpath("//div[@id='17']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Looks Good!')]")).click();
	}
	
	@DataProvider(name="newCard")
	public Object[][] data()
	{
		Object[][] data = {{"Vineet","Kumar","Ghaziabad NCR", "587467", "+918978978978", "https://facebook.com/"}};
		return data;
		
	}

}

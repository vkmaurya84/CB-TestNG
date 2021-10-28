package CBApp;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Setting extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 10)
	public void setting() throws InterruptedException
	{
		login();
		Thread.sleep(4000);
		
		navigate();
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//button[@aria-label='account of current user']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
	}
	
	@Test(dependsOnMethods = {"setting"})
	public void account()
	{
		driver.findElement(By.xpath("//h5[contains(text(),'vineet maurya')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
	}
	
	@Test(dependsOnMethods = {"account"})
	public void privacy()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Privacy')]")).click();
		driver.findElement(By.xpath("//div[@id='privacy-sidebar']/div[2]/div[2]/div[1]/div[2]/span[1]")).click();  /// Option 1
		driver.findElement(By.xpath("//div[@id='privacy-sidebar']/div[2]/div[3]/div[1]/div[2]/span[1]")).click();   /// Option 2
		driver.findElement(By.xpath("//div[@id='privacy-sidebar']/div[1]/span[1]/button[1]")).click();     // back button
	}
	
	@Test(dependsOnMethods = {"privacy"})
	public void notification()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Notifications')]")).click();
		driver.findElement(By.xpath("//div[@id='privacy-sidebar']/div[1]/div[2]/div[1]/div[2]/span[1]")).click();   /// Latest update section
		driver.findElement(By.xpath("//div[@id='privacy-sidebar']/div[1]/div[3]/div[1]/div[2]/span[1]")).click();
		driver.findElement(By.xpath("//div[@id='notofication']/span[1]/button[1]")).click();		// back button
	}
	
	@Test(dependsOnMethods = {"notification"})
	public void plans()
	{
		driver.findElement(By.xpath("//span[contains(text(),'My Plan')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'Platinum')]")).click();
		
		driver.findElement(By.xpath("//button[@aria-label='back']")).click();
		driver.findElement(By.xpath("//div[@id='plan-container']/div[1]/span[1]/button[1]")).click();		// back button
	}
	
	@Test(dependsOnMethods = {"plans"})
	public void rAndE()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Refer And Earn')]")).click();
	}
	
	@Test(dependsOnMethods = {"rAndE"})
	public void help()
	{
		navigate();
		driver.findElement(By.xpath("//span[contains(text(),'Help')]")).click();
	}
	
	@Test(dependsOnMethods = {"help"})
	public void feedback()
	{
		navigate();
		driver.findElement(By.xpath("//span[contains(text(),'Feedback')]")).click();
		driver.findElement(By.xpath("//div[@id='CommentBox']/div[1]/span[1]/button[1]")).click();		// back button
	}
	
	@Test(dependsOnMethods = {"feedback"})
	public void about()
	{
		driver.findElement(By.xpath("//span[contains(text(),'About')]")).click();
	}
	
	@AfterClass
	public void logout()
	{
		driver.findElement(By.xpath("//button[@aria-label='account of current user']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
	}
}

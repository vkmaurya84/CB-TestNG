package CBApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Notification extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 9)
	public void setting() throws InterruptedException
	{
		login();
		Thread.sleep(4000);
		
		navigate();
	}
	
	public void navigate() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@aria-label='show 17 new notifications']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='notification-list']/div/div/span[2]/button")).click();      ///close button
	}
}

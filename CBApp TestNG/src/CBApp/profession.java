package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class profession extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 5)
	public void professions() throws InterruptedException
	{
		login();
		Thread.sleep(3000);
		navigate();
		
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Professions')]")).click();
	}
	
	@Test(dependsOnMethods = {"professions"})
	public void professionList()
	{
		driver.findElement(By.xpath("//div[@id='professionA']/div[2]")).click();
		b.companyPath();
	}
	
	@Test(dependsOnMethods = {"professionList"})
	public void block()
	{
		b.contactBlock();
	}
	
	@Test(dependsOnMethods = {"block"})
	public void favourite() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		professionList();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void tags() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		professionList();
		b.tagsUpdate();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void cardSend() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		professionList();
		b.sendCard();
	}
}

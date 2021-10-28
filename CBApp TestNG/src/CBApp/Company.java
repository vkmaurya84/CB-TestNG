package CBApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Company extends Base{
	
	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 3)
	public void companies() throws InterruptedException
	{
		login();
		Thread.sleep(3000);
		navigate();
		
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Companies')]")).click();
	}
	
	@Test(dependsOnMethods = {"companies"})
	public void companyList()
	{
		driver.findElement(By.xpath("//div[@id='companyA']/div[2]")).click();
		b.companyPath();
	}
	
	@Test(dependsOnMethods = {"companyList"})
	public void block()
	{
		b.contactBlock();
	}
	
	@Test(dependsOnMethods = {"block"})
	public void favourite()
	{
		navigate();
		companyList();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void tags() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		companyList();
		b.tagsUpdate();
	}

}

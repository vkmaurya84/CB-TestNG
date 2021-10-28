package CBApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Industry extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 4)
	public void industries() throws InterruptedException
	{
		login();
		Thread.sleep(3000);
		navigate();
		
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Industries')]")).click();
	}
	
	@Test(dependsOnMethods = {"industries"})
	public void industriesList()
	{
		driver.findElement(By.xpath("//div[@id='industryA']/div[2]")).click();
		b.companyPath();
	}
	
	@Test(dependsOnMethods = {"industriesList"})
	public void block()
	{
		b.contactBlock();
	}
	
	@Test(dependsOnMethods = {"block"})
	public void favourite() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		industriesList();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void tags() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		industriesList();
		b.tagsUpdate();
	}
}

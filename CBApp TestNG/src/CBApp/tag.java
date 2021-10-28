package CBApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class tag extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 6)
	public void tags() throws InterruptedException
	{
		login();
		Thread.sleep(3000);
		navigate();
		
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Tags')]")).click();
	}
	
	@Test(dependsOnMethods = {"tags"})
	public void tagUpdate() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='tagsB']//span[@class='update-delete-tag']/button[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
	}
	
	@Test(dependsOnMethods = {"tagUpdate"})
	public void  tagDelete() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='tagsB']//span[@class='update-delete-tag']/button[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
	}
	@Test(dependsOnMethods = {"tagDelete"})
	public void tagList()
	{
		driver.findElement(By.xpath("//div[@id='tagsB']/div[2]")).click();
		b.companyPath();
	}
	
	@Test(dependsOnMethods = {"tagList"})
	public void block()
	{
		b.contactBlock();
	}
	
	@Test(dependsOnMethods = {"block"})
	public void favourite() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		tagList();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void Tags() throws InterruptedException
	{
		Thread.sleep(2000);
		navigate();
		tagList();
		b.tagsUpdate();
	}
}

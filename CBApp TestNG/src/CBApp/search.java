package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class search extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 7)
	public void searchh() throws InterruptedException
	{
		login();
		Thread.sleep(3000);

	}
	
	@Test(dependsOnMethods = {"searchh"})
	public void searchContact()
	{
		driver.findElement(By.id("mui-component-select-search")).click();
		driver.findElement(By.xpath("//ul/li[@data-value='CONTACTS']")).click();
		driver.findElement(By.xpath("//div/input[@class='MuiInputBase-input']")).sendKeys("karan", Keys.ENTER);
		
		driver.findElement(By.xpath("//table[@class='search-table table']/tbody/tr[1]")).click();
	}
	
	
	@Test(dependsOnMethods = {"searchContact"})
	public void block()
	{
		b.contactBlock();
	}
	
	@Test(dependsOnMethods = {"block"})
	public void favourite() throws InterruptedException
	{
		Thread.sleep(2000);
		b.toastMessage();
		searchContact();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void Tags() throws InterruptedException
	{
		Thread.sleep(2000);
		b.toastMessage();
		searchContact();
		b.tagsUpdate();
	}
}

package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_page extends Base{
	
	Base b;
	public void login()
	{
		 b = new Base();
	}
	
	
	@Test (priority = 0)
	public void mailLogin()
	{
		driver.findElement(By.name("email")).sendKeys("vkmaurya847@gmail.com" , Keys.ENTER);
		 String text = driver.findElement(By.xpath("//h4[contains(text(),'Enter Password')]")).getText();
		 Assert.assertEquals(text, "Enter Password");
	}
	
	
	@Test(dependsOnMethods = {"mailLogin"})
	public void password() throws InterruptedException
	{
		driver.findElement(By.name("email")).sendKeys("1234567");
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		
		WebDriverWait w = new WebDriverWait(driver , 10);
		w.until(ExpectedConditions.urlMatches("https://web.cardbyte.ai/contacts"));
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://web.cardbyte.ai/contacts");
	}
	
	@Test(dependsOnMethods = {"password"})
	public void contactPreview()
	{
		cardPath();
		String preview = driver.findElement(By.xpath("//span[contains(text(),'Card Preview')]")).getText();
		Assert.assertEquals(preview, "Card Preview");
	}
	
	@Test(dependsOnMethods = {"contactPreview"})
	public void contactBlock()
	{
		b.contactBlock();
		
//		driver.findElement(By.xpath("//div/button[@aria-label='block']")).click(); 
//		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
	}
	
	@Test(dependsOnMethods = {"contactPreview"})
	public void contactFavourite()
	{
		b.cardPath();
		b.contactFavourite();
//		driver.findElement(By.xpath("//button[@aria-label='favourite']")).click();
	}
	
	@Test(dependsOnMethods = {"contactPreview"})
	public void tagsUpdate()
	{
		b.cardPath();
		b.tagsUpdate();
//		driver.findElement(By.xpath("//button[@aria-label='tags']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'work')]")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
	}
	
}

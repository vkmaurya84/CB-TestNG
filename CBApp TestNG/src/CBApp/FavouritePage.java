package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FavouritePage extends Base{
	
	Base b;
	
	public void login() throws InterruptedException
	{
		b = new Base();
		b.loginCred();

	}
	@Test (priority = 2)
	public void favourite() throws InterruptedException
	{
		login();
//		WebDriverWait w = new WebDriverWait(driver , 20);
//		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Favourite')]")));
		Thread.sleep(3000);
		navigate();
//		driver.findElement(By.cssSelector("[data-id='0']")).click();
	}
	
	public void navigate()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Favourite')]")).click();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void block()
	{
		b.contactBlock();
	
	}
	
//	@Test(dependsOnMethods = {"favourite"})
	public void c_favourite()
	{
		navigate();
		b.contactFavourite();
	}
	
	@Test(dependsOnMethods = {"favourite"})
	public void tags()
	{
		navigate();
		b.tagsUpdate();
	}
}

package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Search2 extends Base{

	Base b;
	public void login() throws InterruptedException
	{
		 b = new Base();
		b.loginCred();
	}
	
	@Test (priority = 8)
	public void search() throws InterruptedException
	{
		login();
		Thread.sleep(4000);

	}
	
	@Test(dependsOnMethods = {"search"})
	public void searchGlobal()
	{
		driver.findElement(By.id("mui-component-select-search")).click();
		driver.findElement(By.xpath("//ul/li[@data-value='CONTACTS']")).click();
		driver.findElement(By.xpath("//div/input[@class='MuiInputBase-input']")).sendKeys("vikas", Keys.ENTER);
		
	}
	
	@Test(dependsOnMethods = {"searchGlobal"})
	public void globalCard() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@aria-label='global-search']/button[2]")).click();
		driver.findElement(By.xpath("//button[@id='0']")).click();
		driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[1]/div[6]/button[1]")).click();
	}
}

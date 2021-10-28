package CBApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ForgetPassword  extends Base{
	
	@Test
	public void forgetPass() throws InterruptedException
	{
		driver.findElement(By.name("email")).sendKeys("vkmaurya847@gmail.com" , Keys.ENTER);
		driver.findElement(By.linkText("Forgot password ?")).click();
		driver.findElement(By.name("email")).sendKeys("vkmaurya847@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Reset password')]")).click();
		driver.findElement(By.xpath("//Button[@aria-label='back']")).click();

	}
	
	public void login() throws InterruptedException
	{
		Base b = new Base();
		b.loginCred();
	}
	
	@Test
	public void sendCard()
	{
		login();
		driver.findElement(By.cssSelector("[data-id='0']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Send my card')]")).click();
		driver.findElement(By.xpath("//div[@id='send_card_component']/div[2]/div/div[3]/button")).click();
//		driver.findElement(By.xpath("//div[@id='send_card_component']/div/div[2]/button")).click();
	}
	
	@Test
	public void actionCTA() throws InterruptedException
	{
		login();
		driver.findElement(By.cssSelector("[data-id='0']")).click();
		driver.findElement(By.xpath("//a/img[@alt='Phone call icon']")).click();
		driver.findElement(By.xpath("//a/img[@alt='Mail icon']")).click();
		driver.findElement(By.xpath("//a/img[@alt='Navigatio icon']")).click();
	}
	
	

}

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;

public class TestSwageLabb {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webDriver.chrome.driver","\"C:\\Users\\msi-GF63\\AppData\\Local\\Google\\Chrome\\Application\\chrome_proxy.exe\"");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		String name="standard_user";
		String pass= "secret_sauce";

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(5000);

		int expectedITeam=6;
		
		List<WebElement>  mylist=driver.findElements(By.className("bts"));
		
		for(int i=0;i<mylist.size();i++)
		{
			mylist.get(i).click();
				
		}
		
		//
		 
		
		
		


		
	}

}

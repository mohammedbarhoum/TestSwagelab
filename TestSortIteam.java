import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSortIteam {
	

		 
		public WebDriver driver;
		
		@BeforeTest
		
		public void Login() {
			
			WebDriverManager.edgedriver().setup();
		
			driver= new EdgeDriver();
			
			
			
			
			
			driver.get("https://github.com/login");
			
			driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("mohammedbarhoum777@gmial.com");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("mohammed12345$");
			driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
			
		
}
	@Test(priority = 3 )
	public void sort_items_low_to_high() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		List<WebElement> thePricesList = driver.findElements(By.className("inventory_item_price"));
		List<Double> newEditedList = new ArrayList<>();
		for (int i = 0; i < thePricesList.size(); i++) {
			String price = thePricesList.get(i).getText();
			String editedPrice = price.replace("$", " ");
			double val = Double.parseDouble(editedPrice.trim());
			newEditedList.add(val);
		}
		for (int k = 0; k < newEditedList.size(); k++) {
			boolean checkProcess = newEditedList.get(0) < newEditedList.get(newEditedList.size() - 1);
			Assert.assertEquals(checkProcess, true);
		}
}

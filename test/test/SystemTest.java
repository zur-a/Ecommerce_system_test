package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemTest {

	private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hiiii\\Downloads\\driver\\chromedriver.exe");
		
		driver.get("http://www.ecommerce.com/admin/login");
		
		WebElement user = driver.findElement(By.name("login"));
		WebElement pass = driver.findElement(By.name("password"));
				
		user.sendKeys("admin");
		pass.sendKeys("admin");
		
		WebElement submit = driver.findElement(By.tagName("button"));
		
		submit.click();
	}
	
	@After
	public void finaliza() {
		driver.close();
	}

}

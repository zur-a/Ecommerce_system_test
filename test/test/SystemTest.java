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
	
	@Test
	public void deveCadastrarUsuario() {		
		driver.get("http://www.ecommerce.com/admin/users/create");
		
		WebElement nome = driver.findElement(By.name("desperson"));
		WebElement login = driver.findElement(By.name("deslogin"));
		WebElement phone = driver.findElement(By.name("nrphone"));
		WebElement email = driver.findElement(By.name("desemail"));
		WebElement password = driver.findElement(By.name("despassword"));
		
		nome.sendKeys("Gaius Iulius Caesar Octavianus Augustus");
		login.sendKeys("Augustus");
		phone.sendKeys("997788665");
		email.sendKeys("princepsCivitatis@roma.com");
		password.sendKeys("Roma");
		
		WebElement submit = driver.findElement(By.className("btn-success"));
		
		submit.click();
		
		assertTrue(driver.getPageSource().contains("Iulius"));
	}
	
	@After
	public void finaliza() {
		driver.close();
	}

}

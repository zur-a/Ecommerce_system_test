package padrao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void preencherForm(String name, String pass) {
		WebElement user = driver.findElement(By.name("login"));
		WebElement password = driver.findElement(By.name("password"));
				
		user.sendKeys(name);
		password.sendKeys(pass);
	}
}

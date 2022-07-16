package padrao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessa() {
		driver.get("http://www.ecommerce.com/admin/login");
	}
	
	public void preencheForm(String usuario, String senha) {
		WebElement user = driver.findElement(By.name("login"));
		WebElement pass = driver.findElement(By.name("password"));
				
		user.sendKeys(usuario);
		pass.sendKeys(senha);
	}
	
	public void submeteForm() {
		WebElement submit = driver.findElement(By.tagName("button"));
		
		submit.click();
	}
}

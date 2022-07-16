package padrao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessa() {
		driver.get("http://www.ecommerce.com/admin/users/create");
	}
	
	public void preencherForm(String name, String user, String fone, String mail, String pass) {
		WebElement nome = driver.findElement(By.name("desperson"));
		WebElement login = driver.findElement(By.name("deslogin"));
		WebElement phone = driver.findElement(By.name("nrphone"));
		WebElement email = driver.findElement(By.name("desemail"));
		WebElement password = driver.findElement(By.name("despassword"));
			
		nome.sendKeys(name);
		login.sendKeys(user);
		phone.sendKeys(fone);
		email.sendKeys(mail);
		password.sendKeys(pass);
	}
	
	public void submeterForm() {
		WebElement submit = driver.findElement(By.className("btn-success"));
		
		submit.click();
	}
	
	public boolean existeNaPagina(String search) {
		return driver.getPageSource().contains(search);
	}
}

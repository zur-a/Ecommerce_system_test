package padrao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersPage {
	
	private WebDriver driver;
	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessa() {
		driver.get("http://www.ecommerce.com/admin/users");
	}
	
	public void deletar() {
		WebElement delete = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[6]/a[3]"));
		delete.click();
			
		driver.switchTo().alert().accept();
	}
	
	public void alterar() {
		WebElement alter = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[6]/a[1]"));
		alter.click();
	}
	
	public void preencherForm(String name, String user, String fone, String mail) {
		WebElement nome = driver.findElement(By.name("desperson"));
		WebElement login = driver.findElement(By.name("deslogin"));
		WebElement phone = driver.findElement(By.name("nrphone"));
		WebElement email = driver.findElement(By.name("desemail"));
		WebElement admin = driver.findElement(By.name("inadmin"));
		
		nome.clear();
		login.clear();
		phone.clear();
		email.clear();
		
		nome.sendKeys(name);
		login.sendKeys(user);
		phone.sendKeys(fone);
		email.sendKeys(mail);
		admin.click();
	}
	
	public void submeterForm() {
		WebElement submit = driver.findElement(By.className("btn-primary"));
		
		submit.click();
	}
	
	public boolean existeNaPagina(String search) {
		return driver.getPageSource().contains(search);
	}

}

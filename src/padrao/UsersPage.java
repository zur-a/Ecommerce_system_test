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
	
	public boolean existeNaPagina(String search) {
		return driver.getPageSource().contains(search);
	}

}

package padrao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	
	private WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessa(String url) {
		driver.get(url);
	}
	
	public boolean existeNaPagina(String search) {
		return driver.getPageSource().contains(search);
	}
	
	public void submeterForm() {
		WebElement submit = driver.findElement(By.className("btn-primary"));
		
		submit.click();
	}
}

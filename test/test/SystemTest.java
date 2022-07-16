package test;

	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import padrao.LoginPage;
import padrao.RegisterPage;

public class SystemTest {

	private WebDriver driver;
	private LoginPage login;
	private RegisterPage register;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hiiii\\Downloads\\driver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.login = new LoginPage(driver);
		this.register = new RegisterPage(driver);
		
		login.acessa();
		login.preencheForm("admin", "admin");
		login.submeteForm();
	}
		
	@Test
	public void deveCadastrarUsuario() {		
		register.acessa();
			
		register.preencherForm(
				"Gaius Iulius Caesar Octavianus Augustus", 
				"Augustus", 
				"998877665", 
				"princepsCivitatis@roma.com", 
				"Roma"
				);
			
		register.submeterForm();
			
		assertTrue(register.existeNaPagina("Iulius"));
	}
		
	@Test
	public void deveDeletarUsuarioCadastrado() {
		driver.get("http://www.ecommerce.com/admin/users");
			
		WebElement delete = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[6]/a[3]"));
		delete.click();
			
		driver.switchTo().alert().accept();
		assertTrue(!driver.getPageSource().contains("Iulius"));
	}
		

	@After
	public void finaliza() {
		driver.close();
	}

}


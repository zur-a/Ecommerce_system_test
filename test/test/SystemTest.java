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
import padrao.UsersPage;

public class SystemTest {

	private WebDriver driver;
	private LoginPage login;
	private RegisterPage register;
	private UsersPage users;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hiiii\\Downloads\\driver\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.login = new LoginPage(driver);
		this.register = new RegisterPage(driver);
		this.users = new UsersPage(driver);
		
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
		users.acessa();
		users.deletar();
		
		assertTrue(!users.existeNaPagina("Iulius"));
	}
		

	@After
	public void finaliza() {
		driver.close();
	}

}


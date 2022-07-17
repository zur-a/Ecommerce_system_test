package test;

	import static org.junit.Assert.*;

	import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import padrao.LoginPage;
import padrao.Page;
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
		
		login.acessa("http://www.ecommerce.com/admin/login");
		login.preencherForm("admin", "admin");
		login.submeterForm();
	}
		
	@Test
	public void deveCadastrarUsuario() {		
		register.acessa("http://www.ecommerce.com/admin/users/create");
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
	public void deveAlterarUsuarioCadastrado() {
		users.acessa("http://www.ecommerce.com/admin/users");
		users.alterar();
		users.preencherForm(
				"Caio Julio Cesar Otaviano Augusto",
				"Octavianus",
				"998877663",
				"princepsImperator@roma.com"
				);
		users.submeterForm();
		
		assertTrue(users.existeNaPagina("Caio"));
	}
		
	@Test
	public void deveDeletarUsuarioCadastrado() {
		users.acessa("http://www.ecommerce.com/admin/users");
		users.deletar();
		
		assertTrue(!users.existeNaPagina("Caio"));
	}
	
	@After
	public void finaliza() {
		driver.close();
	}

}


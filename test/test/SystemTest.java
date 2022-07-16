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
	public void deveAlterarUsuarioCadastrado() {
		driver.get("http://www.ecommerce.com/admin/users");
		
		WebElement alter = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[6]/a[1]"));
		alter.click();
		
		WebElement nome = driver.findElement(By.name("desperson"));
		WebElement login = driver.findElement(By.name("deslogin"));
		WebElement phone = driver.findElement(By.name("nrphone"));
		WebElement email = driver.findElement(By.name("desemail"));
		WebElement admin = driver.findElement(By.name("inadmin"));
		
		nome.clear();
		login.clear();
		phone.clear();
		email.clear();
		
		nome.sendKeys("Caio Julio Cesar Otaviano Augusto");
		login.sendKeys("Octavianus");
		phone.sendKeys("998877664");
		email.sendKeys("princepsImperator@roma.com");
		admin.click();
		
		WebElement submit = driver.findElement(By.className("btn-primary"));
		
		submit.click();
		
		assertTrue(driver.getPageSource().contains("Caio"));
	}
		
	@Test
	public void deveDeletarUsuarioCadastrado() {
		users.acessa();
		users.deletar();
		
		assertTrue(!users.existeNaPagina("Caio"));
	}
	
		

	@After
	public void finaliza() {
		driver.close();
	}

}


package test;

	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

public class SystemTest {

	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hiiii\\Downloads\\driver\\chromedriver.exe");
		this.driver = driver;
		
		driver = new ChromeDriver();
		driver.get("http://www.ecommerce.com/admin/login");
		
		WebElement user = driver.findElement(By.name("login"));
		WebElement pass = driver.findElement(By.name("password"));
				
		user.sendKeys("admin");
		pass.sendKeys("admin");
		
		WebElement submit = driver.findElement(By.tagName("button"));
		
		submit.click();
	}
		
	@Test
	public void deveCadastrarUsuario() {		
		driver.get("http://www.ecommerce.com/admin/users/create");
			
		WebElement nome = driver.findElement(By.name("desperson"));
		WebElement login = driver.findElement(By.name("deslogin"));
		WebElement phone = driver.findElement(By.name("nrphone"));
		WebElement email = driver.findElement(By.name("desemail"));
		WebElement password = driver.findElement(By.name("despassword"));
			
		nome.sendKeys("Gaius Iulius Caesar Octavianus Augustus");
		login.sendKeys("Augustus");
		phone.sendKeys("997788665");
		email.sendKeys("princepsCivitatis@roma.com");
		password.sendKeys("Roma");
			
		WebElement submit2 = driver.findElement(By.className("btn-success"));
			
		submit2.click();
			
		assertTrue(driver.getPageSource().contains("Iulius"));
	}
		
	@Test
	public void deveDeletarUsuarioCadastrado() {
		driver.get("http://www.ecommerce.com/admin/users");
			
		WebElement delete = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/a[3]"));
		delete.click();
			
		driver.switchTo().alert().accept();
		assertTrue(!driver.getPageSource().contains("Iulius"));
	}
		

	@After
	public void finaliza() {
		driver.close();
	}

}


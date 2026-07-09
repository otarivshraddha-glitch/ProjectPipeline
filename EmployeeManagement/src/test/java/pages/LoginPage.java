

package pages;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	
	public class LoginPage 
	{

	    WebDriver driver;

	    public LoginPage(WebDriver driver) 
	    {
	        this.driver = driver;
	    }

	    public void login() {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.name("username")));

	        driver.findElement(By.name("username"))
	              .sendKeys("Admin");

	        driver.findElement(By.name("password"))
	              .sendKeys("admin123");

	        driver.findElement(By.xpath("//button[@type='submit']"))
	              .click();
	        
	        new WebDriverWait(driver, Duration.ofSeconds(20))
            .until(ExpectedConditions.urlContains("dashboard"));
	    }
	} 
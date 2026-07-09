

package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;

public class BaseClass 
{
  
	public static  WebDriver driver;
    //protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() 
    {

        driver.quit();
    }
}

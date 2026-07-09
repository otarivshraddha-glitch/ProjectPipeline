

package pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class PIMPage 
{

    WebDriver driver;
    

    public PIMPage(WebDriver driver)
    {
        this.driver = driver;
       
    }

    
    // Add Employee
     
    public void addEmployee(String firstName,
            String middleName,
            String lastName)
    {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("Current URL in Add Employee = "
                + driver.getCurrentUrl());

        // Click Add button
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Add']")))
                .click();

        System.out.println("After clicking Add");

        // Wait until Add Employee page opens
        wait.until(
                ExpectedConditions.urlContains("addEmployee"));

        System.out.println("URL after Add Click = "
                + driver.getCurrentUrl());

        // Wait for First Name field
        WebElement firstNameField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("firstName")));

        firstNameField.sendKeys(firstName);

        driver.findElement(By.name("middleName"))
                .sendKeys(middleName);

        driver.findElement(By.name("lastName"))
                .sendKeys(lastName);

        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Clicked Save");

        wait.until(
                ExpectedConditions.urlContains("viewPersonalDetails"));

        System.out.println("Employee Added Successfully");

        System.out.println("URL After Save = "
                + driver.getCurrentUrl());
    }


    
    // Search Employee
    
    public boolean searchEmployee(String employeeName) throws InterruptedException
    {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement searchBox =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//input[@placeholder='Type for hints...']")));

        searchBox.clear();
        searchBox.sendKeys(employeeName);

        
        driver.findElement(
                By.xpath("//button[normalize-space()='Search']"))
                .click();

        Thread.sleep(3000); // wait to see results

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,700)");

       
        
        Thread.sleep(5000); // keep screen visible

        System.out.println("Employee Searched Successfully");
        System.out.println("Employee Name : " + employeeName);

        return true;
    }
    
    // Edit Employee

    public void editEmployee(String employeeName,
            String newLastName) throws InterruptedException
    {
        searchEmployee(employeeName);

        driver.findElement(
                By.xpath("//i[contains(@class,'bi-pencil-fill')]"))
                .click();

        System.out.println("URL after Edit Click = "
                + driver.getCurrentUrl());

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement lastName =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("lastName")));

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.className("oxd-form-loader")));

        System.out.println("Old Last Name = "
                + lastName.getAttribute("value"));

        lastName.click();

        lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"));

        lastName.sendKeys(Keys.DELETE);

        lastName.sendKeys(newLastName);

        System.out.println("New Last Name = "
                + lastName.getAttribute("value"));

        Thread.sleep(3000);

        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();
    }
    	
    	
    	
    	
    	
    	

   
    // Delete Employee
     
// Delete Employee
public void deleteEmployee(String employeeName) throws InterruptedException
{
    // Search employee first
    searchEmployee(employeeName);

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(20));

    // Wait until search results are displayed
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='row']")));

    // Click Delete icon
    WebElement deleteIcon =
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//i[contains(@class,'bi-trash')]")));

    deleteIcon.click();

    System.out.println("Delete icon clicked");

    // Wait for confirmation popup
    WebElement yesDelete =
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[normalize-space()='Yes, Delete']")));

    yesDelete.click();

    System.out.println("Employee deleted successfully");

    Thread.sleep(3000);
}
    
}

    
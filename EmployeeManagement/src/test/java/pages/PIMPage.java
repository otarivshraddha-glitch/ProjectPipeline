package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

    WebDriver driver;
    WebDriverWait wait;

    public PIMPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators

    By addButton = By.xpath("//button[normalize-space()='Add']");

    By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");

    By saveButton = By.xpath("//button[@type='submit']");

    By employeeList =
            By.xpath("//a[text()='Employee List']");

    By searchBox =
            By.xpath("//input[@placeholder='Type for hints...']");

    By searchButton =
            By.xpath("//button[normalize-space()='Search']");
    
    public void addEmployee(String fname,
            String mname,
            String lname) throws InterruptedException
{

wait.until(
ExpectedConditions.elementToBeClickable(addButton))
.click();

wait.until(
ExpectedConditions.visibilityOfElementLocated(firstName));

driver.findElement(firstName).sendKeys(fname);

driver.findElement(middleName).sendKeys(mname);

driver.findElement(lastName).sendKeys(lname);

driver.findElement(saveButton).click();

wait.until(
ExpectedConditions.urlContains("viewPersonalDetails"));

System.out.println("Employee Added Successfully");

Thread.sleep(5000); // Wait for 5 seconds

}
    
    public void openEmployeeList()
    {

        wait.until(
                ExpectedConditions.elementToBeClickable(employeeList))
                .click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox));

        System.out.println("Employee List Opened");

    }
    
    public boolean searchEmployee(String employeeName) throws InterruptedException
    {

        openEmployeeList();

        WebElement search =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(searchBox));

        search.clear();

        search.sendKeys(employeeName);

        driver.findElement(searchButton).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-body']")));

        System.out.println("Employee Found : " + employeeName);
        
        Thread.sleep(5000); // Wait for 5 seconds

        return true;

    }
    
 // Edit Employee

    public void editEmployee(String employeeName, String newLastName) throws InterruptedException
    {
        searchEmployee(employeeName);

        By editIcon = By.xpath("(//i[contains(@class,'bi-pencil-fill')])[1]");

        wait.until(ExpectedConditions.elementToBeClickable(editIcon));

        driver.findElement(editIcon).click();

        // Wait until loader disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("oxd-form-loader")));

        WebElement lastNameField =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.name("lastName")));

        lastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        lastNameField.sendKeys(Keys.DELETE);
        lastNameField.sendKeys(newLastName);

        driver.findElement(saveButton).click();

        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

        System.out.println("Employee Edited Successfully");
        
        Thread.sleep(5000); // Wait for 5 seconds
    }
    
 // Delete Employee

    public void deleteEmployee(String employeeName) throws InterruptedException
    {
        searchEmployee(employeeName);

        // Wait until search results appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']")));

        By deleteButton =
                By.xpath("(//button[i[contains(@class,'bi-trash')]])[1]");

        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

        driver.findElement(deleteButton).click();

        By yesDelete =
                By.xpath("//button[normalize-space()='Yes, Delete']");

        wait.until(ExpectedConditions.elementToBeClickable(yesDelete));

        driver.findElement(yesDelete).click();

        System.out.println("Employee Deleted Successfully");
        
        Thread.sleep(5000); // Wait for 5 seconds
    }
}


package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.xpath("//button[@type='submit']");

    // Login Method
    public void login() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));

        driver.findElement(txtUsername).sendKeys("Admin");

        driver.findElement(txtPassword).sendKeys("admin123");

        driver.findElement(btnLogin).click();

        wait.until(ExpectedConditions.urlContains("dashboard"));

        System.out.println("Login Successful");
        System.out.println("Current URL : " + driver.getCurrentUrl());
    }
} 
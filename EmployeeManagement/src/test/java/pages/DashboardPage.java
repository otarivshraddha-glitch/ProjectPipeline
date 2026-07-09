

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locator
    By pimMenu = By.xpath("//span[text()='PIM']");

    // Click PIM Menu
    public void clickPIM() {

        wait.until(ExpectedConditions.elementToBeClickable(pimMenu));

        driver.findElement(pimMenu).click();

        wait.until(ExpectedConditions.urlContains("viewEmployeeList"));

        System.out.println("PIM Menu Clicked Successfully");
        System.out.println("Current URL : " + driver.getCurrentUrl());
    }
}
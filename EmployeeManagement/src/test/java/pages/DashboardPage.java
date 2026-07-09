

package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage
{

    WebDriver driver;

    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickPIM() 
    {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement pimMenu =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//a[contains(@href,'viewPimModule')]")
                        ));

        pimMenu.click();

        System.out.println("After PIM Click URL = "
                + driver.getCurrentUrl());
    }
}

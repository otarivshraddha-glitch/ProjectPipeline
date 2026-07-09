package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class EmployeeLifeCycleTest extends BaseClass {

    LoginPage login;
    DashboardPage dashboard;
    PIMPage pim;

    String firstName = "Rahul";
    String middleName = "K";
    String lastName = "Patil";
    String updatedLastName = "Sharma";

    @BeforeClass
    public void initialize() {

        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        pim = new PIMPage(driver);

        login.login();
        dashboard.clickPIM();
    }

    @Test(priority = 1)
    public void addEmployee() throws InterruptedException {

        pim.addEmployee(firstName, middleName, lastName);
    }

    @Test(priority = 2)
    public void searchEmployee() throws InterruptedException {

        Assert.assertTrue(
                pim.searchEmployee(firstName + " " + middleName + " " + lastName));
    }

    @Test(priority = 3)
    public void editEmployee() throws InterruptedException {

        pim.editEmployee(
                firstName + " " + middleName + " " + lastName,
                updatedLastName);
    }

    @Test(priority = 4)
    public void deleteEmployee() throws InterruptedException {

        pim.deleteEmployee(
                firstName + " " + middleName + " " + updatedLastName);
    }
}
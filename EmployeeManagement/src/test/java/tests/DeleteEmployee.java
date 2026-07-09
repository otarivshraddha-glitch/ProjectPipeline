package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class DeleteEmployee extends BaseClass
{

    @Test
    public void verifyDeleteEmployee() throws InterruptedException 
    {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        PIMPage pim = new PIMPage(driver);

        // Login
        login.login();

        // Click PIM
        dashboard.clickPIM();

        System.out.println("PIM page opened");

        // Delete Employee
        pim.deleteEmployee("Rahul K Sharma");
    }
}

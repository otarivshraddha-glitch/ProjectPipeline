

package tests;


import org.testng.annotations.Test;

import base.BaseClass;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class EditEmployee extends BaseClass
{

    @Test
    public void verifyEditEmployee() throws InterruptedException
    {

        LoginPage login = new LoginPage(driver);

        DashboardPage dashboard = new DashboardPage(driver);

        PIMPage pim = new PIMPage(driver);

        login.login();

        dashboard.clickPIM();

        pim.editEmployee("Rahul K Patil","Sharma");
                
                
    }
}


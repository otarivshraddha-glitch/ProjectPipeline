

package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class SearchEmployee extends BaseClass
{

   
    @Test
    public void verifySearchEmployee() throws InterruptedException
    {
        LoginPage login = new LoginPage(driver);

        DashboardPage dashboard = new DashboardPage(driver);

        PIMPage pim = new PIMPage(driver);

        login.login();

        dashboard.clickPIM();

        Assert.assertTrue(
                pim.searchEmployee("Rahul K Patil"));
        
        
    }
}


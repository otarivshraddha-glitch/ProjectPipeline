

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

public class EmployeeLifeCycle extends BaseClass 
{

    LoginPage login;
    DashboardPage dashboard;
    PIMPage pim;

    // Employee name shared by all tests
    String employeeName = "Emp" + System.currentTimeMillis();

    @Test(priority = 1)
    public void addEmployee() throws InterruptedException 
    
    {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        pim = new PIMPage(driver);

        login.login();
        dashboard.clickPIM();

        pim.addEmployee("Rahul", "K", "Patil");

        System.out.println("Employee Added Successfully");
        

        Thread.sleep(5000); 
    }

    @Test(priority = 2)
    public void searchEmployee() throws InterruptedException
    
    {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        pim = new PIMPage(driver);

        login.login();
        dashboard.clickPIM();

        Assert.assertTrue(pim.searchEmployee("Rahul K Patil"));

        System.out.println("Employee Searched Successfully");
        
        Thread.sleep(5000); 
    }

    @Test(priority = 3)
    public void editEmployee() throws InterruptedException
    {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        pim = new PIMPage(driver);

       // login.login();
        dashboard.clickPIM();

        pim.editEmployee("Rahul K Patil","Sharma");

        System.out.println("Employee Edited Successfully");
        
        Thread.sleep(5000); 
    }

    @Test(priority = 4)
    public void deleteEmployee() throws InterruptedException
    {
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        pim = new PIMPage(driver);

        //login.login();
        dashboard.clickPIM();

        pim.deleteEmployee("Rahul K Sharma");

        System.out.println("Employee Deleted Successfully");
        
        Thread.sleep(5000); 
    }
}
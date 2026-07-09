
package tests;


import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

import pages.DashboardPage;
import pages.PIMPage;

public class AddEmployee extends BaseClass 
{

    @Test
    public void verifyAddEmployee()
{    
    	
    	

    	    LoginPage login = new LoginPage(driver);
    	    DashboardPage dashboard = new DashboardPage(driver);
    	    PIMPage pim = new PIMPage(driver);

    	    login.login();   // <-- THIS MUST BE PRESENT

    	    System.out.println("URL after login = " + driver.getCurrentUrl());

    	    dashboard.clickPIM();

    	    pim.addEmployee("Rahul", "K", "Patil");
    	    
    	    
    	}

       /* LoginPage login = new LoginPage(driver);

        DashboardPage dashboard = new DashboardPage(driver);
                

        PIMPage pim = new PIMPage(driver);
                
      //  login.login();

        System.out.println("URL after login = "
                + driver.getCurrentUrl());

        dashboard.clickPIM();

        pim.addEmployee("Rahul", "K", "Patil");*/
               
                        
    }



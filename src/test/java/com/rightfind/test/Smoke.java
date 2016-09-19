package com.rightfind.test;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.WebDriverController;
import utils.WebDriverListener;

@Listeners(WebDriverListener.class)
public class Smoke extends WebDriverController{
	
	//URLS
	private String urlDigitalLibrary = "admin#local-library";
	private String urlAdvancedSearch = "/#advanced-search/journal";
	
	//LOGIN FORM
	private static final By FIELD_LOGIN = By.name("username");
	private static final By FIELD_PASSWORD = By.name("password");
	
    @BeforeTest
    public void login(){
        openUrlInApp(urlDigitalLibrary);
        //windowSetSize(1600,900);
        addCookie("RS.LOCATION", "2519ca7b-4a4c-4f9d-908f-c2c755598618");
		type(FIELD_LOGIN, "pivaniushyn@copyright.com");
		type(FIELD_PASSWORD, "123456");
		submit(FIELD_PASSWORD);
		waitForPageLoaded();
        setItemInSessionStorage("isTooltipWasClosed", "yes");
        addCookie("RS.LOCATION", "2519ca7b-4a4c-4f9d-908f-c2c755598618");
    }
    
    @Test
    public void testAdvancedSearch(){
        openUrlInApp(urlAdvancedSearch);
        makeScreenshot();
    }

}

package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import constants.UserConstants;
import resources.User;
import resources.WebDriverFactory;

public class BaseTest 
{
    WebDriver Driver;
    
    User TestUser;

    @Before
    public void SetupBeforeEveryTest()
    {
        Driver = WebDriverFactory.GetChromeDriver();
        TestUser = new User(UserConstants.DefaultFirstName, UserConstants.DefaultLastName);
    }	
    
    @After
    public void SetupAfterEveryTest()
    {
		Driver.close();
		Driver.quit();		
    }
}
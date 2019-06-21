package tests;

import static org.junit.Assert.*;
import pageactions.Sprint1PageActions;
import pages.BasePage;
import pages.Sprint1Page;
import org.junit.Test;
import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;

public class Sprint1Tests extends BaseTest
{	
	@Test
	public void Sprint1Test() 
	{
		Sprint1PageActions sprint1PageActions = new Sprint1PageActions(Driver);
		Sprint1Page sprint1Page = new Sprint1Page(Driver);
		GotoSampleApplicationPage(sprint1Page, PageConstants.Sprint1Url, PageConstants.Sprint1Title);
		sprint1PageActions.FillOutFormAndSubmit(UserConstants.DefaultFirstName);
		ValidatePageTitle(sprint1Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);
	}

	private void GotoSampleApplicationPage(BasePage basePage, String url, String title) 
	{
		basePage.goTo(url);
		ValidatePageTitle(basePage, ErrorConstants.SampleApplicationPageError, title);
	}

	private void ValidatePageTitle(BasePage basePage, String error, String title) 
	{
		System.out.println(Driver.getTitle());        
        assertTrue(error, basePage.IsLoaded(title));
	}
}
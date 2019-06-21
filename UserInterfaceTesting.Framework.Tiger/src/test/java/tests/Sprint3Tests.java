package tests;

import static org.junit.Assert.*;
import pageactions.Sprint3PageActions;
import pages.BasePage;
import pages.Sprint3Page;
import resources.Gender;
import org.junit.Test;
import constants.ErrorConstants;
import constants.PageConstants;

public class Sprint3Tests extends BaseTest
{
	@Test
	public void Sprint3TestFemale() throws Exception
	{	
		Sprint3PageActions sprint3PageActions = new Sprint3PageActions(Driver);
		Sprint3Page sprint3Page = new Sprint3Page(Driver);
		GotoSampleApplicationPage(sprint3Page, PageConstants.Sprint3Url, PageConstants.Sprint3Title);	
		SetGenderType(Gender.Female);
		sprint3PageActions.FillOutFormWithRadioButtonAndSubmit(TestUser);
		ValidatePageTitle(sprint3Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
	}
	
	@Test
	public void Sprint3TestOther() throws Exception
	{	
		Sprint3PageActions sprint3PageActions = new Sprint3PageActions(Driver);
		Sprint3Page sprint3Page = new Sprint3Page(Driver);
		GotoSampleApplicationPage(sprint3Page, PageConstants.Sprint3Url, PageConstants.Sprint3Title);	
		SetGenderType(Gender.Other);
		sprint3PageActions.FillOutFormWithRadioButtonAndSubmit(TestUser);
		ValidatePageTitle(sprint3Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
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
	
	private void SetGenderType(Gender genderType) 
	{ 
		TestUser.setGenderType(genderType);
	}
}
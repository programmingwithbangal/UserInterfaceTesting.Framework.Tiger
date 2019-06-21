package tests;

import static org.junit.Assert.*;
import pageactions.Sprint5Page2Actions;
import pageactions.Sprint5PageActions;
import pages.BasePage;
import pages.Sprint5Page;
import resources.Animal;
import resources.Gender;
import resources.User;
import org.junit.Test;
import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;

public class Sprint5Tests extends BaseTest
{
	@Test
	public void Sprint5TestFemale() throws Exception
	{	
		Sprint5PageActions sprint5PageActions = new Sprint5PageActions(Driver);
		Sprint5Page sprint5Page = new Sprint5Page(Driver);
		GotoSampleApplicationPage(sprint5Page, PageConstants.Sprint5Url, PageConstants.Sprint5Title);	
		SetGenderType(Gender.Female);
		sprint5PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Female);
        sprint5PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint5Page, ErrorConstants.SampleApplicationPage2Error, PageConstants.FormPage2Title);		
		Sprint5Page2Actions sprint5Page2Actions = new Sprint5Page2Actions(Driver);
		sprint5Page2Actions.FillOutRadioButtonAndSubmit(Animal.Crocodiles);
		ValidatePageTitle(sprint5Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);			
	}
	
	@Test
	public void Sprint5TestOther() throws Exception
	{	
		Sprint5PageActions sprint5PageActions = new Sprint5PageActions(Driver);
		Sprint5Page sprint5Page = new Sprint5Page(Driver);
		GotoSampleApplicationPage(sprint5Page, PageConstants.Sprint5Url, PageConstants.Sprint5Title);	
		SetGenderType(Gender.Other);
		sprint5PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Female);
        sprint5PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint5Page, ErrorConstants.SampleApplicationPage2Error, PageConstants.FormPage2Title);		
		Sprint5Page2Actions sprint5Page2Actions = new Sprint5Page2Actions(Driver);
		sprint5Page2Actions.FillOutRadioButtonAndSubmit(Animal.Bunnies);
		ValidatePageTitle(sprint5Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);			
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
package com.timesofindia.defs;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.util.Reporter;
import com.timesofindia.pages.HomePage;
import com.timesofindia.utils.CommonSteps;

@QAFTestStepProvider
public class HomePageDefs {
	HomePage homePage;

	public HomePageDefs() {
		homePage = new HomePage();
	}

	@QAFTestStep(description = "Decline notifications")
	public void declineNotifications() {

		homePage.declineNotification();
	}

	@QAFTestStep(description = "Get List of top-stories and print")
	public int getTopStoriesList() {

		int listSize = homePage.getListOfTopStories();
		return listSize;
	}

	@QAFTestStep(description = "Entertainment section verification")
	public void verifyEntertainmentSection() {

		homePage.verifyPageOpen();
		homePage.verifyEntertainmentSectionOnPage();
	}

	@QAFTestStep(description = "Extract entertainment section's news")
	public void getEntertainmentNewsList() {

		homePage.getListOfEntertainmentNews();
	}

	@QAFTestStep(description = "Verify total number of image displayed")
	public void verifyTotalNumberOfImage() {

		homePage.verifyThreeImageInDisplayList();
		Reporter.log("Verifying after clicking on Next button");
		CommonSteps.clickUsingJS(homePage.getEntNextButton());
		// homePage.getEntNextButton().click();
		QAFTestBase.pause(2000);
		homePage.verifyThreeImageInDisplayList();
		Reporter.log("Verifying after clicking on Back button");
		CommonSteps.clickUsingJS(homePage.getEntBackButton());
		// homePage.getEntBackButton().click();
		QAFTestBase.pause(2000);
		homePage.verifyThreeImageInDisplayList();
	}

	@QAFTestStep(description = "Reading sub news")
	public void readSubNews() {

		homePage.readSubNews();
		homePage.readSubNewsForLang("Hindi");
		homePage.readSubNewsForLang("English");
		homePage.readSubNewsForLang("Tamil");
		homePage.readSubNewsForLang("Telugu");
		homePage.readSubNewsForLang("Marathi");
		homePage.readSubNewsForLang("Gujarati");

	}

	@QAFTestStep(description = "Click on {0} and verify page")
	public void clickOnAnyLangAndVerifyPage(String lang) {

		homePage.clickOnLanguageAndValidatePage(lang);
	}

	@QAFTestStep(description = "Display Metro Cities")
	public void displayMetroCitiesList() {

		homePage.displayMetroCitiesList();
	}
	@QAFTestStep(description = "Click On {0}")
	public void cliclOnCityTitle(String cityName) {

		homePage.clickOnCity(cityName);
	}
	
}

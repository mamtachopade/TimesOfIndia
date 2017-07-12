package com.timesofindia.defs;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.timesofindia.pages.CityNewsPage;

public class CityNewsDefs {
	CityNewsPage cityNewsPage;

	public CityNewsDefs() {
		cityNewsPage = new CityNewsPage();
	}

	@QAFTestStep(description = "Verify trending now section")
	public void verifyPageTitle() {
		cityNewsPage.verifyPageTitle();
	}

	@QAFTestStep(description = "Extracting latest news titles")
	public void getLatestNewsTexts() {
		cityNewsPage.verifyLatestNewsTitles();
	}

	@QAFTestStep(description = "Extracting news from last 1 day")
	public void validateNewsFromLastDay() {
		cityNewsPage.validateNewsFromLastDay();
	}

	@QAFTestStep(description = "Verifying Most popular Section ")
	public void verifyMostPopularSection() {
		cityNewsPage.verifyMostPopularSection();
	}

	@QAFTestStep(description = "Switching to active tab")
	public void switchToActiveTab() {
		cityNewsPage.switchToActiveTab();
	}

	@QAFTestStep(description = "Navigating to active tab")
	public void navigateBackToMostPopTab() {
		cityNewsPage.navigateToCityNewsTab();
	}

	@QAFTestStep(description = "Verifying Shared tab")
	public void verifySharedTab() {
		cityNewsPage.verifySharedTab();
	}

	@QAFTestStep(description = "click on {0}-->{1} inner tab and click on most popular link")
	public void selectPopularLinksFromInnerTab(String mainTab, String subTabName) {
		cityNewsPage.selectPopularLinksFromInnerTab(mainTab,subTabName);
	}
	
	@QAFTestStep(description = "Read news from {0} tab and {1} subtab")
	public void readNewsFromInnerTab(String mainTab, String subTabName) {
		cityNewsPage.readNewsFromInnerTab(mainTab, subTabName);
	}

}

package com.timesofindia.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.timesofindia.defs.CityNewsDefs;
import com.timesofindia.defs.DetailsNewsDefs;
import com.timesofindia.defs.HindiNewsDefs;
import com.timesofindia.defs.HomePageDefs;
import com.timesofindia.defs.MostPopularDefs;
import com.timesofindia.pages.HomePage;
import com.timesofindia.utils.CommonSteps;

public class ToiTest extends WebDriverTestCase {

	HomePageDefs homePage;
	DetailsNewsDefs detailedNews;
	HindiNewsDefs hindiNews;
	CityNewsDefs cityNews;
	MostPopularDefs mostPopular;
	HomePage testSample;

	CommonSteps common;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		testSample = new HomePage();
		homePage = new HomePageDefs();
		detailedNews = new DetailsNewsDefs();
		cityNews = new CityNewsDefs();
		hindiNews = new HindiNewsDefs();
		mostPopular = new MostPopularDefs();
		common = new CommonSteps();
		testSample.launchPage(null);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		new WebDriverTestBase().tearDown();
	}

	// @Test(description = "Times Of India Page verification", groups =
	// "TOI_Assignemnt_1")
	public void toiPageVerification() {

		homePage.declineNotifications();
		homePage.getTopStoriesList();
		detailedNews.verifyNewsTitle();

	}

	// @Test(description = "Times Of India Entertainment", groups =
	// "TOI_Assignemnt_2")
	public void toiPageVerificationEntertainment() {

		homePage.declineNotifications();
		homePage.verifyEntertainmentSection();
		homePage.getEntertainmentNewsList();
		homePage.verifyTotalNumberOfImage();
		CommonSteps.mouseHoverToElement(testSample.getEntertainmentHeaderText());
		QAFTestBase.pause(5000);
		homePage.readSubNews();
		homePage.clickOnAnyLangAndVerifyPage("Hindi");
		hindiNews.getListOfTrendingNow();
		hindiNews.verifyNewsImage();

	}

	@Test(description = "Times of India City", groups = "TOI_Assignemnt_3")
	public void toiVerificationOfCityOption() {
		homePage.declineNotifications();
		homePage.displayMetroCitiesList();
		homePage.cliclOnCityTitle("Pune");
		cityNews.verifyPageTitle();
		cityNews.getLatestNewsTexts();
		cityNews.validateNewsFromLastDay();
		cityNews.verifyMostPopularSection();
		cityNews.switchToActiveTab();
		mostPopular.verifyPageTitle("Most Commented");
		mostPopular.verifyAnyTimeTab();
		mostPopular.readNewsFromSpecificTime("LAST 24 HRS");
		cityNews.navigateBackToMostPopTab();
		cityNews.verifySharedTab();
		cityNews.switchToActiveTab();
		mostPopular.verifyPageTitle("Most Shared");
		mostPopular.verifyAnyTimeTab();
		mostPopular.readNewsFromSpecificTime("PAST 4 DAYS");
		cityNews.navigateBackToMostPopTab();
		cityNews.readNewsFromInnerTab("READ", "ENTIRE WEBSITE");
		cityNews.selectPopularLinksFromInnerTab("COMMENTED","ENTIRE WEBSITE");
		cityNews.switchToActiveTab();
		mostPopular.verifyAnyTimeTab();
		mostPopular.readNewsFromSpecificTime("PAST 4 DAYS");

	}

}

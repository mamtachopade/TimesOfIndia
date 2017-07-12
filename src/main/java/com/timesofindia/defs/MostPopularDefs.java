package com.timesofindia.defs;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.timesofindia.pages.MostPopularPage;

public class MostPopularDefs {
	MostPopularPage mostPopularPage;

	public MostPopularDefs() {
		mostPopularPage = new MostPopularPage();
	}

	@QAFTestStep(description = "Verify trending now section")
	public void verifyPageTitle(String tabName) {
		mostPopularPage.verifyPageTitle(tabName);
	}

	@QAFTestStep(description = "VerifyAnytime Tab is selected")
	public void verifyAnyTimeTab() {
		mostPopularPage.verifyAnyTimeTab();
	}

	@QAFTestStep(description = "Click on {0} and verify news")
	public void readNewsFromSpecificTime(String time) {
		mostPopularPage.clickOnTimeAndReadNews(time);
	}

}

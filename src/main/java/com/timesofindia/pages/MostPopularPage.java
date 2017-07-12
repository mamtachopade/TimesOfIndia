package com.timesofindia.pages;

import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class MostPopularPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "most.popular.anytime.text")
	public QAFWebElement anytimeText;

	@FindBy(locator = "most.poppular.recent.news.title")
	public QAFWebElement recentNewsTitle;

	@FindBy(locator = "most.commented.text")
	public QAFWebElement mostCommentedText;

	@FindBy(locator = "most.commented.timelist")
	public List<QAFWebElement> newsTimeList;

	@FindBy(locator = "most.commented.newslist")
	public List<QAFWebElement> newsList;

	@FindBy(locator = "most.commented.news.desclist")
	public List<QAFWebElement> newsDescList;

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

	public QAFWebElement getAnytimeText() {
		return anytimeText;
	}

	public QAFWebElement getRecentNewsTitle() {
		return recentNewsTitle;
	}

	public QAFWebElement getMostCommentedText() {
		return mostCommentedText;
	}

	public List<QAFWebElement> getNewsTimeList() {
		return newsTimeList;
	}

	public List<QAFWebElement> getNewsList() {
		return newsList;
	}

	public List<QAFWebElement> getNewsDescList() {
		return newsDescList;
	}

	public void verifyPageTitle(String tabName) {
		
		// Reporter.log(getMostCommentedText().getText());
		Validator.verifyThat("verifying Most popular Page Title", driver.getTitle(),
				Matchers.containsString(tabName));
	}

	public void verifyAnyTimeTab() {
		if (getAnytimeText().getAttribute("class").contains("active"))
			Reporter.log("Anytime Tab is Active By default");

	}

	public void clickOnTimeAndReadNews(String time) {

		for (QAFWebElement element : getNewsTimeList()) {
			if (element.getText().contains(time)) {
				element.click();
				Reporter.log("Clicked on " + time);
				break;
			}
		}

		QAFTestBase.pause(4000);
		getNewsList().get(0).waitForVisible(5000);
		Reporter.log(" " + getNewsDescList().size());
		for (int i = 0; i < 10; i++) {
			
			Reporter.log("News title is : " + getNewsList().get(i).getText() + "And News desc : "
					+ getNewsDescList().get(i).getText());
		}

	}

}

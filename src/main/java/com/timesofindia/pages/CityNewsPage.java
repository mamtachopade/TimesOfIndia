package com.timesofindia.pages;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.timesofindia.utils.CommonSteps;

public class CityNewsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "city.latest.news.title")
	public List<QAFWebElement> latestNewsTitle;

	@FindBy(locator = "city.latest.news.time.list")
	public List<QAFWebElement> latestNewsTitleTime;

	@FindBy(locator = "most.popular.tab.list")
	public List<QAFWebElement> mostPopularLabList;

	@FindBy(locator = "most.popular.inner.tab.list")
	public List<QAFWebElement> mostPopularInnerTabList;

	@FindBy(locator = "read.news.list")
	public List<QAFWebElement> readNewsList;

	@FindBy(locator = "most.popular.link")
	public QAFExtendedWebElement mostPopularLink;

	public List<QAFWebElement> getLatestNewsTitle() {
		return latestNewsTitle;
	}

	public List<QAFWebElement> getLatestNewsTitleTime() {
		return latestNewsTitleTime;
	}

	public List<QAFWebElement> getMostPopularLabList() {
		return mostPopularLabList;
	}

	public List<QAFWebElement> getMostPopularInnerTabList() {
		return mostPopularInnerTabList;
	}

	public List<QAFWebElement> getReadNewsList() {
		return readNewsList;
	}

	public QAFExtendedWebElement getMostPopularLink() {
		return mostPopularLink;
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

	public void verifyPageTitle() {

		Validator.verifyThat("verifying Pune News Page", new WebDriverTestBase().getDriver().getTitle(),
				Matchers.containsString("Pune"));
		Reporter.log("User is on pune news Pgae ", MessageTypes.Info);

	}

	public void verifyLatestNewsTitles() {
		for (int i = 0; i < getLatestNewsTitle().size(); i++) {
			Reporter.log(getLatestNewsTitle().get(i).getText() + " and time stamp is : "
					+ getLatestNewsTitleTime().get(i).getText());
		}
	}

	public void validateNewsFromLastDay() {
		Reporter.log("News displayed within last 1 day");
		for (int i = 0; i < getLatestNewsTitleTime().size(); i++) {

			if (getLatestNewsTitleTime().get(i).getText().contains("HOUR")
					|| getLatestNewsTitleTime().get(i).getText().contains("1 DAY")) {

				Reporter.log(getLatestNewsTitle().get(i).getText());
			}
		}
	}

	public void verifyMostPopularSection() {
		for (int i = 0; i < getMostPopularLabList().size(); i++) {
			if (getMostPopularLabList().get(i).getAttribute("class").contains("active"))
				Validator.verifyThat("verifying By Default selected section", getMostPopularLabList().get(i).getText(),
						Matchers.containsString("READ"));
		}
		for (int i = 0; i < getMostPopularInnerTabList().size(); i++) {
			if (getMostPopularInnerTabList().get(i).getAttribute("class").contains("active"))
				Validator.verifyThat("verifying By Default selected section",
						getMostPopularInnerTabList().get(i).getText(), Matchers.containsString("IN THIS SECTION"));
		}
		Reporter.log("News List From Read And In this Section");
		for (QAFWebElement news : getReadNewsList()) {

			Reporter.log(news.getText());
		}
		for (int i = 0; i < getMostPopularLabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains("COMMENTED"))
				CommonSteps.clickUsingJS(getMostPopularLabList().get(i));

		}
		CommonSteps.clickUsingJS(getMostPopularLink());

	}

	public void switchToActiveTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		MostPopularPage popularpage = new MostPopularPage();
		popularpage.getAnytimeText().waitForPresent(10000);
	}

	public void navigateToCityNewsTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		QAFTestBase.pause(4000);
	}

	public void verifySharedTab() {
		QAFTestBase.pause(2000);

		for (int i = 0; i < getMostPopularLabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains("SHARED")) {
				CommonSteps.clickUsingJS(getMostPopularLabList().get(i));
				break;
			}
		}
		CommonSteps.scrollToElement(driver.findElement(By.xpath("//div[@class='most-popular-wrapper']")));
		getMostPopularLink().click();
	}

	public void selectPopularLinksFromInnerTab(String mainTab, String subTabName) {

		for (int i = 0; i < getMostPopularLabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains(mainTab)) {
				CommonSteps.clickUsingJS(getMostPopularLabList().get(i));
				break;
			}
		}

		for (int i = 0; i < getMostPopularInnerTabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains(subTabName)) {
				CommonSteps.clickUsingJS(getMostPopularInnerTabList().get(i));
				break;
			}
		}

		CommonSteps.scrollToElement(driver.findElement(By.xpath("//div[@class='most-popular-wrapper']")));
		getMostPopularLink().click();
	}

	public void readNewsFromInnerTab(String mainTab, String subTabName) {

		for (int i = 0; i < getMostPopularLabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains(mainTab)) {
				CommonSteps.clickUsingJS(getMostPopularLabList().get(i));
				break;
			}
		}

		for (int i = 0; i < getMostPopularInnerTabList().size(); i++) {
			if (getMostPopularLabList().get(i).getText().contains(subTabName)) {
				CommonSteps.clickUsingJS(getMostPopularInnerTabList().get(i));
				break;
			}
		}

		QAFTestBase.pause(2000);

		for (QAFWebElement news : getReadNewsList()) {
			Reporter.log(news.getText());
		}
	}
}

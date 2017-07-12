package com.timesofindia.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CommonSteps {

	public static void navigateBack() {

		new WebDriverTestBase().getDriver().navigate().back();
	}

	public static void clickUsingJS(QAFWebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) new WebDriverTestBase().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public static void mouseHoverToElement(QAFWebElement element) {

		Actions action = new Actions(new WebDriverTestBase().getDriver());
		action.moveToElement(element).perform();
	}

	public static QAFWebElement getCityByText(String cityName) {
		QAFExtendedWebElement city = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("toi.city.pune.text.title"), cityName));

		return city;
	}

	public static void scrollToElement(QAFExtendedWebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) new WebDriverTestBase().getDriver();
		executor.executeScript("arguments[0].scrollIntoView();", element);

	}

}

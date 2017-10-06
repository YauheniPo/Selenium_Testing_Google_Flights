package a1qa.framework.entity;

import static a1qa.framework.utils.ConstantValue.*;
import static org.testng.Assert.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import a1qa.framework.browser_manager.BrowserManager;
import a1qa.framework.elements.Button;
import a1qa.framework.elements.Combobox;
import a1qa.framework.elements.Label;
import a1qa.framework.elements.TextBox;
import a1qa.framework.test.BaseTest;
import a1qa.framework.utils.ConfigReader;
import a1qa.framework.utils.TimeoutConfig;

public abstract class MainForEntityFramework {

	protected WebElement element;
	protected static Properties properties = ConfigReader.getInstance().getProperties();
	protected Logger log = BaseTest.log;
	protected WebDriver driver = BrowserManager.getInstance(properties.getProperty(PROP_BROWSER)).getDriver();

	public MainForEntityFramework(By locator) {
		assertTrue(isNotNull(locator), "Not found element");
	}

	public WebElement getElement() {
		return element;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public void clickElement(By locator) {
		new Button(locator).clickBnt();
	}

	public void clickElement() {
		log.info("Click button");
		element.click();
	}

	public static void clickback() {
		BrowserManager.getInstance(properties.getProperty(PROP_BROWSER)).back();
	}
	
	public void mouseClick() {
		Actions action = new Actions(driver);
		action.moveToElement(element).click(element).build().perform();
	}

	public void refreshPage() {
		BrowserManager.getInstance(properties.getProperty(PROP_BROWSER)).refreshPage();
	}

	public String getText() {
		return element.getText();
	}

	public String getText(By locator) {
		return element.findElement(locator).getText();
	}

	public Label checkElementLabel(By locator) {
		log.info("Checked label");
		return new Label(locator);
	}

	public Combobox choiceComboBox(By locator) {
		log.info("Choice combobox");
		return new Combobox(locator);
	}

	public TextBox choiceTextBox(By locator) {
		log.info("Choice textbox");
		return new TextBox(locator);
	}

	public void pointToElement(By locator) {
		log.info("Move the cursor over an element");
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(locator);
		action.moveToElement(elem);
		action.perform();
	}

	public WebElement pointToElement() {
		log.info("Point to element");
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
		return element;
	}

	public boolean isNotNull(By locator) {
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			log.error("Not found element " + e.getMessage());
			return false;
		}
		log.info("Item found");
		return true;
	}

	public String getAttribute(By locator, String atrName) {
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			log.info("Not found element " + e.getMessage());
			return EMPTY_STR;
		}
		log.info("Getting an attribute");
		return element.getAttribute(atrName);
	}

	public WebElement setWaitClickable(By locator) {
		element = driver.findElement(locator);
		Wait<WebDriver> wait = new WebDriverWait(driver, Integer.parseInt(properties.getProperty(PROP_BROWSER_TIMEOUT)))
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public WebElement isElementDisplayed(By locator) {
		new WebDriverWait(driver, Long.parseLong(properties.getProperty(PROP_BROWSER_TIMEOUT)))
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.until(new Function<WebDriver, Boolean>() {
					@Override
					public Boolean apply(WebDriver dr) {
						element = dr.findElement(locator);
						return element.isDisplayed();
					}
				});
		return element;
	}

	public WebElement setFluensWaitTextInElement(By locator, String text) {
		element = driver.findElement(locator);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Integer.parseInt(properties.getProperty(PROP_BROWSER_TIMEOUT)), TimeUnit.MILLISECONDS)
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		return element;
	}

	public void waitingForDownload(By locator, long timeout) {
		log.info("Waiting for download");
		new WebDriverWait(driver, timeout)
				.withTimeout(Integer.parseInt(properties.getProperty(PROP_BROWSER_TIMEOUT)), TimeUnit.MILLISECONDS)
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
	}

	public void fluentWaitForPresenceOf(By locator) {
		log.info("Waiting for presence of element");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Integer.parseInt(properties.getProperty(PROP_BROWSER_TIMEOUT)), TimeUnit.MILLISECONDS)
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitingForDownloadPlace() {
		new WebDriverWait(driver, Long.parseLong(properties.getProperty(PROP_BROWSER_TIMEOUT)))
				.pollingEvery(TimeoutConfig.MIN.getTimeout(), TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						JavascriptExecutor js = (JavascriptExecutor) driver;
						return (Boolean) js.executeScript("return jQuery.active == 0");
					}
				});
	}
}
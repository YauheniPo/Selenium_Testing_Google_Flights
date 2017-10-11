package a1qa.framework.entity.elements;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import a1qa.framework.utils.Numbers;

import static a1qa.framework.utils.RegExConfig.*;

public class Combobox extends BaseElement {

	private List<WebElement> listElem;

	public Combobox(By locator) {
		super(locator);
		log.info("Found combobox");
	}
	
	public WebElement getElementFromList(int position) {
		log.info("Choose element");
		return listElem.get(position);
	}

	public Combobox findElement(By locator) {
		if (isNotNull(locator)) {
			listElem.forEach(listItem -> {
				if (element.equals(listItem)) {
					log.info("Found element in combobox");
					element = listItem;
				}
			});
		} else {
			log.info("Not found element in combobox");
			return null;
		}
		return this;
	}

	public Combobox findElement(String textElement) {
		listElem.forEach(listItem -> {
			if (textElement.equals(((WebElement)listItem).getText())) {
				log.info("Found element in combobox");
				element = listItem;
			}
		});
		log.info("Not found element in combobox");
		return this;
	}

	public Combobox fetchListElements(String tag) {
		assertNotNull(element.findElements(By.tagName(tag)), "Not found element");
		log.info("Getting of set");
		listElem = element.findElements(By.tagName(tag));
		return this;
	}

	public Combobox fetchListElements(By locatorSet) {
		log.info("Getting of set");
		listElem = element.findElements(locatorSet);
		return this;
	}
	
	public List<WebElement> getListElements() {
		return listElem;
	}

	public WebElement findMaxValueElement(By searchLocator) throws StaleElementReferenceException {
		log.info("Element search");
		element = listElem.get(Numbers.ZERO.getNumber());
		listElem.forEach(listItem -> {
			if (Integer.valueOf(getStrToRegEx(element.getText(), REG_EX_VALUE_INT)) < 
					Integer.valueOf(getStrToRegEx(((WebElement)listItem).getText(), REG_EX_VALUE_INT))) {
				element = (WebElement)listItem;
			}
		});
		return element;
	}
}
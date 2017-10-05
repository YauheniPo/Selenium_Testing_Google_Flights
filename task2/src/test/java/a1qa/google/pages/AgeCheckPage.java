package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.elements.TextBox;
import a1qa.framework.pages.BasePage;
import a1qa.framework.utils.Numbers;

public class AgeCheckPage extends BasePage {
	
	private final static By FORM = By.xpath("//form[contains(@id, 'agecheck')]");
	private final By YEAR = By.xpath("//select[contains(@id, 'ear')]");
	private final By ENTER = By.xpath("//a[contains(@onclick, 'ubmit')]");

	public AgeCheckPage() {
		super(FORM);
		log.info("Opened age check");
	}

	public void inputValidData() {
		log.info("Data input");
		new TextBox(YEAR).inputData(String.valueOf(Numbers.TWO.getNumber())).clickElement(ENTER);
	}
}
package a1qa.framework.elements;

import static org.testng.Assert.*;

import org.openqa.selenium.By;

public class Label extends BaseElement {

	public Label(By locator) {
		super(locator);
		log.info("Found label");
	}
	
	public void checkLabel(String text) {
		assertEquals(text, element.getText(), "Same labels");
	}
	
	public void checkNotLabel(String text) {
		assertNotEquals(text, element.getText(), "Not the same labels");
	}
}
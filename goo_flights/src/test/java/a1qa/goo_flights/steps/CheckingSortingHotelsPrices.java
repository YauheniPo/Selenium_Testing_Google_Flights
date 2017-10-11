package a1qa.goo_flights.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import a1qa.framework.test.BaseTest;
import a1qa.goo_flights.pages.HomePage;
import a1qa.goo_flights.pages.HotelsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.framework.utils.RegExConfig.*;
import static a1qa.goo_flights.pages.HotelsPage.*;
import static org.testng.Assert.*;

public class CheckingSortingHotelsPrices extends BaseTest {

	HomePage homePage;
	private HotelsPage hotelsPage;

	@When("^information hotels$")
	public void informationHotels() throws Throwable {
		homePage = new HomePage().clickPlaceHotels();
		homePage.focusNewWindow();
	}

	@Then("^opened hotels page$")
	public void hotelsPage() throws Throwable {
		hotelsPage = new HotelsPage();
	}

	@When("^I clicked prices tag$")
	public void clickPricesTag() throws Throwable {
		hotelsPage.clickPriceTag();
	}

	@Then("^prices sorted in ASC$")
	public void sortPrices() throws Throwable {
		log.info("Checking sorting hotels");
		List<WebElement> hotels = hotelsPage.getListHotels();
		boolean bool = true;
		for(int i = 0, l = hotels.size(); i < l-1; ++i) {
			int price = Integer.valueOf(getStrToRegEx(hotels.get(i).findElement(HOTELS_ELEMENT_PRICE).getText(), REG_EX_VALUE_INT));
			int priceNext = Integer.valueOf(getStrToRegEx(hotels.get(i+1).findElement(HOTELS_ELEMENT_PRICE).getText(), REG_EX_VALUE_INT));
			if(price > priceNext) {
				log.error("Error hotels sorting");
				bool = false;
				break;
			}
		}
		assertTrue(bool, "Error hotels sorting");
		log.info("Sorted hotels complete");
	}
}
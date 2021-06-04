package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sortiranje {
	public static final String URL_PRODUCTPAGE ="https://www.saucedemo.com/inventory.html";
	public static final String PRODUCT_DROPBOX_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select";

	
	
        public static void lowToHighchoice(WebDriver driver) {
		Select lowToHigh = new Select(driver.findElement(By.xpath(PRODUCT_DROPBOX_XPATH)));
		lowToHigh.selectByVisibleText("Price (low to high)");
	}
}

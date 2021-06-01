package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sortiranje {
	public static final String URL_PRODUCTPAGE ="https://www.saucedemo.com/inventory.html";
	public static final String PRODUCT_DROPBOX_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select";

	
	public static void dropboxBtn(WebDriver driver) {
		WebElement searchBox =driver.findElement(By.xpath(PRODUCT_DROPBOX_XPATH));
		searchBox.click();
		
	}
	
	public static void lowToHighchoice(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
	}
	
}

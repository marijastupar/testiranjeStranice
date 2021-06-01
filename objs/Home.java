package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	
	public static final String URL= "https://www.saucedemo.com/";
	public static final String URL_PRODUCTPAGE = "https://www.saucedemo.com/inventory.html";
	
	public static final String TXTUSERNAME_XPATH ="//*[@id=\"user-name\"]";
	public static final String TXTPASSWORD_XPATH = "//*[@id=\"password\"]";
	
	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(TXTUSERNAME_XPATH)).sendKeys(username);
	}
	
	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(TXTPASSWORD_XPATH)).sendKeys(password);
			
	}
	
	public static void loginBtn(WebDriver driver) {
		driver.findElement(By.id("login-button")).click();;
	}
	

}

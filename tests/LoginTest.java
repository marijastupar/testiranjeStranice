package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.Home;
import objs.Sortiranje;

public class LoginTest {
	
	private static WebDriver driver;
	
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
	} 
	
	@Test (priority=1)
	public void inavlidDataTest() {
		
		File f = new File("Podaci.xlsx");
		try {
			InputStream is = new FileInputStream(f);
            XSSFWorkbook wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            SoftAssert sa = new SoftAssert();
            
            Row row = sheet.getRow(0);
            Cell c0 = row.getCell(0);
			Cell c1 = row.getCell(1);
			
			String username = c0.toString();
			String password = c1.toString();
			
			driver.get(Home.URL);
			Home.inputUsername(driver,username);
			Home.inputPassword(driver, password);
			Home.loginBtn(driver);
			
		    String currentUrl = driver.getCurrentUrl();
		    String expectedUrl = Home.URL_PRODUCTPAGE;
		    Assert.assertEquals(currentUrl, expectedUrl);
		    
		    
			wb.close();
            
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (priority=2)
	public void validDataTest() {
		
		File f = new File("Podaci.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
            
            
            Row row = sheet.getRow(1);
            Cell c0 = row.getCell(0);
			Cell c1 = row.getCell(1);
			
			String username = c0.toString();
			String password = c1.toString();
			
			driver.get(Home.URL);
			Home.inputUsername(driver,username);
			Home.inputPassword(driver, password);
			Home.loginBtn(driver);
			
		    String currentUrl = driver.getCurrentUrl();
		    String expectedUrl = Home.URL_PRODUCTPAGE;
		    Assert.assertEquals(currentUrl, expectedUrl);
		    
		    
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	@Test (priority=3)
	public void sortiranjeTest() {
		driver.navigate().to(Sortiranje.URL_PRODUCTPAGE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Sortiranje.lowToHighchoice(driver);
		
		List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
		
		driver.manage().window().maximize();
		
		String expectedResult = "Sauce Labs Onesie";
		String actualResult = items.get(0).getText();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
}

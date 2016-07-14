package ht_pack;

//Створити тест який би перевіряв чи є на пошті лист з заданою назвою теми.
//- Скрипт повинен працювати хоча б на двох веб браузерах (chrome, firefox)
//- Скрипт має опрацьовувати варіанти:
//- лист знайдено
//- лист не знайдено
//- в обох випадках має коректно завершувати свою роботу. 
//- В якості поштового сервісу використати gmail (попередньо вручну самому створити тестовий акаунт)
//- В якості тексту для пошуку (назва листа) шукати текст, наприклад: Hello User. (Лист також можна попередньо самому собі відправити)


import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class checkMail {
	
	
		File pathToBinary = new File("C:\\Users\\user\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		
		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
		
	
	
	@BeforeMethod
	public void beforeStart(){
		driver.get("http://mail.google.com/");
		
	}
	@Test
	public void testStart() throws InterruptedException{
		
		WebElement elem = driver.findElement(By.id("Email"));
		elem.sendKeys("testmailforlits");
		elem = driver.findElement(By.id("next"));
		elem.click();
		Thread.sleep(1000);
		elem = driver.findElement(By.id("Passwd"));
		elem.sendKeys("123qq123");
		Thread.sleep(1000);
		elem = driver.findElement(By.id("signIn"));
		elem.click();
		
				
		Thread.sleep(2000);
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@class=\"F cf zt\"]/*/*/*/*/*/*/*")); 

		for (WebElement element: allElements) {
			Thread.sleep(2000);
		      
		      String mailstr = element.getText();
		      System.out.println(mailstr);
		      boolean isContain = mailstr.contains("Hello user"); //Содержит ли тема письма строку
		      System.out.println(isContain); 
		}
		
		
	}
	
	@AfterMethod
	public void closeApp(){
		driver.quit();
	}

}

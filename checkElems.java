package packAmazon;

//Получить список книг с Амазона, сравнить их название и цену в списке и на персональной странице;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkElems {
	
	WebElement elems;
	WebDriver dr;
	
	@BeforeMethod
	public WebDriver init(){
		dr = new FirefoxDriver();
		dr.get("http://amazon.com/best-sellers-books-Amazon/zgbs/books");
		return dr;
	}
	
	@Test
	public void tryToFind() throws InterruptedException{
		
		//Получаем все названия
		List<WebElement> list = dr.findElements(By.xpath("//*[@id=\"zg_centerListWrapper\"]/div/div/div/a"));
		//Получаем все цены
		List<WebElement> pricelist = dr.findElements(By.className("price"));
		int cntdwn = 0;//счетчик для кол-ва цен
		//Для перечня книг (по названиям) сравниваем названия и цены
		for (WebElement elem :list){
			
			String name = elem.getText();
			
			elems = elem;
			String [] fullname = new String[1];
					fullname = assertName();
			System.out.println(name);
			if (name.length()>25){name=name.substring(0, 25);}
			else{}
			boolean isContain = (fullname[0]).contains(name); 
		    System.out.println(isContain);
		    
		    System.out.println(pricelist.get(cntdwn).getText());
		    boolean priceContain = (fullname[1]).equals(pricelist.get(cntdwn).getText());
		    System.out.println(priceContain);
		    cntdwn++;
	  	
			
			
		}
		
	}
	
	@Test
	public String [] assertName() throws InterruptedException{
		WebDriver dr2 = new FirefoxDriver();
		
		String url = elems.getAttribute("href");//Получение ссылки страницы книги
		System.out.println(url);
		dr2.get(url);//Переход на страницу книги
		
		String [] results = new String[2]; //Инициализируем массив результатов
		
		WebElement welem = dr2.findElement(By.id("productTitle"));
		String fullname = welem.getText();
		System.out.println(fullname); 
		results[0]=fullname;//Получаем и добавляем название в массив
		
		welem = dr2.findElement(By.xpath("//*[@id=\"buyNewSection\"]/h5/div/div[2]/div/span[2]"));
		String fullprice = welem.getText();
		System.out.println(fullprice);
		results[1]=fullprice;//Получаем и добавляем цену в массив
		
		dr2.quit();
		return results;}
	
	@AfterMethod
	public void closeWindow(){
		dr.quit();
	}

}

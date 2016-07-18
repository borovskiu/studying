package pack;

//За допомогою http client зробити запит до будь-якого ресурсу і перевірити чи прийшов відповідний статус в response-і,
//чи тип повернення контенту вірний, розпарсати дані і перевірити чи в даних є дані, які ви очікуєте.
//Приклад:
//request http://www.google.com
//response status: 200 ok
//response content type: html
//response body: <html>......<html> (первірити чи буде тут міститись <div id="hplogo"> в response body)

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;


public class testng_hometask {

	@Test
	public static void main(String [] args) throws ClientProtocolException,
			IOException, ParseException {
		
		//Получаю status и content type
		   System.out.println(Request.Get("http://google.com.ua").execute().returnResponse());
		//Получаю body. Преобразую в строку и вывожу  
		   String smth = (Request.Get("http://google.com.ua").execute().returnContent().toString()); 
		   System.out.println(smth); 
		 //Проверяю строку (которая по факту  response body) на вхождение <div id="hplogo">
		   boolean res = smth.contains("<div id=\"hplogo\">");
		 //Вывожу результат
		    System.out.println(res);
		    boolean expectedResult = false;
			Assert.assertEquals(res, expectedResult);
		
		
	}
}

package pack;


import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;


public class testng_hometask {

	public static void main(String... args) throws ClientProtocolException,
			IOException, ParseException {
		
		
		   System.out.println(Request.Get("http://google.com.ua").execute().returnResponse());
		   String smth = (Request.Get("http://google.com.ua").execute().returnContent().toString()); 
		   System.out.println(smth); 
		   boolean res = smth.contains("<div id=\"hplogo\">");
		    System.out.println(res);
		
		
	}
}



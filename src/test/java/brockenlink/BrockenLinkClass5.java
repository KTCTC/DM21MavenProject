package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrockenLinkClass5 {
WebDriver driver;
	@Test
	public void verifyURLIsBrockenOrNot() throws IOException 
	{
		
		SoftAssert sAssert = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://demoqa.com/links");
		
		String baseUrl = "https://demoqa.com";
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
           for (WebElement each:allLinks)
           {
        	  String actualURL = each.getAttribute("href");    
        	  
        	  if (actualURL!=null)
        	  {
        	  
        	   if (actualURL.contains("javascript:void"))
        	  {
        		  actualURL = baseUrl +"/"+ each.getAttribute("id");
        		  
        	  }
        	   
        	  HttpURLConnection http = getResponceCodeOfLink(actualURL);
        	  
        	  if (http.getResponseCode()>=400)
        	  {
        		  sAssert.assertTrue(false, actualURL +" is brocken with Response code = "+http.getResponseCode()+ " And response message = "+ http.getResponseMessage());
        	  }
        	  
        	  }
           }
		
		sAssert.assertAll();
		
	}
	
	public static HttpURLConnection getResponceCodeOfLink(String link) 
	{
		HttpURLConnection http = null;
		int resCode = 0;
		
		try {
			URL url = new URL(link);
			URLConnection urlConn = url.openConnection();
			http = (HttpURLConnection)urlConn;
			
			http.setConnectTimeout(15000);
			
			http.connect();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return http;
	}
	
}

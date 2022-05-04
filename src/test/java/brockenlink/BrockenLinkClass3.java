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

public class BrockenLinkClass3 {
WebDriver driver;
	@Test
	public void verifyURLIsBrockenOrNot() throws IOException
	{
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
        	  
        	   if (actualURL!=null && actualURL.contains("javascript:void"))
        	  {
        		  actualURL = baseUrl +"/"+ each.getAttribute("id");
        		  
        	  }
        	   
        	   System.out.println(actualURL);
           }
		
		
		
	}
}

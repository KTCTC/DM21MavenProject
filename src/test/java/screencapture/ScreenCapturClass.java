package screencapture;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenCapturClass {
	
	
	@Test
	public void verifyUserCanUploadFile () throws IOException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://demo.guru99.com/test/upload/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
			File f = ts.getScreenshotAs(OutputType.FILE);	
			
		File outFile = new File(System.getProperty("user.dir")+"\\abc.png");	
		
		FileUtils.copyFile(f, outFile);
		

	}

}

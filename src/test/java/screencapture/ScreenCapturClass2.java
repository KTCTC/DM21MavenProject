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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenCapturClass2 {
	WebDriver driver ;
	
	@Test
	public void verifyUserCanUploadFile () throws IOException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://demo.guru99.com/test/upload/");
        driver.findElement(By.id("uploadfile_0")).sendKeys(System.getProperty("user.dir")+"\\DM21Prop.properties");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("submitbutton")).click();
		
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@id='res']/center[contains(text(),'1 file ')]"))));
		
		String txt = driver.findElement(By.xpath("//h3[@id='res']/center[contains(text(),'1 file ')]")).getText();
		System.out.println(txt);
		txt = txt.replace("\n", " ");		
		
		Assert.assertEquals(txt, "1 file has been successfully uploaded");		

	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("No need to take screen shot");
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File f = ts.getScreenshotAs(OutputType.FILE);	
			
		File outFile = new File(System.getProperty("user.dir")+"\\"+result.getName()+".png");	
		
		FileUtils.copyFile(f, outFile);
		}
		
		else if (result.getStatus()==ITestResult.SKIP)
		{
			System.out.println("test case is skipped");
		}
		
		
		
		
	}

}

package ktctc.DM21MavenProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadRobotClass {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://demo.guru99.com/test/upload/");
		//driver.findElement(By.id("uploadfile_0")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("uploadfile_0"))).click().build().perform();
		
		StringSelection stringSelection = new StringSelection("C:\\Users\\91992\\DM21\\DM21MavenProject\\DM21Prop.properties");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		try {
			Robot rb = new Robot();
			Thread.sleep(3000);	
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			
			Thread.sleep(5000);	
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		
		
		
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("submitbutton")).click();
		
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@id='res']/center[contains(text(),'1 file ')]"))));
		
		String txt = driver.findElement(By.xpath("//h3[@id='res']/center[contains(text(),'1 file ')]")).getText();
		System.out.println(txt);
		txt = txt.replace("\n", " ");
				
		if (txt.equals("1 file has been successfully uploaded."))
		{
			System.out.println("File upload test case is Passed");
		}
		else
		{
			System.out.println("File upload test case is Failed");
		}

	}

}

package dataprovider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.ExcelHelper;

public class DataProviderInTestNG2 {
	
	WebDriver driver;
	
@BeforeClass
public void beforeClassMethod()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	driver.get("https://demoqa.com/webtables");
}
    
    
    @DataProvider (name = "UserDetails")
    public String[][] getUserDetails()
    {
    	String[][] arr= {{"Amit","patil","amit@patil.com","23","34567","IT"},{"Amol","Pawar","amol@pawar.com","45","44567","Software"}};
    	
    	return arr;
    }
    
    @Test (dataProvider = "UserDetails")
    public void addNewUserInSystem(String fname, String lname, String email, String age, String salary, String dept)
    {
    	driver.findElement(By.id("addNewRecordButton")).click();
    	driver.findElement(By.id("firstName")).sendKeys(fname);
    	driver.findElement(By.id("lastName")).sendKeys(lname);
    	driver.findElement(By.id("userEmail")).sendKeys(email);
    	driver.findElement(By.id("age")).sendKeys(age);
    	driver.findElement(By.id("salary")).sendKeys(salary);
    	driver.findElement(By.id("department")).sendKeys(dept);
    	driver.findElement(By.id("submit")).click();
    		
    	
    	
    }
    
    
    public String[][] getKeyValuePairData()
    {
    	//String[][] arr= {{"Name","Sanket"},{"add","Pune"}, {"Phonenumber","4567898767"}, {"Indian", "True"}};
    	ExcelHelper exHelp = new ExcelHelper("KTCTC.xlsx", "Oct");
    	ArrayList<String> keys = exHelp.getKeysList();
    	ArrayList<String> values = exHelp.getValuesList();
    	
    	String [][] arr1 = new String[keys.size()][2];
    	
    	for (int i=0;i<keys.size();i++)
    	{
    		arr1[i][0] = keys.get(i);
        	
        	arr1[i][1] = values.get(i);
    	}
    	
    	return arr1;
    	
    }
	

}

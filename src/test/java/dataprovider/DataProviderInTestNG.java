package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInTestNG {
	
	
	
	@DataProvider (name = "UserNames")
	public String[] getData()
	{
		String[] str = {"Amit","ajay", "Sanket", "salman"};
		
		return str;
	}
	
    @Test (dataProvider = "UserNames", enabled = false)
    public void verifyUserCaqnBeaddedWithUserName(String name)
    {
    	System.out.println("Executing test case for name = "+name);
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
    	System.out.println(fname);
    	System.out.println(lname);
    	System.out.println(email);
    	System.out.println(age);
    	System.out.println(salary);
    	System.out.println(dept);
    	
    }
	

}

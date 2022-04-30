package annotations;

import org.testng.annotations.Test;

public class SampleAnnotationTestNG extends TestBase{	
	
	@Test
	public void verifyUserCanLoginWithValiedCredentials()
	{
		System.out.println("verify User Can Login With Valied Credentials");
	}
	@Test
	public void verifyUserCanNotLoginWithInValiedCredentials()
	{
		System.out.println("verify User Can *Not Login With Valied Credentials");
	}

}

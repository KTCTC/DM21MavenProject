package annotations;

import org.testng.annotations.Test;

public class AnnotationsTestNG {
	
	@Test
	public void B()
	{
		System.out.println("This is B test case");
	}
	@Test
	public void A()
	{
		
		System.out.println("This is A test case");
	}
	
	public void verifyUserCanUploadFile()
	{
		System.out.println("This is verify User Can Upload File");
	}

}

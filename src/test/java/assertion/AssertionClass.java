package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

import ktctc.DM21MavenProject.FileUploadClass;

public class AssertionClass {
	FileUploadClass obj = new FileUploadClass();
	@Test
	public void B() {
		System.out.println("This is B test case");
	boolean	flag = true;
	boolean flag1 = true;
		
		Assert.assertTrue(flag, "Required element is not displayed");		
		
		Assert.assertFalse(flag1, "User is displayed after deletion");
		
		System.out.println("After assertion");
	}

	@Test
	public void A() {

		System.out.println("This is A test case");
		
		String msg = "HI";
		Assert.assertEquals("HI", msg, "Message displayed on UI and expected message is not equal");
		
		String val = "450";
		Assert.assertEquals(Integer.parseInt(val), 450);
		
		Assert.assertNotEquals(val, "450");
		
		System.out.println("After equal assert");
	}
	
	@Test
	public void verifyUserCanUploadFile() {
		System.out.println("This is verify User Can Upload File");
		Assert.assertNotNull(obj);
		Assert.assertNull(obj, "Object got initialized falsly");
		System.out.println("After null assert");
	}
	
	
	@Test
	public void zTestCase()
	{
		System.out.println("Sample test case ");
		
		Assert.assertEquals(true, true);
		
		Assert.assertTrue(true);
		
		Assert.assertNotNull(obj);
		System.out.println("After all types of assertions");
	}
	

}

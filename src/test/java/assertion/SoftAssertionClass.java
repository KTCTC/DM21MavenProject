package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ktctc.DM21MavenProject.FileUploadClass;

public class SoftAssertionClass {
	FileUploadClass obj = new FileUploadClass();
	
	@Test
	public void B() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is B test case");
	boolean	flag = true;
	boolean flag1 = true;
		
	sAssert.assertTrue(flag, "Required element is not displayed");		
		
	sAssert.assertFalse(flag1, "User is displayed after deletion");
		
		System.out.println("After assertion");
		sAssert.assertAll();
		System.out.println("After soft assert");
	}

	@Test
	public void A() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is A test case");
		
		String msg = "HI";
		sAssert.assertEquals("HI", msg, "Message displayed on UI and expected message is not equal");
		
		String val = "450";
		sAssert.assertEquals(Integer.parseInt(val), 4500);
		
		sAssert.assertNotEquals(val, "450");
		
		System.out.println("After equal assert");
		sAssert.assertAll();
		System.out.println("After soft assert");
	}
	
	@Test
	public void verifyUserCanUploadFile() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("This is verify User Can Upload File");
		sAssert.assertNotNull(obj);
		sAssert.assertNull(obj, "Object got initialized falsly");
		System.out.println("After null assert");
		sAssert.assertAll();
		System.out.println("After soft assert");
	}
	
	
	@Test
	public void zTestCase()
	{
		SoftAssert sAssert = new SoftAssert();
		System.out.println("Sample test case ");
		
		sAssert.assertEquals(true, true);
		
		sAssert.assertTrue(true);
		
		sAssert.assertNotNull(obj);
		System.out.println("After all types of assertions");
		sAssert.assertAll();
		System.out.println("After soft assert");
	}
	

}

package enable;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledInTestNG {
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
		
	
	@Test (enabled = false)
	public void zTestCase()
	{
		System.out.println("Sample test case ");
		
		Assert.assertEquals(true, true);
		
		Assert.assertTrue(true);	
		
		System.out.println("After all types of assertions");
	}
	


}

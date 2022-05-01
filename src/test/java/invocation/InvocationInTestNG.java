package invocation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvocationInTestNG {
	static int count=0; 
	@Test  (invocationCount = 5)
	public void sampleTestCase()
	{
		count++;
		System.out.println("sampleTestCase");
		if (count==3)
		{
			
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
		
		
	}

}

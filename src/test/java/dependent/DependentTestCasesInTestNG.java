package dependent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentTestCasesInTestNG {
	
	@Test 
	public void verifyUserCanBeAdded()
	{
		System.out.println("verify User Can Be Added");
		
		Assert.assertTrue(true);
	}
	@Test (dependsOnMethods = {"verifyUserCanBeAdded"})
	public void verifyUserCanBeEdited()
	{
		System.out.println("verify User Can Be Edited");
		Assert.assertTrue(false);
	}
	@Test (dependsOnMethods = {"verifyUserCanBeEdited", "verifyUserCanBeAdded"})
	public void verifyUserCanBeDeleted()
	{
		System.out.println("verify User Can Be deleted");
	}
}

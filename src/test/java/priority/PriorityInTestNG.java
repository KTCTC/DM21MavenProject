package priority;

import org.testng.annotations.Test;

public class PriorityInTestNG {
	
	@Test (priority = -20, dependsOnMethods = {"A"})
	public void B() {
		System.out.println("This is B test case");
	}

	@Test (priority = 2)
	public void A() {

		System.out.println("This is A test case");
	}

	@Test (priority = 3)
	public void verifyUserCanUploadFile() {
		System.out.println("This is verify User Can Upload File");
	}

}

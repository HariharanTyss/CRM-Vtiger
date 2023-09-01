package Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo {
@Test(priority = 1)
public void createcc() {
	Reporter.log("create",true);
}
@Test(dependsOnMethods = "createcc")
public void modifycc() {
	Reporter.log("modify",true);
}
@Test()
public void deletecc() {
	Reporter.log("delete",true);
}
}

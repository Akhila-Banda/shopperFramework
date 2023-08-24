package TestScrpits;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;


public class AddAddressTest extends BaseClass{

	@Test
	public void addAddresstest() throws InterruptedException {
	Map<String , String> map= excel.getData("Sheeet1", "Add Address");
	welcome.clickLoginButton();
	login.loginToApp(map.get("Email"), map.get("Password"));
	Thread.sleep(2000);
	home.clickProfileButton();
	Thread.sleep(2000);
	home.selectMyProfile();
	Thread.sleep(2000);
	myprofile.clickmyAddress();
	myaddress.clickAddAddress();
	address.addAddressDetails(webUtil, map );
	Thread.sleep(2000);
	Assert.assertEquals(myaddress.getSuccessMessage(), "successfully added");
	Thread.sleep(5000);
	}
}

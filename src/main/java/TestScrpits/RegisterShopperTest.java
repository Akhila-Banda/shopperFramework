package TestScrpits;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class RegisterShopperTest extends BaseClass {

     @Test
	public void createAccount() throws InterruptedException {
		welcome.clickLoginButton();
		login.clickCreateACCOUNTbutton();
		
		Map<String , String> map=excel.getData("Sheet", "Shopper Registration");
		int randomNUm=jutil.generatRandomNum(100);
		String email=randomNUm+map.get("Email Address");
		String pwd=map.get("password")+randomNUm;
		
		signup.createUserAccount(map.get("Frist Name"), map.get("Last Name"), map.get("Gender"),
				map.get("Phone Number"),email,pwd);
		
		Thread.sleep(5000);
		welcome.clickLoginButton();
		login.loginToApp(email, pwd);
		Thread.sleep(3000);
		assertTrue(driver.getTitle().contains("Home"));
	
	}
	
}

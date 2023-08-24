package TestScrpits;



import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {

	@Test
	public void addToCartTest() throws InterruptedException {
		Map<String, String> map =excel.getData("Sheet1", "Add to cart");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"), map.get("Password"));
		Thread.sleep(3000);
		home.mouseHoverToElectronic(webUtil);
		Thread.sleep(3000);
		home.clickHeadPhonelink();
		headPhone.clickAddCart();
		Thread.sleep(3000);
		Assert.assertEquals(headPhone.getAddTOCartText(), "ADDED");
		String itemName =headPhone.getItemName();
		headPhone.clickAddCart();
		Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
	}
}

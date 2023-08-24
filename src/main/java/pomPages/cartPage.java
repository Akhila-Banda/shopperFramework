package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {

	//Declaration
	@FindBy(xpath="//div[@class='cart_productDetails_pKWBd']/h3")
	private WebElement cartItem;
	
	//Initialization
	public cartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getCartItem() {
		return cartItem.getText();
	}
}

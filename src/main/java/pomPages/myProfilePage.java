package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myProfilePage {

	//Declaration
	@FindBy(xpath="//div[text()='My Addresses']")
	private WebElement myAddressLink;
	
	//Initialization
	public myProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickmyAddress() {
		myAddressLink.click();
	}
}

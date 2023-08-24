package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddresspage {

	//Declaration
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement  addAdressButton;
	@FindBy(xpath="//div[text()='successfully added']")
	private WebElement successMessage;
	
	//IntialiZation
	public MyAddresspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickAddAddress() {
		addAdressButton.click();
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
}

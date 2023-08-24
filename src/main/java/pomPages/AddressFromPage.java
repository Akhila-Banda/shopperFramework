package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;


public class AddressFromPage {

	//Declaration
	@FindBy(id="Name")
	private WebElement  nameTF;
	
	@FindBy(id="House/Office Info")
	private WebElement houseTF;
	
	@FindBy(id="Street Info")
	private WebElement streetInfoTF;
	
	@FindBy(id="Landmark")
	private WebElement landMarkTF;
	
	@FindBy(id="Country")
	private WebElement countryDropDown;
	
	@FindBy(id="State")
	private WebElement StateDropDown;
	
	@FindBy(id="City")
	private WebElement cityDropDown;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTF;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNumTF;
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAddressButton;
	
	//Initialization
	public AddressFromPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	//Utilization
	public void addAddressDetails(WebDriverUtility web, Map<String, String> details)
	 
	{
		
		nameTF.sendKeys(details.get("Name"));
		houseTF.sendKeys(details.get("house/Office Info."));
		streetInfoTF.sendKeys(details.get("Street Info"));
		landMarkTF.sendKeys(details.get("Landmark"));
		
		web.selectFromDropDown(details.get("Country"), countryDropDown);
		web.selectFromDropDown(details.get("State"), StateDropDown);
		web.selectFromDropDown(details.get("City"), cityDropDown);
		
		pincodeTF.sendKeys(details.get("Pincode"));
		phoneNumTF.sendKeys(details.get("Phone Number"));
		addAddressButton.click();
		
			
	}
}
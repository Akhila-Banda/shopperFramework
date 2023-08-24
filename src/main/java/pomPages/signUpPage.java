package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage {

	//Declaration
	@FindBy(id="First Name")
	private WebElement FirstNameTF;
	
	@FindBy(id="Last Name")
	private WebElement lastNameTF;
	
	@FindBy(xpath="//div[@id='Gender']/descendant::label/span[2]")
	private List<WebElement> genderRadioButton;
	
	@FindBy(id="Phone Number")
	private WebElement phonenoTF;
	
	@FindBy(id="Email Address")
	private WebElement emailAddressTF;
	
	@FindBy(id="Password")
	private WebElement passwordTF;
	
	@FindBy(id="Confirm Password")
	private WebElement conformPasswordTF;
	
	@FindBy(id="Terms and Conditions")
	private WebElement termsAndCondition;
	
	@FindBy(xpath="//button[text()='Register']")
	private WebElement registrationButton;
	
	//initialization 
	public signUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void createUserAccount(String firstName, String lastName, String expectedGender,
			String phoneNum, String email,String password  )
	{
		FirstNameTF.sendKeys(firstName);
		lastNameTF.sendKeys(lastName);
		
		for(WebElement element : genderRadioButton)
		{
			String gender=element.getText();
			if(gender.equals(expectedGender))
			{
			   element.click();
			   break;
			}
		}
		 
		phonenoTF.sendKeys(phoneNum);
		emailAddressTF.sendKeys(email);
		passwordTF.sendKeys(password);
		conformPasswordTF.sendKeys(password);
		termsAndCondition.clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registrationButton.click();
		
	}
	
}

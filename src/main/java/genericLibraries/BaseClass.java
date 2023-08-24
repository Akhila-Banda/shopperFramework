package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.AddressFromPage;
import pomPages.HeadPhonesPage;
import pomPages.HomePage;
import pomPages.MyAddresspage;
import pomPages.cartPage;
import pomPages.myProfilePage;
import pomPages.shopperLoginPage;
import pomPages.signUpPage;
import pomPages.welcomePage;

public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	protected static WebDriver sdriver;
	
	protected welcomePage welcome;
	protected shopperLoginPage login;
	protected HomePage home;
	protected signUpPage signup;
	protected myProfilePage myprofile;
	protected MyAddresspage myaddress;
	protected HeadPhonesPage headPhone;
	protected cartPage cart;
	protected AddressFromPage address;
	
//	@BeforeSuite
//	@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		property =new PropertiesUtility();
		excel= new ExcelUtility();
		jutil=new JavaUtility();
		webUtil=new WebDriverUtility();
		
		property.propertiesInit(IConstantPath.properties_path);
		excel.excelInit(IConstantPath.execel_path);
	}
	@BeforeMethod
	public void methoConfigaration() {
		driver =webUtil.navigateToApp(property.getData("browser"), property.getData("url"), 
				Long.parseLong(property.getData("time")));
		sdriver = driver;
		
		welcome= new welcomePage(driver);
		login =new shopperLoginPage(driver);
		home=new HomePage(driver);
		signup= new signUpPage(driver);
		myprofile =new myProfilePage(driver);
		myaddress =new MyAddresspage(driver);
		headPhone =new HeadPhonesPage(driver);
		cart=new cartPage(driver);
		address=new AddressFromPage(driver);
	}
	@AfterMethod
	public void methodTeardown() {
		home.clickProfileButton();
		home.clickLogout();
		webUtil.closeAllBrowsers();
	}
	
	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
//	@AfterTest
//	@AfterSuite
}

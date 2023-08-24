package genericLibraries;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	private WebDriver driver;
	public WebDriver navigateToApp(String browser, String url, long time)
	{
		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver",".src/main/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Boolean> prefs =new HashMap<String ,Boolean>();
			prefs.put("autofill.profile_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
				driver=new ChromeDriver();
		break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("invalid browser info");
				break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}
	
	public WebElement explicitwait(long time, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public WebElement explicitwait( WebElement element , long time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	public boolean explicitwait(long time, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
		
	}
		public void mouseHover(WebElement element)
		{
			Actions action= new Actions(driver);
			action.moveToElement(element).perform();
		}
		public void doubleClickonElement(WebElement element){
			Actions action=new Actions(driver);
			action.doubleClick(element).perform();
		}
		public void rightClick(WebElement element){
			Actions action=new Actions(driver);
			action.contextClick(element).perform();
		}
		public void dragAndDropAnElenment(WebElement element, WebElement target)
		{
			Actions action=new Actions(driver);
			action.dragAndDrop(element, target).perform();
			
		}
		public void selectFromDropDown(WebElement element , int index)
		{
			Select select= new Select(element);
			select.selectByIndex(index);
		}
		public void selectFromDropDown(WebElement element , String value)
		{
			Select select= new Select(element);
			select.selectByValue(value);
		}
		public void selectFromDropDown(String text ,WebElement element )
		{
			Select select= new Select(element);
			select.selectByVisibleText(text);;
		}
		
		public void switchToFrame(int index)
		{
			driver.switchTo().frame(index);
	    }
		public void switchToFrame(String idorName)
		{
			driver.switchTo().frame(idorName);
	
		}
		public void switchToFrame(WebElement frameElement)
		{
			driver.switchTo().frame(frameElement);
		}
		public void switchBackFromFrame() {
			driver.switchTo().defaultContent();
		}
		
		public void scrollTillElement(WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		
		public void handleAlert(String status) {
			Alert al=driver.switchTo().alert();
			if(status.equalsIgnoreCase("ok"))
				al.accept();
			else
				al.dismiss();
		}
		
	     public void switchToChildBrowser() {
	    	 
	    	 Set<String> set=driver.getWindowHandles();
	    	 for(String s:set)
	    	 {
	    		 driver.switchTo().window(s);
	    	 }
	     }
	     
	     public void switchToWindow(String id) {
	    	 driver.switchTo().window(id);
	     }
	     
	     public String getPraentWindowID() 
	     {
	    	 return driver.getWindowHandle();
	     }
		
	     public void closeSingBrowser() {
	    	 driver.close();
	     }
	     public void closeAllBrowsers() {
	    	 driver.quit();
	     }
}

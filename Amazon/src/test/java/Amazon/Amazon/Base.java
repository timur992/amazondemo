package Amazon.Amazon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	
	
    public void initializeBrowser(String browser) {
    	System.out.println("Browser Session Started at " + LocalDateTime.now());
    	
        if (browser.equalsIgnoreCase("chrome")) {
    		String pathToDriver = "C:\\Users\\krakh\\Desktop\\drivers\\chromedriver.exe";
    		String chromeDriver = "webdriver.chrome.driver";
            System.setProperty(chromeDriver, pathToDriver);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
    		String pathToFirefoxDriver = "C:\\Users\\krakh\\Desktop\\drivers\\geckodriver.exe";
    		String geckoDriver = "webdriver.gecko.driver";
            System.setProperty(geckoDriver, pathToFirefoxDriver);
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }
 //       driver.manage().window().maximize();
    }
    
    
    
    public  void navigateTo(String url) {
        driver.navigate().to(url);
    }
	
   
	public  void tearDown() {
		driver.quit();
		System.out.println("Browser session has quit!!! At : " + LocalDateTime.now());
	}
	
	//takeScreenshot: This method captures a screenshot of the current browser window.

	
	//setValue: This method sets the value of a text input field.
	public void setValue(WebElement element, String value) {
	    element.sendKeys(value);
	}
	
	//waitForPageLoad: This method waits for the page to fully load by checking the document.readyState property.
	public  void waitForPageLoad() {
	    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
	}
	
	//clearInput: This method clears the value of a text input field.
	public void clearInput(WebElement element) {
	    element.clear();
	}
	
	//scrollToElement: This method scrolls the page until a particular element is in view.
	public void scrollToElement(WebElement element) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//switchToWindow: This method switches the focus to a new window or tab.
	public  void switchToWindow(int windowIndex) {
	    List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(windowIndex));
	}
	
	//clickElement: This method clicks on a web element.
	public  void clickElement(WebElement element) {
	    element.click();
	}
	
	public  void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

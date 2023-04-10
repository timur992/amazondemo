package Amazon.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ChromeTest{
	
	@Test
	public void bookATicket() {
		
		System.out.println("Running Test bookATicket");
		String pathToDriver = "C:\\Users\\krakh\\Desktop\\drivers\\chromedriver.exe";
		String chromeDriver = "webdriver.chrome.driver";
        System.setProperty(chromeDriver, pathToDriver);
        WebDriver driver = new ChromeDriver();
		System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		String webAddress = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(webAddress);
		
		WebElement roundTripRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTripRadioButton.click();
		
		WebElement departureDropDown = driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction"));
		departureDropDown.click();
		wait(4);
		WebElement bengaluruCity = driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]"));
		bengaluruCity.click();
		wait(2);
		WebElement jaipurCity = driver.findElement(By.xpath("(//a[@text='Jaipur (JAI)' and @value='JAI'])[2]"));
		jaipurCity.click();
		wait(2);
		WebElement departDate = driver.findElement(By.xpath("(//a[contains(text(), '23')])[1]"));
		departDate.click();
		
		wait(2);
		WebElement returnDateDropDown = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2"));
		returnDateDropDown.click();
		
		WebElement returntDate = driver.findElement(By.xpath("(//a[contains(text(), '23')])[2]"));
		returntDate.click();
		wait(2);
		WebElement passengerDropDown = driver.findElement(By.id("divpaxinfo"));
		passengerDropDown.click();
		wait(2);
		WebElement adultIncrementButton = driver.findElement(By.id("hrefIncAdt"));
		adultIncrementButton.click();
		adultIncrementButton.click();
		wait(2);
		WebElement childIncrementButton = driver.findElement(By.id("hrefIncChd"));
		childIncrementButton.click();
		childIncrementButton.click();
		wait(2);
		WebElement doneButton = driver.findElement(By.id("btnclosepaxoption"));
		doneButton.click();
		wait(2);
		WebElement currencyDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select = new Select(currencyDropDown);
		select.selectByVisibleText("USD");
		wait(2);
		WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		searchButton.click();
		
		wait(3);
		
		driver.quit();
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

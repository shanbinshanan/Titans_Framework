package AdvanceSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchWindowByTitle {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		WebElement clickHereButton = driver.findElement(By.xpath("//*[contains(text(),'Click Here')]"));
	
		clickHereButton.click(); 
		
		windowByTitle(driver, "New Window");
		
		
		
	}

		public static void windowByTitle(WebDriver driver, String title) {
			
			String currentWindow = driver.getWindowHandle(); 
			
			Set<String> allWindows = driver.getWindowHandles(); 
			
			for(String winName: allWindows) { 
		
				if(!driver.switchTo().window(winName).getTitle().equals(title)) {
					
					driver.switchTo().window(currentWindow);
					System.out.println("sorry cant find your window");
				}
			}
		}
		

	}


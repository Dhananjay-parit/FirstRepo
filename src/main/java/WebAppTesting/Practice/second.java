package WebAppTesting.Practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com");
		driver.manage().window().maximize();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB); //creates new tab and switch driver to new tab
		driver.get("https://www.facebook.com");
		driver.switchTo().newWindow(WindowType.WINDOW); //creates new window and switches driver to new window 
		driver.get("https://www.selenium.dev");
		
    	//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		System.out.println(tabs.get(1));
//	    driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getWindowHandles());
//		
//		driver.findElement(By.xpath("//a[text()='➤ Live Selenium Project']")).click();
//		Set<String> windows = driver.getWindowHandles();
//		System.out.println(windows.size());
//		
		//driver.close();

	}

}

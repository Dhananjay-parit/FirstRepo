package WebAppTesting.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		// Add New User 
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		driver.findElement(By.xpath("//label[text()='User Role']/..//following-sibling::div//div[text()='-- Select --']")).click();
		List<WebElement> UserRoleDropdown = driver.findElements(By.xpath("//div[text()='-- Select --']/..//div[contains(@class,'oxd-select-option')]//child::span"));
		for(WebElement e : UserRoleDropdown) {
			String s = e.getText();
			if(s.equals("ESS")) {
				e.click();
			}
			else if(s.equals("Admin")) {
				e.click();
			
			}
			break;
			
		}
		driver.findElement(By.xpath("//label[text()='Employee Name']/..//following-sibling::div//child::div//input[@placeholder='Type for hints...']")).sendKeys("a");
		Thread.sleep(5000);
		List<WebElement> searchSuggetions = driver.findElements(By.xpath("//div[@class='oxd-autocomplete-option']"));
		for(WebElement e : searchSuggetions) {
		    e.click();
		    break;
		}
		driver.findElement(By.xpath("//label[text()='Status']/..//following-sibling::div//div[text()='-- Select --']")).click();
		List<WebElement> StatusDropdown = driver.findElements(By.xpath("//label[text()='Status']//..//following::div[6]//div[starts-with(@class,'oxd-select-option')]"));
    	for(WebElement e : StatusDropdown) {
			String s = e.getText();
			if(s.equals("Enabled")) {
				e.click();
				break;
			}
			else if(s.equals("Disabled")) {
				e.click();
				break;
			}
			
			
		}
		driver.findElement(By.xpath("//label[text()='Username']/..//following-sibling::div//child::input")).sendKeys("Admin7");
		driver.findElement(By.xpath("//label[text()='Password']/../..//input[@type='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/../..//input[@type='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		String Actual = driver.findElement(By.xpath("//p[text()='Success']")).getText() + " " + driver.findElement(By.xpath("//p[text()='Successfully Saved']")).getText();
		String Expected = "Success Successfully Saved";
		if(Actual.equals(Expected)) {
			System.out.println("User is created successfully.....");
		}
		driver.quit();
		
//		System.out.println(driver.findElement(By.xpath("//p[text()='Success']")).getText());
//		System.out.println(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).getText());
		
//		WebElement UserRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/..//following-sibling::div//div[text()='-- Select --']"));
//		Select s = new Select(UserRoleDropdown);
//		s.selectByIndex(1);
	}

	
}

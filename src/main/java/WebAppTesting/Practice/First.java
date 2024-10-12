package WebAppTesting.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.blinkit.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Detect my location']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement dairyProducts =  driver.findElement(By.xpath("//div[text()='Dairy, Bread & Eggs']"));
		System.out.println(dairyProducts.getText());
		List<WebElement> AllDairyProducts = dairyProducts.findElements(By.xpath("./../../../..//div[@class='SliderProductList__Container-sc-14wck6y-1 fUKyWD']//div[@class='ProductTypeCard__UpdatedProductTypeCardWrapper-sc-1ly7yxv-0 irsRWv']"));
	    for(WebElement e : AllDairyProducts) {
	    	WebElement s = e.findElement(By.xpath(".//div[@class='Product__UpdatedTitle-sc-11dk8zk-9 hxWnoO']"));
	    	System.out.println(s.getText());
	    }
	    System.out.println(AllDairyProducts.size());
		driver.close();
		
		
		
	}

}

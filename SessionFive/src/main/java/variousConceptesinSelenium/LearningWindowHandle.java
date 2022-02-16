package variousConceptesinSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningWindowHandle {

	
	
	 WebDriver driver;
	 
	 
	  
	  
	  @Before
	    	public void init() {
	    		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	    		driver = new ChromeDriver();
	    		driver.manage().window().maximize();
	    		driver.manage().deleteAllCookies();
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    		driver.get("https://www.yahoo.com/");

	    	
	    		
	    	}

	    	@Test
	    	public void testWindowHandle() {
	    		
	    		
	    		String str = driver.getWindowHandle();
	    		System.out.println(str);
	    		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
	    		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
	    		
	    		driver.findElement(By.xpath("//*[@id=\"main\"]/div/ol[1]/li[2]/div/div[1]/div[1]/a/h3/span")).click(); 
	    		
	    		
	    		String str2 = driver.getWindowHandle();
	    		System.out.println(str2);
	    		
	    		
	    		
	    		Set<String> h = driver.getWindowHandles();
	    		System.out.println(h);
	    		for(String i : h) {
	    			System.out.println(i);
	    			driver.switchTo().window(i);
	    			
	    		}
	    		System.out.println(driver.getTitle());
	    	}
	    	
    //	@After
	    	
//	public void TearDown() {
//		driver.close();
//		driver.quit();
		
	//}
	     
}

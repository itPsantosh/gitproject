package variousConceptesinSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement link: links) {
			String linkUrl=link.getAttribute("href");
			URL url =new URL(linkUrl);
			URLConnection urlconnection=url.openConnection();
			HttpURLConnection httpURlConnection=(HttpURLConnection) urlconnection;
			httpURlConnection.setConnectTimeout(5000);
			httpURlConnection.connect();
			if(httpURlConnection.getResponseCode()==200) {
				System.out.println(linkUrl+ "  --> "+ httpURlConnection.getResponseCode()+" -->   "+httpURlConnection.getResponseMessage());
			}
			else {
				System.err.println(linkUrl+ "  --> "+ httpURlConnection.getResponseCode()+" -->   "+httpURlConnection.getResponseMessage());
				httpURlConnection.disconnect();
			}
		}
		
			driver.quit();
			driver.close();

	}

}

/**
 * 
 */
package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import model.Apartment;

/**
 * @author Jay Patel
 *
 */
public class SeleniumLauncher {
	private static WebDriver driver;
	public static String url = "http://propertycenter.newjersey.remax.com/realestatehomesforsale/07029-p001.html?query=listingdate-dorder/price-dorder/tab-map/nwlat-40.75530179402708/nwlong-74.16895190750122/selat-40.74195568685129/selong-74.14401809249878#search/forcelatlong-False/nwlat-40.75530179402708/nwlong-74.16897336517334/selat-40.74195568685129/selong-74.14399663482666/location-07029/sv-true/sortorder-newest/pagenumber-1/tab-map/";
	
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "P:/Installations/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		// this is important !! 
		Thread.sleep(10000);
		
		List<WebElement>  listings = driver.findElements(By.className("js-mapcard-collapse_pane"));
		
		List<Apartment> apartments = new ArrayList<Apartment>();
		
		for (WebElement webElement : listings) {
			Apartment house = new Apartment();
			WebElement price = webElement.findElement(By.className("price"));
			house.price = price.getText();
			WebElement address = webElement.findElement(By.className("listing-pane-address"));
			house.address = address.getText();
			System.out.println(house.toString());
			apartments.add(house);
		}
		
		driver.quit();

	}

}

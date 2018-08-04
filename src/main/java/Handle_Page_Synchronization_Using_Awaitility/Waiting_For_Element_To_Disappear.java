package Handle_Page_Synchronization_Using_Awaitility;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Waiting_For_Element_To_Disappear {
	
		private WebDriver driver;

		@Test
		public void Waiting_For_Element_Disappears() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		WebElement newUserBtn = driver.findElement(By.id("save"));
		WebElement loadingElement = driver.findElement(By.id("loading"));

		// Get a new User
		for(int i=0; i<20; i++){
		    newUserBtn.click();
		    await("Wait for new user to load").atMost(5, TimeUnit.SECONDS)
		                                      .until(loadingElement::getText, not("loading..."));
		}

	}
	}


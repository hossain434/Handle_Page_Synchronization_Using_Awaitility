package Handle_Page_Synchronization_Using_Awaitility;
import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Waiting_For_Element_To_Appear {
	private WebDriver driver;

	@Test
	public void Waiting_For_Element_Appears() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
	driver.findElement(By.id("downloadButton")).click();
	WebElement progress= driver.findElement(By.cssSelector("div.progress-label"));
	        
	// Wait for the download to complete - max 20 seconds
	await("Download did not complete within 20 seconds").atMost(20, TimeUnit.SECONDS)
									.until(progress::getText, is("Complete!"));
	        
	//Did you notice? The robust wait statement is just an one-liner! It looks neat and clean!
	System.out.println("DONE!!");

}
}

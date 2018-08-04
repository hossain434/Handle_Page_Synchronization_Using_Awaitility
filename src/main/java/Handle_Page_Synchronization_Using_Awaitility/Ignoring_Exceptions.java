package Handle_Page_Synchronization_Using_Awaitility;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import static org.awaitility.Awaitility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ignoring_Exceptions {
	private WebDriver driver;

	@Test
	public void Ignoring_Exception() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.seleniumframework.com/Practiceform/");
	WebElement alertButton = driver.findElement(By.id("timingAlert"));
	      
	//To check if alert is present - By the way, predicates are cool!     
	Predicate<WebDriver> isAlertPresent = (d) -> {
	    d.switchTo().alert();
	    return true;
	};

	//click - alert appears after 3 seconds  
	alertButton.click();

	//wait for 5 seconds - ignore alert not present exception
	await("Wait for alert").atMost(5, TimeUnit.SECONDS)
	                       .ignoreExceptions()
	                       .until(() -> isAlertPresent.test(driver));

	driver.switchTo().alert().accept();

/*
 * Periodic Check:
Lets assume that – a button click triggers a Welcome EMail which you need to validate as part of your automated test. 
As you know, It might take sometime to receive an email – we need to check for an email at regular intervals until the given timeout period.

await().atMost(2, MINUTES)          // max wait
      .pollDelay(5, SECONDS)        // do not check immediately - wait for 5 seconds for the first time 
      .pollInterval(10, SECONDS)    // check every 10 seconds
      .until(() -> {                // until email is received
         return EMailUtil.hasEmailReceived("Welcome Email"); 
      });
      
Downloading File:
Sometimes, you click on a link to download a file. Once the download starts, then you can not control via selenium API. 
You might need to check if the download is complete.

Path filePath = Paths.get(".", "filename");
await().atMost(1, MINUTES)
        .ignoreExceptions()
        .until(() -> filePath.toFile().exists());
        
// For More: https://github.com/awaitility/awaitility/wiki/Usage

 */

}
}

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.Scanner; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chromium.*;
import org.openqa.selenium.chromium.ChromiumOptions;

class Main {
  public static void main(String[] args) throws Exception {
    
	  ChromeOptions options = new ChromeOptions();
    options.addArguments(
      "--no-sandbox",
      "--disable-dev-shm-usage",
      "--start-maximized"
    );
	
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    
    driver.get("https://google.com");    
    System.out.println("page title: " + driver.getTitle()); // => "Google"
    
    WebElement searchBox = driver.findElement(By.name("q"));
    WebElement searchButton = driver.findElement(By.name("btnK"));
    
    searchBox.sendKeys("Selenium");
    searchButton.click();
    
    searchBox = driver.findElement(By.name("q"));
    String searchBoxValue = searchBox.getAttribute("value"); // => "Selenium"
    System.out.println("search box value: " + searchBoxValue);

    /* use this Scanner section to pause the test
     * until you are ready to close the web browser
    */ 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 'done' to close test.");  
    int maxTries = 0;
    String scannerInput = sc.next();
    
    while (
      !scannerInput.equalsIgnoreCase("done") && 
      maxTries < 10) {
      scannerInput = sc.next();
      maxTries++;
    }  

    sc.close();
    
    driver.quit();
  } 
}
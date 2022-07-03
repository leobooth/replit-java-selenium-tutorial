import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.Scanner; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chromium.*;
import org.openqa.selenium.chromium.ChromiumOptions;

public class SeleniumTutorial {

  public ChromeDriver driver;
  
  public SeleniumTutorial() {
  }

  public void initializeDriver(int timeoutInSeconds) {
    ChromeOptions options = new ChromeOptions();
    options.addArguments(
      "--no-sandbox",
      "--disable-dev-shm-usage",
      "--start-maximized"
    );
	
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
  }

  public void quitDriver() {
    driver.quit();
  } 

  public void navigateToUrl(String url) {
    driver.get(url);
  }

  // TODO: make a page object for Google specific methods
  public String getPageTitle() {
    return driver.getTitle();
  }

  public String getSearchBarContents() {
    WebElement searchBox = driver.findElement(By.name("q"));
    String searchBoxContents = searchBox.getAttribute("value");
    return searchBoxContents;
  }

  public void performSearch(String searchText) {
    WebElement searchBox = driver.findElement(By.name("q"));
    WebElement searchButton = driver.findElement(By.name("btnK"));

    searchBox.sendKeys(searchText);
    searchButton.click();
  }
}
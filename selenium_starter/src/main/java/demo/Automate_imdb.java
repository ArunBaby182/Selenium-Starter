package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///
public class Automate_imdb{
    WebDriver driver;

    public Automate_imdb(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void automateimdb() throws InterruptedException{
        driver.get("https://www.imdb.com/chart/top");
        System.out.println("went to the website ttps://www.imdb.com/chart/top");
       List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,\"ipc-metadata-list-summary-item\")]"));
       System.out.println("list of movies included : "+list.size());
       System.out.println("Highest rated movie is :"+list.get(0).getText().split("\\n")[0]);
       System.out.println("oldest movie included in list is : "+ list.get(list.size()-1).getText().split("\\n")[0]);
        // dropdown activities
        WebElement sort_by= driver.findElement(By.id("sort-by-selector"));
        Select dropdown = new Select(sort_by);
        dropdown.selectByVisibleText("Release date");
       List<WebElement> list2 = driver.findElements(By.xpath("//li[contains(@class,\"ipc-metadata-list-summary-item\")]"));
        System.out.println("most recent movie is : "+list2.get(0).getText().split("\\n")[0]);
        dropdown.selectByVisibleText("Number of ratings");
        List<WebElement> list3 = driver.findElements(By.xpath("//li[contains(@class,\"ipc-metadata-list-summary-item\")]"));
        System.out.println("most user rating movie is : "+list3.get(0).getText().split("\\n")[0]);

    
    }
}


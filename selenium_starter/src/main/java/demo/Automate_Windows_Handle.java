package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
public class Automate_Windows_Handle{
    WebDriver driver;

    public Automate_Windows_Handle(){
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

    public  void automatewindowshandle() throws InterruptedException{
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        System.out.println("went to the website ttps://www.imdb.com/chart/top");
       WebElement frame1= driver.findElement(By.id("iframeResult"));
       driver.switchTo().frame(frame1);
       driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
       //for window handle
       
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {
        String child_window = I1.next();
        
        if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());

                driver.close();
        }
}
        driver.switchTo().window(parent);
    }
}


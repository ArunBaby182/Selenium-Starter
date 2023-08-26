package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///
public class Post_Linkedin{
    WebDriver driver;

    public Post_Linkedin(){
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

    public  void postlinkedin() throws InterruptedException{
        driver.get("https://in.linkedin.com/");
        WebElement email= driver.findElement(By.id("session_key"));
        WebElement passwd= driver.findElement(By.id("session_password"));
        email.clear();
        email.sendKeys("arunbaby180@gmail.com");
        passwd.clear();
        passwd.sendKeys("howdy_Sebb@1502");
        //Thread.sleep(50000);
        WebElement signin= driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
       signin.click();
    }
}

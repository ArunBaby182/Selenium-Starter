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
public class Automate_Nested_Frames{
    WebDriver driver;

    public Automate_Nested_Frames(){
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

    public  void automatenestedframes() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        System.out.println("went to the website");
        //SWITCH TO TOP FRAME
        WebElement top_frame=driver.findElement(By.name(("frame-top")));
        driver.switchTo().frame(top_frame);
        WebElement left_frame= driver.findElement(By.name(("frame-left")));
        //SWITCH TO LEFT FRAME
        driver.switchTo().frame(left_frame);
        System.out.println(left_frame.getText());
        driver.switchTo().parentFrame();
        WebElement middle_frame= driver.findElement((By.name("frame-middle")));
        System.out.println(middle_frame.getText());
        driver.switchTo().parentFrame();
        WebElement right_frame= driver.findElement((By.name("frame-right")));
        System.out.println(right_frame.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        WebElement bottom_frame=driver.findElement(By.name(("frame-bottom")));
        System.out.println(bottom_frame.getText());
        driver.switchTo().parentFrame();

        

        System.out.println();


    }
}

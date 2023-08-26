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
public class Automate_Img_Url{
    WebDriver driver;

    public Automate_Img_Url(){
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

    public  void automateimgurl() throws InterruptedException{
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //list of all the movies displayed in the recomended movies 
        List<WebElement> list = driver.findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../..//img"));
       //list of images
        //for each movie find the img url
        for(WebElement elem : list){
            String imageUrl = elem.getAttribute("src");
            System.out.println(imageUrl);

        }
        // driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[5]/div/div[6]/div/div[2]/a[1]")).click();
        // Thread.sleep(5000);
         JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

         WebElement img1= driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[3]/div[1]/div[3]/div/div/div[2]/a/div/div[2]/div/img"));
         jsExecutor.executeScript("arguments[0].scrollIntoView(true);", img1);
        Thread.sleep(5000);
         WebElement second_img=driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]/../../../../..//a[2]"));
         jsExecutor.executeScript("arguments[0].scrollIntoView(true);", second_img);
        Thread.sleep(5000);
        // System.out.println(second_img.getText());

    }
}

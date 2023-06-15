package PageObjectModel;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TakeANumber {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://eturkistan.com/#/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("input#mail")).sendKeys("ab.nurum@gmail.com");
        driver.findElement(By.cssSelector("input#current-pass")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button#singInbut")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("div:nth-of-type(2) > .moduleName")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("div:nth-of-type(" + 2 + ") > .cdk-drop-list > div:nth-of-type(" + 5 + ") > span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr"));
        Select selected1 = new Select(driver.findElement(By.xpath("//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr[" + allDates.size() + "]/td[@class='rightTD']//select")));
        selected1.selectByVisibleText("Add Topic");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("input[name='fname']")).sendKeys("selenium added topic");
        driver.findElement(By.cssSelector("div[role='textbox'] > p")).sendKeys("this is selenium added topic");
        driver.findElement(By.cssSelector(".rightTDText > div > div > button:nth-of-type(1)")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("div#closeButtonDiv")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        int allDatesMines = allDates.size()-1;
        driver.findElement(By.cssSelector("div:nth-of-type(" + 2 + ") > .cdk-drop-list > div:nth-of-type(" + 5 + ") > span")).click();
        WebElement title = driver.findElement(By.cssSelector("tr:nth-of-type("+allDatesMines+") .rightTD > .pointer.rightTDTitleAddTopic > span"));
        if (title.getText().equals("selenium added topic")){
            System.out.println("Title: " + title.getText());
        }
        Thread.sleep(2000);

        WebElement description = driver.findElement(By.cssSelector("tr:nth-of-type("+allDatesMines+") .pointer.sdboLinkDivNameTopic  p"));
        if (description.getText().equals("this is selenium added topic")){
            System.out.println("Description: " + description.getText());
        }
        driver.findElement(By.cssSelector("div#closeButtonDiv")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();





//        for (int i=0; i<=90; i++){
//            String str = "//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr[9]/td[@class='rightTD']//select";
//            String digits = str.replaceAll("[^0-90]", "");
//            System.out.println(digits);
//        }


    }

}

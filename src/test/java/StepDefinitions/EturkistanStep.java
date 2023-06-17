package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EturkistanStep {
    WebDriver driver;


    @Given("I launch SDBO")
    public void i_launch_sdbo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://eturkistan.com/#/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String string, String string2) throws InterruptedException {
        driver.findElement(By.cssSelector("input#mail")).sendKeys(string);
        driver.findElement(By.cssSelector("input#current-pass")).sendKeys(string2);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button#singInbut")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I click on SDBO Resource section")
    public void i_click_on_sdbo_resource_section() {
        driver.findElement(By.cssSelector("div:nth-of-type(2) > .moduleName")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I click {string} item on {string} column")
    public void i_click_item_on_column(String string, String string2) {
        driver.findElement(By.cssSelector("div:nth-of-type("+string+") > .cdk-drop-list > div:nth-of-type("+string2+") > span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @And("I select {string} on source popup")
    public void i_select_on_source_popup(String string) {
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr"));
        Select selected1 = new Select(driver.findElement(By.xpath("//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr[" + allDates.size() + "]/td[@class='rightTD']//select")));
        selected1.selectByVisibleText(string);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @And("I enter {string} on Name , and enter {string} to body for add topic")
    public void i_enter_on_name_and_enter_to_body_for_add_topic(String string, String string2) {
        driver.findElement(By.cssSelector("input[name='fname']")).sendKeys(string);
        driver.findElement(By.cssSelector("div[role='textbox'] > p")).sendKeys(string2);
        driver.findElement(By.cssSelector(".rightTDText > div > div > button:nth-of-type(1)")).click();// save button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I close popup for add topic")
    public void i_close_popup_for_add_topic() {
        driver.findElement(By.cssSelector("div#closeButtonDiv")).click(); // click the close button of popup
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("I click on {string} item on {string} column")
    public void i_click_on_item_on_column(String string, String string2) {
        driver.findElement(By.cssSelector("div:nth-of-type(" + string + ") > .cdk-drop-list > div:nth-of-type(" + string2 + ") > span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }






    @Then("I verify added an item with subject {string} and content {string}")
    public void i_verify_added_an_item_with_subject_and_content(String string, String string2)  throws InterruptedException {
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='leftSide']/table[@class='cdk-drop-list']/tbody/tr"));
        int allDatesMines = allDates.size()-1;
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.cssSelector("tr:nth-of-type("+allDatesMines+") .rightTD > .pointer.rightTDTitleAddTopic > span"));
        if (title.getText().equals(string)){
            System.out.println("Title: " + title.getText()); // title content
        }
        Assert.assertEquals(title.getText(), string, "Test Failed");
        Thread.sleep(2000);

        WebElement description = driver.findElement(By.cssSelector("tr:nth-of-type("+allDatesMines+") .pointer.sdboLinkDivNameTopic  p"));
        if (description.getText().equals(string2)){
            System.out.println("Description: " + description.getText()); // description content
        }
        Assert.assertEquals(description.getText(), string2, "Test Failed");
        System.out.println();

        driver.findElement(By.cssSelector("div#closeButtonDiv")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }


}

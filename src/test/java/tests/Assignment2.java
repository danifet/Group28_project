package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.VYtrackUtil;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Assignment2 {
    WebDriver driver;


    @BeforeMethod

    public void setupMethod(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
        VYtrackUtil.vytrackLogin(driver);

    }

    @Test

    public void driverLoginSeeVehicle(){

        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
        BrowserUtils.sleep(1);
        WebElement vehicle = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
        vehicle.click();

        BrowserUtils.sleep(1);
        Assert.assertEquals(driver.getTitle(), "Car - Entities - System - Car - Entities - System");

        WebElement cybertekSpartan = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//td[text()='Cybertek']"));
        cybertekSpartan.click();

        BrowserUtils.sleep(1);

        WebElement addEvent = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();

        BrowserUtils.sleep(1);

        String title = "awesome Apples";

        WebElement eventTitle = driver.findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_title-uid')]") );
        eventTitle.sendKeys(title);



        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']") );
        saveButton.click();

        BrowserUtils.sleep(1);

        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='message-item message'])[1]/strong")).getText(), title);

    }

   



}

package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.VYtrackUtil;

public class Assignment5 {

    @Test

     public void gridSettings(){
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        VYtrackUtil.vytrackLogin(Driver.getDriver());

        BrowserUtils.sleep(1);
        WebElement accounts = Driver.getDriver().findElement(By.xpath("//p[contains(text(), 'Accounts')]"));
        Assert.assertTrue(accounts.isDisplayed());

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//li[@class= 'dropdown dropdown-level-1']//span)[1]"));
        actions.moveToElement(fleet).perform();

        WebElement vehicles = Driver.getDriver().findElement(By.xpath("(//span[contains(text(), 'Vehicles')])[1]"));
        actions.moveToElement(vehicles).click().perform();

        WebElement gridSettingsButton = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        Point point1 = gridSettingsButton.getLocation();

        int gridSettingsButtonX = point1.getX();
        int gridSettingsButtonY = point1.getY();

        WebElement filtersButton = Driver.getDriver().findElement(By.xpath("//a[@title='Filters']"));
        Point point2 = filtersButton.getLocation();

        int filtersButtonX = point2.getX();
        int filtersButtonY = point2.getY();

        System.out.println(gridSettingsButtonX +" " + gridSettingsButtonY);
        System.out.println(filtersButtonX +" " + filtersButtonY);

        Assert.assertTrue(gridSettingsButtonX>2000 && gridSettingsButtonY<200);
        Assert.assertTrue(filtersButtonX>2300 && filtersButtonY<200);

        BrowserUtils.sleep(2);

        Driver.closeDriver();
    }
}

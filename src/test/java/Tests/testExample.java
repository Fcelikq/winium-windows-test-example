package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.*;
import org.testng.annotations.*;

import java.io.File;


public class testExample {

    public WiniumDriverService service;
    public  WiniumDriver driver;
    DesktopOptions option;
    public Actions actions;

    @BeforeTest
    public void Setup() {
        //Start driver
        String appPath = "appPath";
         option = new DesktopOptions();
         option.setApplicationPath(appPath);
        File driverPath = new File(System.getProperty("user.dir")+"//Drivers//Winium.Desktop.Driver.exe");
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
        driver = new WiniumDriver(service,option);
        actions = new Actions(driver);
    }

    @Test
    public void test1() {
        driver.findElement(By.id("id")).click();
        driver.findElement(By.id("id")).sendKeys("balbla");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

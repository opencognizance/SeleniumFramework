package org.framework.driverutilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.framework.utilities.GeneralUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class DriverManager {
    private static WebDriver driver=null;
    private static String browserType;

    private DriverManager(String browserName){
        browserType = browserName;
        if(browserType.equalsIgnoreCase("CHROME")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("EDGE")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    public static WebDriver instantiateDriver(String browserType){
        if(driver==null){
            DriverManager driverManager = new DriverManager(browserType);
            return driver;
        }else{
            return driver;
        }
    }

    public static void getScreenshot(String pageName){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("SC_"+ GeneralUtility.getTimeStamp()+"_"+pageName+".JPEG");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

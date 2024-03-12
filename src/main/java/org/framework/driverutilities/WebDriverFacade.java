package org.framework.driverutilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/*
* path format:: "{path-type}:{path}"
*
* {path-type}::
*   1. XPATH
*   2. CSS-SELECTOR
*   3. ID
*   4. NAME
*   5. LINKTEXT
*   6. PARTIAL-LINKTEXT
*
* */

public class WebDriverFacade implements WebElement {
    private WebDriver driver;
    private WebElement element;
    private static final int WAIT_TIME = 5000;

    public WebDriverFacade(WebDriver driver, String path){
        this.driver = driver;
        Duration TIME = Duration.ofMillis(WAIT_TIME);
        String[] pathArray = path.split(":");
         if(pathArray[0].equalsIgnoreCase("XPATH")){
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pathArray[1]))));
             element = driver.findElement(By.xpath(pathArray[1]));
         } else if (pathArray[0].equalsIgnoreCase("ID")) {
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(pathArray[1]))));
             element = driver.findElement(By.id(pathArray[1]));
         } else if (pathArray[0].equalsIgnoreCase("NAME")) {
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(pathArray[1]))));
             element = driver.findElement(By.name(pathArray[1]));
         }else if (pathArray[0].equalsIgnoreCase("LINKTEXT")) {
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(pathArray[1]))));
             element = driver.findElement(By.linkText(pathArray[1]));
         }else if (pathArray[0].equalsIgnoreCase("CSS-SELECTOR")) {
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(pathArray[1]))));
             element = driver.findElement(By.cssSelector(pathArray[1]));
         }else if (pathArray[0].equalsIgnoreCase("PARTIAL-LINKTEXT")) {
             WebDriverWait wait = new WebDriverWait(driver, TIME);
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(pathArray[1]))));
             element = driver.findElement(By.partialLinkText(pathArray[1]));
         } else{
             Exception exception = new Exception("Invalid Selector");
             exception.printStackTrace();
         }
    }

    @Override
    public void click() {
         element.click();
    }

    @Override
    public void submit() {
         element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
          element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
         element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getDomProperty(String name) {
        return WebElement.super.getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return WebElement.super.getDomAttribute(name);
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public String getAriaRole() {
        return WebElement.super.getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        return WebElement.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        if(element.isSelected()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isEnabled() {
        if(element.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public SearchContext getShadowRoot() {
        return WebElement.super.getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}

package org.framework.pages;

import org.framework.driverutilities.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class TestPage {
    private WebDriver driver;
    private WebDriverFacade searchBox = new WebDriverFacade(driver,"XPATH://textarea[@aria-label='Search']");
    private WebDriverFacade searchBtn = new WebDriverFacade(driver, "XPATH://div[@class='lJ9FBc']/center/input[1]");

    public TestPage(WebDriver driver){
        this.driver = driver;
    }

    public void querySearch(String message){
        searchBox.sendKeys(message);
    }

    public void clickSubmitBtn(){
        searchBtn.click();
    }
}

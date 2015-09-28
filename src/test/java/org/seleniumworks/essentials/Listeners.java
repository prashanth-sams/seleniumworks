package org.seleniumworks.essentials;

/**
 * Created by prashanth_sams on 29/07/15.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;


public class Listeners implements WebDriverEventListener {
    private By lastFindBy;
    private WebElement lastElement;
    private String originalValue;


    public void beforeNavigateTo(String url, WebDriver driver) {
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }
    
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }
    
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    
    public void afterScript(String s, WebDriver webDriver) {

    }


    public void onException(Throwable throwable, WebDriver webDriver) {

        System.out.println("Caught Exception");

        File scrFile = ((TakesScreenshot)webDriver)
                .getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File("C:\\Testfailure.jpeg"));
        } catch (Exception e) {
            System.out.println("Unable to Save");
        }

    }

}
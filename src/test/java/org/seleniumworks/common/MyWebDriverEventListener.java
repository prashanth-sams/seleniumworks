package org.seleniumworks.common;

/**
 * Created by prashanth_sams on 20/07/15.
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * This class creates basic log entries for WebDriver actions.
 *
 */

public class MyWebDriverEventListener implements WebDriverEventListener {

    private static final Logger logger = Logger.getLogger(MyWebDriverEventListener.class);
    private By lastFindBy;
    private WebElement lastElement;
    private String originalValue;
    
    public void beforeNavigateTo(String url, WebDriver driver){
        logger.debug("Navigating to:'" +url+ "'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver){
        lastElement = element;
        originalValue = element.getText();
        // What if the element is not visible anymore?
        if(originalValue.isEmpty()) {
            originalValue = element.getAttribute("value");
        }
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        String changedValue = "";
        try {
            changedValue = element.getText();
        } catch (StaleElementReferenceException e) {
            logger.error("Could not log change of element, because of a stale"
                    + " element reference exception.");
            return;
        }

        // What if the element is not visible anymore?
        if (changedValue.isEmpty()) {
            changedValue = element.getAttribute("value");
        }
        logger.debug("Changing value in element found " + lastFindBy
                + " from '" + originalValue + "' to '" + changedValue + "'");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver){
        lastFindBy = by;
        logger.debug("Trying to find: '" +lastFindBy+ "'.");
    }

    
    public void afterFindBy(By by, WebElement element, WebDriver driver){
        logger.debug("Found: '" +lastFindBy+ "'.");
    }

    
    public void onException(Throwable error, WebDriver driver){}

    
    public void beforeClickOn(WebElement element, WebDriver driver){
        logger.debug("Trying to click: '" +element+ "'");
    }

    
    public void afterClickOn(WebElement element, WebDriver driver){
        logger.debug("Clicked: '" +element+ "'");
    }

    
    public void beforeScript(String script, WebDriver driver){
    //logger.debug("Try execute script: "+script);
    }

    
    public void afterScript(String script, WebDriver driver){
    //logger.debug("Finished executing script: "+script);
    }

    
    public void beforeNavigateBack(WebDriver driver){}

    
    public void beforeNavigateForward(WebDriver driver){}

    
    public void afterNavigateBack(WebDriver driver){}

    
    public void afterNavigateForward(WebDriver driver){}

    
    public void afterNavigateTo(String url, WebDriver driver){}
}

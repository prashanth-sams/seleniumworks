package org.seleniumworks.essentials;

/**
 * Created by prashanth_sams on 20/07/15.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final Logger logger = Logger.getLogger(RetryAnalyzer.class);
    int retryCount = 0;
    int retryMaxCount = 6;
    static {
        PropertyConfigurator.configure("/Users/prashanth_sams/Documents/Selenium-Hybrid-Framework/src/test/resources/log4j.properties");
//        PropertyConfigurator.configure("${basedir}/src/test/resources/log4j.properties");
    }

    public boolean retry(ITestResult tr) {
        if (tr.getAttributeNames().contains("retry") == false) {
            if(retryCount < retryMaxCount){
                logger.info("Retrying " + tr.getName() + " with status "
                        + tr.getStatus() + " for the " + (retryCount+1) + " of "
                        + retryMaxCount + " times.");
                retryCount++;
                return true;
            }
        }
        logger.debug("Skipping retry!");
        return false;
    }
}

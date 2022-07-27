package com.accesshq.web.utils.wrappers;

import com.aventstack.extentreports.Status;
import com.accesshq.web.config.SeleniumBase;
import com.accesshq.web.utils.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class KeyBase extends SeleniumBase {

   public static void click(final String objectLocator) {
        //WebElement element = driver.findElement(By.xpath(objectLocator));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By locator = By.xpath(objectLocator);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            pause(3000);
            element.click();
        } catch (StaleElementReferenceException staleElementException) {
            element = driver.findElement(By.xpath(objectLocator));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ExtentTestManager.getTest().log(Status.PASS, "Clicked on Locator: "+objectLocator);
    }

    public static void type(final String objectLocator, final String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By locator = By.xpath(objectLocator);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
             element.clear();
             element.sendKeys(text);
        } catch (StaleElementReferenceException staleElementException) {
             element = driver.findElement(By.xpath(objectLocator));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ExtentTestManager.getTest().log(Status.PASS, "Typed Text: "+text +" on Locator: "+objectLocator);
    }

    public static int getObjectCount(String locator) {
        ArrayList<WebElement> a = new ArrayList();
        a = (ArrayList<WebElement>) new ArrayList<WebElement>(driver.findElements(By.xpath(locator)));
        return a.size();
    }

    public static String getText(final String objectLocator) {
        WebElement element = driver.findElement(By.xpath(objectLocator));
        String text = null;
        try {
            text = element.getText();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ExtentTestManager.getTest().log(Status.PASS, "Retrieved Text: "+text +" from Locator: "+objectLocator);
        return text;
    }

    public static void pause(int pauseTime) {
        try {
            Thread.sleep(pauseTime);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        ExtentTestManager.getTest().log(Status.PASS, "Paused for: "+pauseTime);
    }

    public static String getValue(final String objectLocator) {
        WebElement element = driver.findElement(By.xpath(objectLocator));
        String text = null;
        try {
            text = element.getAttribute("value");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ExtentTestManager.getTest().log(Status.PASS, "Retrieved Text: "+text +" from Locator: "+objectLocator);
        return text;
    }

    public static void navigateToURL(String url) {
        driver.get(url);
        ExtentTestManager.getTest().log(Status.PASS, "Navigated to URL: "+url);
    }

    public static void writeToReport(String comment) {
        ExtentTestManager.getTest().log(Status.INFO, comment);
    }

    public static void isDisplayed(String objectLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement radioElem = driver.findElement(By.xpath(objectLocator));
        By locator = By.xpath(objectLocator);
        radioElem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            boolean sel = radioElem.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ExtentTestManager.getTest().log(Status.PASS, "Object locator found: "+ objectLocator);
    }

    public static void pageRefresh() {
        pause(5000);
        try {
            driver.navigate().refresh();
            ExtentTestManager.getTest().log(Status.PASS, "Page Refreshed: "+ driver.getTitle());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pause(5000);
    }

    public static void selectByVisibleText(final String objectLocator, final String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By locator = By.xpath(objectLocator);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ExtentTestManager.getTest().log(Status.PASS, "Typed Text: "+text +" on Locator: "+objectLocator);
    }
}

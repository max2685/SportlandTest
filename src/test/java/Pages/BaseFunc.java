package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jsx;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void goToURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found by this locator", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assert.assertFalse("No elements found by this locator", driver.findElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollDownBy(int x, int y) {
        jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)");
    }

    public void driverQuit() {
        driver.quit();
    }

    public void pageSourceCheck(String name) {
        Assert.assertTrue("You are not on the right page", driver.getCurrentUrl().contains(name));
    }

    public void waitForJs() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.jsReturnsValue("(function watcher(ms){var start=new Date().getTime();" +
                "var end = start;while(end<start+ms){end=new Date().getTime();};" +
                "return 'complete';})(1000);return 'success';"));
    }

    public void findElementInListByNameAndClick(List<WebElement> listOfElements, String name) {
        this.waitForJs();
        listOfElements
                .stream()
                .filter(we -> we.getText().toLowerCase().contains(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No element found"))
                .click();
    }
}



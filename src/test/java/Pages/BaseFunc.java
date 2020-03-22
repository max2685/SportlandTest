package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {
    WebDriver driver;

    public BaseFunc(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToURL(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void scrollDown(int x, int y) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)");
    }

    public void scrollTo(int x, int y) {
        String script = "window.scrollTo(" + x + ", " + y + ");";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

}

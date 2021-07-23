package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static long timeOutInSeconds = Duration.ofSeconds(10)
            .toSeconds();
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public WebElement getElementByXpath(String xpath) {
        WebElement el;
        try {
            el = driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            el = null;
        }
        return el;
    }

}

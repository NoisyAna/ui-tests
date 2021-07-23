package pages;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

    private static Logger log = LogManager.getLogger(Log.class.getName());

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMyNameInfo() {
        WebElement element = getElementByXpath("//a[contains(@title, 'View my customer account')]");
        log.info("Element Customer First Name Input Found");
        return element;
    }

    public void validateIsMyInfoDisplayed() {
        Assert.assertTrue(getMyNameInfo().isDisplayed());
    }

}

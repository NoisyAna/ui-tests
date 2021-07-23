package pages;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static Logger log = LogManager.getLogger(Log.class.getName());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInLink() {
        WebElement element = waitForElementToBeVisible("//a[contains(@title, 'Log in to your customer account')]");
        log.info("Element Sign in Found");
        return element;
    }

    public WebElement getEmailAddressInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='email_create']");
        log.info("Element Email Input found");
        return element;
    }

    public WebElement getCreateAnAccountButton() {
        WebElement element = waitForElementToBeVisible("//button[@id='SubmitCreate']");
        log.info("Element Create An Account found");
        return element;
    }

    public void clickOnSignInLink() {
        getSignInLink().click();
        log.info("Clicked on Sign In Link");
    }

    public void setEmail(String email) {
        getEmailAddressInput().sendKeys(email);
        log.info("Email entered into email input");
    }

    public void clickOnCreateAnAccountButton() {
        getCreateAnAccountButton().click();
        log.info("Clicked on create and account button");
    }

    public void setEmailAndClickOnCreateAnAcc(String email) {
        setEmail(email);
        clickOnCreateAnAccountButton();
    }

}

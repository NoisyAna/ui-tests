package pages;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends BasePage {

    private static Logger log = LogManager.getLogger(Log.class.getName());

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNamePersonalInformationInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='customer_firstname']");
        log.info("Element Customer First Name Input Found");
        return element;
    }

    public WebElement getLastNamePersonalInformationInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='customer_lastname']");
        log.info("Element Customer Last Name Input Found");
        return element;
    }

    public WebElement getPasswordPersonalInformationInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='passwd']");
        log.info("Element Password Customer Input Found");
        return element;
    }

    public WebElement getAddressInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='address1']");
        log.info("Element Address Input Found");
        return element;
    }

    public WebElement getCityInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='city']");
        log.info("Element City Input Found");
        return element;
    }

    public WebElement getStateDropdown() {
        WebElement element = getElementByXpath("//select[@name='id_state']");
        log.info("Element State Input Found");
        return element;
    }

    public WebElement getZipCodeInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='postcode']");
        log.info("Element Zip Input Found");
        return element;
    }

    public WebElement getMobilePhoneInput() {
        WebElement element = waitForElementToBeVisible("//input[@id='phone_mobile']");
        log.info("Element Zip Input Found");
        return element;
    }

    public WebElement getRegisterButton() {
        WebElement element = waitForElementToBeVisible("//button[@id='submitAccount']");
        log.info("Element Register Button Found");
        return element;
    }

    public void insertIntoFirstNameAccInput(String firstName) {
        getFirstNamePersonalInformationInput().sendKeys(firstName);
        log.info("Entered first name into first name input");
    }

    public void insertIntolastNameAccInput(String lastName) {
        getLastNamePersonalInformationInput().sendKeys(lastName);
        log.info("Entered last name into last name input");
    }

    public void insertIntoPasswordInput(String password) {
        getPasswordPersonalInformationInput().sendKeys(password);
        log.info("Entered password into password input");
    }

    public void insertIntoAddressInput(String address) {
        getAddressInput().sendKeys(address);
        log.info("Entered address into address input");
    }

    public void insertIntoCityInput(String city) {
        getCityInput().sendKeys(city);
        log.info("Entered into city input");
    }

    public void selectState(String state) {
        Select stateName = new Select(getStateDropdown());
        stateName.selectByVisibleText(state);
        log.info("Selected state " + state);
    }

    public void insertIntoZipInput(String zip) {
        getZipCodeInput().sendKeys(zip);
        log.info("Entered zip into zip input");
    }

    public void insertIntoMobilePhoneInput(String mobilePhone) {
        getMobilePhoneInput().sendKeys(mobilePhone);
        log.info("Entered into mobile phone input");
    }

    public void clickOnRegisterButton() {
        getRegisterButton().click();
        log.info("Clicked on register button");
    }

    public void createAnAccount(String firstName, String lastName, String password, String Address, String City,
            String State, String Zip, String mobilePhone) {
        insertIntoFirstNameAccInput(firstName);
        insertIntolastNameAccInput(lastName);
        insertIntoPasswordInput(password);
        insertIntoAddressInput(Address);
        insertIntoCityInput(City);
        selectState(State);
        insertIntoZipInput(Zip);
        insertIntoMobilePhoneInput(mobilePhone);
        clickOnRegisterButton();
    }

}

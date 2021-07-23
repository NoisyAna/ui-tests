import java.time.Duration;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

/**
 * Steps 1. Navigate to http://automationpractice.com/index.php 2. Click on sign in link 3. In "Email address" input
 * enter valid email address 4. Click on "Create an account" button 5. In "Create an account" page fill all required
 * fields 6. Click on "Register" button 7. Verify that user is created
 */

public class RegisterUserTest {

    private static long timeOutInSeconds = Duration.ofSeconds(10)
            .toSeconds();
    WebDriver driver = new ChromeDriver();
    Faker faker = new Faker(new Random());
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
    HomePage homePage = new HomePage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @BeforeClass()
    public void setup() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage()
                .timeouts()
                .implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage()
                .window()
                .maximize();
    }

    @Test
    public void shouldBeAbleToRegisterAccount() {

        var email = fakeValuesService.letterify("??????@testemail.com");
        var firstName = faker.name()
                .firstName();
        var lastName = faker.name()
                .lastName();
        var password = "Test1234";
        var address = faker.address()
                .fullAddress();
        var city = faker.address()
                .cityName();
        var state = "Alabama";
        var zip = "12345";
        var mobilePhone = faker.phoneNumber()
                .cellPhone();

        homePage.clickOnSignInLink();
        homePage.setEmailAndClickOnCreateAnAcc(email);
        createAnAccountPage.createAnAccount(firstName, lastName, password, address, city, state, zip, mobilePhone);
        myAccountPage.validateIsMyInfoDisplayed();

    }

    @AfterClass()
    public void tearDown() {
        driver.close();
    }

}

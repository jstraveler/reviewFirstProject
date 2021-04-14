import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseClass{
    private static final String loginURL = "https://ok.ru/";
    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = driverInit();
    }

    @Test
    public void testLoginIn() {
        LoginPage loginPage = new LoginPage(driver);
        //login, password указываешь чтобы зайти
        UserPage userPage = loginPage.doLogin("awdawdaw", "awdawdaw");
        Assert.assertTrue("true", driver.getCurrentUrl().equals(loginURL));
    }

    @AfterAll
    public static void  down() {
        driverDown(driver);
    }
}

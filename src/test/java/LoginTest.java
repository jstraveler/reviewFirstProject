import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseClass{
    private WebDriver driver;

    @Before
    public void init() {
        driver = driverInit();
    }

    @Test
    public void testLoginIn() {
        LoginPage loginPage = new LoginPage(driver);
        //login, password указываешь чтобы зайти
        UserPage userPage = loginPage.doLogin("", "");
        MessagesPage messagesPage = userPage.getMessagesPage();
    }

    @After
    public void  down() {
        driverDown(driver);
    }
}

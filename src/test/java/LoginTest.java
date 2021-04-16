import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import wrapper.FriendWrapper;
import wrapper.MessageWrapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseClass{
    private WebDriver driver;

    @Before
    public void init() {
        driver = driverInit();
    }

    @Test
    public void testLoginIn() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.doLogin("", "");
        MessagesPage messagesPage = userPage.getMessagesPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FriendsElement friendsElement = messagesPage.getFriendsElement();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<FriendWrapper> friendsElementList = friendsElement.getFriendList();
        friendsElementList.get(0).choose();
        MessagesElement messagesElement = messagesPage.getMessagesElement();
        List<MessageWrapper> messageWrapperList = messagesElement.getListMessages();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(messageWrapperList.get(0).getText());
    }

    @After
    public void  down() {
        driverDown(driver);
    }
}

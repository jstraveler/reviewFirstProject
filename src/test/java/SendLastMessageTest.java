import element.FriendsElement;
import element.MessagesElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.BaseClass;
import page.LoginPage;
import page.MessagesPage;
import page.UserPage;
import wrapper.FriendWrapper;
import wrapper.MessageWrapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendLastMessageTest extends BaseClass {
    private WebDriver driver;
    private UserPage userPage;

    @Before
    public void init() {
        driver = driverInit();
        LoginPage loginPage = new LoginPage(driver);
        userPage = loginPage.doLogin("", "");
    }

    @Test
    public void testSendLastMessage() {
        MessagesPage messagesPage = userPage.getMessagesPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FriendsElement friendsElement = messagesPage.getFriendsElement();
        List<FriendWrapper> friendsElementList = friendsElement.getFriendList();
        for (FriendWrapper friendWrapper : friendsElementList) {
            if (friendWrapper.getFullName().equals("")) {
                friendWrapper.choose();
                break;
            }
        }
        MessagesElement messagesElement = messagesPage.getMessagesElement();
        List<MessageWrapper> messageWrapperList = messagesElement.getListMessages();
        messageWrapperList.get(0).sendMessage("", driver);
        Assert.assertNotEquals("Test sendLastMessage has errors", messageWrapperList.get(1).getText(), messageWrapperList.get(0).getText());
    }

    @After
    public void  down() {
        driverDown(driver);
    }
}

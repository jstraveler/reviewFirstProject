import org.openqa.selenium.WebDriver;

public class MessagesPage {
    //не проверен
    private static final String LOCATOR_FRIENDS_TOOLBAR = ".//*[@id=\"msg_layer\"]//msg-app/main/msg-page/div/msg-chats-panel/div/msg-chats-list";
    //не проверен
    private static final String LOCATOR_MESSAGES_TOOLBAR = "//*[@id=\"msg_layer\"]//msg-app/main/msg-page/div/msg-chat/main/section/div";
    private WebDriver driver;

    public MessagesPage(WebDriver driver) {
        this.driver = driver;
    }
}

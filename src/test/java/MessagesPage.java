import org.openqa.selenium.WebDriver;

public class MessagesPage {
    private WebDriver driver;

    public MessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public FriendsElement getFriendsElement() {
        return new FriendsElement(driver);
    }

    public MessagesElement getMessagesElement() {
        return new MessagesElement(driver);
    }
}

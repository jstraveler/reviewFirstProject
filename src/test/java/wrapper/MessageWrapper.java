package wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MessageWrapper {
    private WebElement element;
    private String text;

    public MessageWrapper(WebElement element) {
        this.element = element;
        this.text = element.findElement(By.cssSelector("msg-parsed-text")).getText();
    }

    public String getText() {
        return text;
    }

//    public boolean deleteMessage() {
//
//    }

//    public void sendMessage(FriendWrapper friend) {}
}

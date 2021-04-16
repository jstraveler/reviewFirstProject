package wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FriendWrapper {
    private WebElement element;

    public FriendWrapper(WebElement webElement) {
        this.element = webElement;
    }

    public String getFullName() {
        return element.findElement(By.xpath(".//msg-parsed-text")).getText();
    }

    public void choose() {
        element.click();
    }
}

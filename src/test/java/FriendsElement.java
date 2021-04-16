import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrapper.FriendWrapper;

import java.util.ArrayList;
import java.util.List;

public class FriendsElement {
    private WebElement rootElem;
    private WebDriver driver;

    public FriendsElement(WebDriver driver) {
        this.driver = driver;
        findRootElement();
    }

    private void findRootElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) js.executeScript("return document.querySelector(\"#msg_layer\").shadowRoot");
        rootElem = shadowDom.findElement(By.cssSelector("msg-app"));
    }

    public List<FriendWrapper> getFriendList() {
        List<WebElement> webElementList = rootElem.findElements(By.cssSelector("msg-chats-list-item"));
        List<FriendWrapper> friendWrapperList = new ArrayList<>();
        for (WebElement elem: webElementList) {
            friendWrapperList.add(new FriendWrapper(elem));
        }
        return friendWrapperList;
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrapper.MessageWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagesElement {
    private WebElement rootElem;
    private WebDriver driver;


    public MessagesElement(WebDriver driver) {
        this.driver = driver;
        findRootElement();
    }

    private void findRootElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) js.executeScript("return document.querySelector(\"#msg_layer\").shadowRoot");
        this.rootElem = shadowDom.findElement(By.cssSelector("msg-message-list"));
    }

    public List<MessageWrapper> getListMessages() {
        List<WebElement> webElementList = rootElem.findElements(By.cssSelector("msg-message"));
        List<MessageWrapper> messageWrapperList = new ArrayList<>();
        for (WebElement elem : webElementList) {
            messageWrapperList.add(new MessageWrapper(elem));
        }
        Collections.reverse(messageWrapperList);
        return messageWrapperList;
    }


}

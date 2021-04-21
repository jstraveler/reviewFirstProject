package wrapper;

import element.ChatPickerElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MessageWrapper {
    private static final String CSS_SELECTOR_TEXT = "msg-parsed-text";
    private static final String CSS_SELECTOR_MESSAGE_MENU_OPTION = "main > msg-button:nth-child(3)";
    private static final String CSS_SELECTOR_MESSAGE_MENU_SEND = "main > msg-button:nth-child(2)";
    private static final String CSS_SELECTOR_MESSAGE_MENU_OPTION_DELETE = "msg-menu-item.delimiter";
    private static final String CSS_SELECTOR_DELETE_BUTTON_CONFIRM = "msg-button[data-tsid=confirm-primary]";
    private static final String CSS_SELECTOR_SEARCH_INPUT = "msg-input";
    private static final String CSS_SELECTOR_SEND_MESSAGE_CONFIRM = "msg-button[data-tsid=forward_btn]";
    private WebElement element;
    private WebElement shadowRoot;
    private String text;

    public MessageWrapper(WebElement element, WebElement shadowRoot) {
        this.element = element;
        this.shadowRoot = shadowRoot;
        this.text = element.findElement(By.cssSelector(CSS_SELECTOR_TEXT)).getText();
    }

    public String getText() {
        return text;
    }

    /* метод сделан
    Антуфьев Семен
    * */
    public void deleteLastMessage(WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement helpElement = element;
        actions.moveToElement(helpElement).click().perform();
        helpElement = helpElement.findElement(By.cssSelector(CSS_SELECTOR_MESSAGE_MENU_OPTION));
        actions.moveToElement(helpElement).click().perform();
        actions.moveToElement(shadowRoot.findElement(By.cssSelector(CSS_SELECTOR_MESSAGE_MENU_OPTION_DELETE))).click().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.moveToElement(shadowRoot.findElement(By.cssSelector(CSS_SELECTOR_DELETE_BUTTON_CONFIRM))).click().perform();
    }

    /* метод сделан
    Шестакова Алина
    * */
    public void sendMessage(String fullName, WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement helpElement = element;
        actions.moveToElement(helpElement).click().perform();
        helpElement = helpElement.findElement(By.cssSelector(CSS_SELECTOR_MESSAGE_MENU_SEND));
        actions.moveToElement(helpElement).click().perform();
        /** вместо sleep лучше сделать проверку на наличие элемента или неявное ожидание **/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(shadowRoot.findElement(By.cssSelector(CSS_SELECTOR_SEARCH_INPUT))).sendKeys(fullName).perform();

        ChatPickerElement chatPickerElement = new ChatPickerElement(driver);
        List<ChatPickerWrapper> chatPickerWrapperList = chatPickerElement.getChatPickerList();
        for (ChatPickerWrapper chatPickerWrapper : chatPickerWrapperList) {
            if (chatPickerWrapper.getFullName().equals(fullName)) {
                chatPickerWrapper.choose();
                break;
            }
        }
        actions.moveToElement(shadowRoot.findElement(By.cssSelector(CSS_SELECTOR_SEND_MESSAGE_CONFIRM))).click().perform();
    }
}

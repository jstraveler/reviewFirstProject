import org.openqa.selenium.WebDriver;

public class UserPage {
    private static final String LOCATOR_FRIENDS_ICON = ".//div[@data-module='ToolbarManager']//li[@data-l='t,friends']";
    private WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    public static WebDriver driverInit() {
        //путь до драйвера указывать свой?
        System.setProperty("webdriver.chrome.driver", "C:/configs/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void driverDown(WebDriver driver) {
        driver.quit();
    }

}

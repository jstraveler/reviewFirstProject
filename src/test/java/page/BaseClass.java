package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**От BaseClass наследуется и ветка PageObject и ветка Test, у каждой ветки дб свой базовый класс**/
public class BaseClass {

    public WebDriver driverInit() {
        System.setProperty("webdriver.chrome.driver", "C:/configs/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }

    public void driverDown(WebDriver driver) {
        driver.quit();
    }

}

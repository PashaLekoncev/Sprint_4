import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        // Поднятие браузера Chrome или Firefox
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

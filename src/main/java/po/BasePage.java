package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import po.constans.Urls;

// Базовый класс всех страниц
public class BasePage {
    protected WebDriver driver;
    protected String url;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.url = Urls.MAIN_PAGE_URL;
    }

    public BasePage open() {
        driver.get(this.url);
        closeCookieAlert();
        return this;
    }

    public void closeCookieAlert(){
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }
}

package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static java.lang.String.format;

public class MainPage extends BasePage {

    // Список элементов акктардиона
    private final By helpAccordionElements = new By.ByClassName("accordion__item");

    // Кнопка Заказа в шапке сайта
    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");

    // Кнопка Заказа в футере сайта
    private final By footerOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(this.url);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        return this;
    }

    public MainPage helpAccordionClickByIndex(int index) {
        List<WebElement> accordionElements =  driver.findElements(helpAccordionElements);
        WebElement accordionElement = accordionElements.get(index);
        accordionElement.click();
        return this;
    }
    public boolean labelIsVisible(String textMessage) {
        By accordionLabel = By.xpath(format(".//div[@class='accordion__panel']/p[text()='%s']", textMessage));
        return !driver.findElements(accordionLabel).isEmpty();
    }

        public OrderPage headerOrderButtonClick(){
        driver.findElement(headerOrderButton).click();
        return new OrderPage(driver);
    }

    public OrderPage footerOrderButtonClick(){
        driver.findElement(footerOrderButton).click();
        return new OrderPage(driver);
    }
}

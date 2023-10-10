package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import po.constans.Urls;

import static java.lang.String.format;

public class OrderPage extends BasePage {

    // Инпут ввода Имени
    private final By firstNameInput = By.cssSelector("[placeholder=\"* Имя\"]");

    // Инпут ввода Фамилии
    private final By secondNameInput = By.cssSelector("[placeholder=\"* Фамилия\"]");

    // Инпут ввода адреса
    private final By addressInput = By.cssSelector("[placeholder=\"* Адрес: куда привезти заказ\"]");

    // Инпут ввода станции метро
    private final By metroStationInput = By.cssSelector("[placeholder=\"* Станция метро\"]");

    // Инпут ввода номера телефона
    private final By phoneNumberInput = By.cssSelector("[placeholder=\"* Телефон: на него позвонит курьер\"]");

    // Кнопка "Далее" для перехода на следующий шаг заказа
    private final By nextStepButton = By.xpath(".//button[text()='Далее']");

    // Инпут ввода 'Когда привезти самокат'
    private final By deliveryDateInput = By.cssSelector("[placeholder=\"* Когда привезти самокат\"]");

    // Селект выбора периода аренды
    private final By rentalPeriodDropdown = By.cssSelector("span.Dropdown-arrow");

    // Опции в дропдауне
    private final By rentalPeriodOptionsMenu = By.xpath(".//div[@class='Dropdown-menu']");

    // Блок выбора цвета самоката
    private final By colorsBlock = By.cssSelector(".Order_Checkboxes__3lWSI");

    // Инпут комментария для курьера
    private final By commentForCourierInput = By.cssSelector("[placeholder=\"Комментарий для курьера\"]");

    // Кнопка Заказать
    private final By toOrderButton = By
            .xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Кнопка подтверждения заказа в модальном окне
    private final By confirmOrderButton = By
            .xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

    // Модальное окно success-page с текстом что 'Заказ оформлен'
    private final By successMessage = By
            .xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        super(driver);
        this.url = Urls.ORDER_PAGE_URL;
    }

    public OrderPage fillFirstNameInput(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public OrderPage fillSecondNameInput(String secondName){
        driver.findElement(secondNameInput).sendKeys(secondName);
        return this;
    }

    public OrderPage fillAddressInput(String address){
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderPage metroStationInputClick(){
        driver.findElement(metroStationInput).click();
        return this;
    }

    public OrderPage nextStepButtonClick(){
        driver.findElement(nextStepButton).click();
        return this;
    }

    public OrderPage selectMetroStationByName(String metroStationName){
        metroStationInputClick();
        new Actions(driver)
                .sendKeys(metroStationName)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
        return this;
    }

    public OrderPage fillPhoneNumberInput(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
        return this;
    }

    public OrderPage fillDeliveryDateInput(String deliveryDate){
        driver.findElement(deliveryDateInput).sendKeys(deliveryDate);
        new Actions(driver).sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage selectRentalPeriodByName(String rentalPeriodName){
        driver.findElement(rentalPeriodDropdown).click();
        String xpathToSelectByName = format(".//div[text() = '%s']", rentalPeriodName);
        WebElement selectElement = driver.findElement(rentalPeriodOptionsMenu).findElement(By.xpath(xpathToSelectByName));
        selectElement.click();
        return this;
    }

    public OrderPage checkColorByName(String colorName){
        String xpathToCheckboxByName = format(".//label[text()='%s']", colorName);
        WebElement selectElement = driver.findElement(colorsBlock).findElement(By.xpath(xpathToCheckboxByName));
        selectElement.click();
        return this;
    }

    public OrderPage fillCommentForCourierInput(String commentForCourier){
        driver.findElement(commentForCourierInput).sendKeys(commentForCourier);
        return this;
    }

    public OrderPage approveOrder(){
        driver.findElement(toOrderButton).click();
        driver.findElement(confirmOrderButton).click();
        return this;
    }

    public boolean successMessageIsDisplayed(){
        return !driver.findElements(successMessage).isEmpty();
    }

    public boolean fillForm(
                String firstName,
                String secondName,
                String address,
                String metroStationName,
                String phoneNumber,
                String deliveryDate,
                String rentalPeriodName,
                String colorName,
                String commentForCourier
    ) {
        return fillFirstNameInput(firstName)
            .fillSecondNameInput(secondName)
            .fillAddressInput(address)
            .selectMetroStationByName(metroStationName)
            .fillPhoneNumberInput(phoneNumber)
            .nextStepButtonClick()
            .fillDeliveryDateInput(deliveryDate)
            .selectRentalPeriodByName(rentalPeriodName)
            .checkColorByName(colorName)
            .fillCommentForCourierInput(commentForCourier)
            .approveOrder()
            .successMessageIsDisplayed();
    }
}

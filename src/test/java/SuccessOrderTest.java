import org.junit.Assert;
import org.junit.Test;
import po.MainPage;
import po.constans.PersonalData;


public class SuccessOrderTest extends BaseTest {

    @Test
    public void successOrderOnHeaderTest() {
        boolean isSuccessOrder = new MainPage(driver)
            .open()
            .headerOrderButtonClick()
            .fillForm(
                PersonalData.FIRST_NAME,
                PersonalData.SECOND_NAME,
                PersonalData.ADDRESS,
                PersonalData.METRO_STATIONS_LIST[0],
                PersonalData.PHONE_NUMBER,
                PersonalData.DELIVERY_DATE,
                PersonalData.RENTAL_PERIODS_LIST[0],
                PersonalData.COLORS_LIST[0],
                PersonalData.COMMENT_FOR_COURIER
        );
        Assert.assertTrue("Успешный заказ через кнопку 'Заказать' в шапке не оформился!!!", isSuccessOrder);
    }

    @Test
    public void successOrderOnFooterTest() {
        boolean isSuccessOrder = new MainPage(driver)
            .open()
            .footerOrderButtonClick()
            .fillForm(
                PersonalData.FIRST_NAME,
                PersonalData.SECOND_NAME,
                PersonalData.ADDRESS,
                PersonalData.METRO_STATIONS_LIST[1],
                PersonalData.PHONE_NUMBER,
                PersonalData.DELIVERY_DATE,
                PersonalData.RENTAL_PERIODS_LIST[6],
                PersonalData.COLORS_LIST[1],
                PersonalData.COMMENT_FOR_COURIER
            );
        Assert.assertTrue("Успешный заказ через кнопку 'Заказать' в футере не оформился!!!", isSuccessOrder);
    }
}

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;


@RunWith(Parameterized.class)
public class QuestionsAboutImportantTest extends BaseTest {
    private final int indexOnAccordion;
    private final String message;

    @Parameterized.Parameters(name = "После нажатия в аккардионе на элемент с индексом '{0}' появляется сообщение {1}")
    public static Object[][] getData() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." },
        };
    }

    public QuestionsAboutImportantTest(int indexOnAccordion, String message) {
        this.indexOnAccordion = indexOnAccordion;
        this.message = message;
    }

    @Test
    public void questionsAboutImportantAfterClickTextIsVisible() {
        boolean result = new MainPage(driver)
            .open()
            .helpAccordionClickByIndex(indexOnAccordion)
            .labelIsVisible(message);
        Assert.assertTrue("Не выводится сообщение при нажатии на элемент в аккардионе", result);
    }

}

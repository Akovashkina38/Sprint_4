import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.FAQHomePage;
import ru.yandex.practicum.HomePage;
import ru.yandex.practicum.OrderPage;
import ru.yandex.practicum.OrderPageRent;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest {

    WebDriver driver;

    private final String
            name,
            firstname,
            address,
            phone,
            comment;

    public OrderTest(String name, String firstname, String address, String Phone, String comment) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.phone = Phone;
        this.comment = comment;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Саша", "Аковаша", "ул.Культуры д.26", "+79111003437", "Позвоните "},
                {"Вася", "Петров", "ул.Петрушина д.2", "+79111003639", "Проверьте за час до приезда"},
        };

      }
    @Before
    public void startSamokat() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        FAQHomePage faqHomePage = new FAQHomePage(driver);
        faqHomePage.clickCloseCookies();
    }
    @Test
    public void checkOrderFromHeader_success() {

        HomePage homePage = new HomePage(driver);
        homePage.clickButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputParams(name, firstname, address, phone);
        orderPage.buttonNext();

        OrderPageRent orderPageRent = new OrderPageRent(driver);
        orderPageRent.inputParams(comment);

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPageRent.isOrderCreated());
    }

    @Test
    public void checkOrderFromRoadMapSection_success() {

        HomePage homePage = new HomePage(driver);
        homePage.clickButtonBellow();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputParams(name, firstname, address, phone);
        orderPage.buttonNext();

        OrderPageRent orderPageRent = new OrderPageRent(driver);
        orderPageRent.inputParams(comment);

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPageRent.isOrderCreated());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

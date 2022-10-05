import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.FAQHomePage;

import static ru.yandex.practicum.constants.Text.*;

@RunWith(Parameterized.class)
public class FAQanswerTest {


    WebDriver driver;
    FAQHomePage page;

    private final String constantText;
    private final int index;



    public FAQanswerTest(String constantText, int index) {
             this.constantText = constantText;
             this.index = index;


    }


    @Parameterized.Parameters
    public static Object[][] getFAQanswerTest() {
        return new Object[][]{
                {FIRST_TEXT, 0},
                {SECOND_TEXT, 1},
                {THIRD_TEXT, 2},
                {FOURTH_TEXT, 3},
                {FIFTH_TEXT, 4},
                {SIXTH_TEXT, 5},
                {SEVENTH_TEXT, 6},
                {EIGHTH_TEXT, 7},
        };
    }

    @Before
    public void openSamokat() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //открыть страницу самокат
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 5);
        //создать объект класса домашней странице
        page = new FAQHomePage(driver);
        //нажать кнопку закрытие кук
        page.clickCloseCookies();
        page.scrollQuestions();

    }

    @Test
    public void checkAnswerText0() {
        FAQHomePage faqHomePage = new FAQHomePage(driver);
        faqHomePage.clickOnQuestion(index);
        boolean actual = faqHomePage.isAnswerVisible(constantText, index);
        Assert.assertTrue(actual);
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}










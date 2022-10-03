
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.practicum.FAQHomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;




public class FAQanswerTest {

    WebDriver driver;
    FAQHomePage page;

    @Before
    public void OpenSamokat() {
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
        page.clickOnQuestion(0);
        Assert.assertTrue("тест ошибки", page.isPanelVisible(0));
    }

    @Test
    public void checkAnswerText1() {
        page.clickOnQuestion(1);
        Assert.assertTrue(page.isPanelVisible(1));
    }

    @Test
    public void checkAnswerText2() {
        page.clickOnQuestion(2);
        Assert.assertTrue(page.isPanelVisible(2));
    }

    @Test
    public void checkAnswerText3() {
        page.clickOnQuestion(3);
        Assert.assertTrue(page.isPanelVisible(3));
    }

    @Test
    public void checkAnswerText4() {
        page.clickOnQuestion(4);
        Assert.assertTrue(page.isPanelVisible(4));
    }

    @Test
    public void checkAnswerText5() {
        page.clickOnQuestion(5);
        Assert.assertTrue(page.isPanelVisible(5));
    }

    @Test
    public void checkAnswerText6() {
        page.clickOnQuestion(6);
        Assert.assertTrue(page.isPanelVisible(6));
    }

    @Test
    public void checkAnswerText7() {
        page.clickOnQuestion(7);
        Assert.assertTrue(page.isPanelVisible(7));
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

}










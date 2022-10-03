package ru.yandex.practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class HomePage {
    private final static By
    //кнопка "Заказать" вверху страницы
            BUTTON_ORDER_HEADER = cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g"),
    //кнопка "Заказать" внизу страницы
            BUTTON_ORDER_BELOW = cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private boolean isOrderButton(){
        return (driver.findElement(BUTTON_ORDER_HEADER) != null);
    }
    private void clickHeaderOrderButton() {
        driver.findElement(BUTTON_ORDER_HEADER).click();
    }

    private void checkOrderButtonRoadMapClickable() {
        new WebDriverWait(driver, (5)).until(ExpectedConditions.elementToBeClickable(BUTTON_ORDER_BELOW));
    }

    private void scrollToOrderButtonRoadMap() {
        new WebDriverWait(driver, (5)).until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ORDER_BELOW));
        // Поиск элемента с кнопкой заказа из секции с road_map и скролл до нее

        WebElement elementOrderButton = driver.findElement(BUTTON_ORDER_BELOW);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementOrderButton);
    }
    private void clickRoadMapOrderButton() {
        driver.findElement(BUTTON_ORDER_BELOW).click();
    }
    public void clickButtonHeader(){
        Assert.assertTrue("Кнопка не найдена", isOrderButton());
        clickHeaderOrderButton();
    }
    public void clickButtonBellow(){
        scrollToOrderButtonRoadMap();
        clickRoadMapOrderButton();
    }
}

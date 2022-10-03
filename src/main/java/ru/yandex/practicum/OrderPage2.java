package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class OrderPage2 {
    private final By

    DATE = xpath("//div[@class='Order_Form__17u6u']/div/div/div/input"),  //форма заказа: поле для ввода даты

    RENTAL_PERIOD = xpath("//div[@class='Dropdown-control']"), //форма заказа: поле выбора периода аренды, раскрытие выпадающего списка

    RENTAL_PERIOD_CHOICE = xpath("//div[@class='Dropdown-menu']/div[2]"), //форма заказа: поле выбра периода аренды, выбор элемента списка

    COLOR = xpath("//div[@class='Order_Checkboxes__3lWSI']/label[1]"), //форма заказа: выбор цвета для тестового набора 1
    COMMENT = xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"),  //форма заказа: поле ввода комментария
    ORDER_FORM_BUTTON = xpath("//div[@class='Order_Buttons__1xGrp']/button[2]"), //форма заказа: кнопка "Заказать" в конце формы
    ORDER_CONFIRM_BUTTON = xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]"), //модальное окно подтверждения заказа, кнопка "Да"
    ORDER_CREATED_SUCCESSFULLY = xpath("//*[contains(text(), 'Заказ оформлен')]"); //модальное окно: Заказ оформлен

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
    private final WebDriver driver;

    public OrderPage2 (WebDriver driver){
        this.driver = driver;
    }
    public void date() {
        driver.findElement(DATE).click();
        driver.findElement(DATE).sendKeys(date);
        driver.findElement(DATE).sendKeys(Keys.ENTER);

    }

    public void rentalPeriod() {
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(RENTAL_PERIOD_CHOICE).click();
    }

    public void color() {
        driver.findElement(COLOR).click();
    }

    public void comment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }

    public void orderFormButton() {
        driver.findElement(ORDER_FORM_BUTTON).click();
    }

    public void orderConfirmButton() {
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }

    public boolean isOrderCreated() {
        try {
            return driver.findElement(ORDER_CREATED_SUCCESSFULLY).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void inputParams(String comment) {
        comment(comment);
        date();
        rentalPeriod();
        color();
        orderFormButton();
        orderConfirmButton();
    }
}


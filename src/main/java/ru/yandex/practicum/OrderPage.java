package ru.yandex.practicum;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class OrderPage {

    private final static By
    //окно заказа 1: поле ввода имени
    NAME = xpath("//div[@class='Order_Form__17u6u']/div[1]/input"),
    //окно заказа 1: поле ввода фамилии
    FIRSTNAME = xpath("//div[@class='Order_Form__17u6u']/div[2]/input"),
    //окно заказа 1: поле ввода адреса
    ADDRESS = xpath("//div[@class='Order_Form__17u6u']/div[3]/input"),
    PHONE = xpath("//div[@class='Order_Form__17u6u']/div[5]/input"), //форма заказа: поле ввода телефона
    STATION = xpath("//div[@class='Order_Form__17u6u']/div[4]"), //форма заказа: поле выбра станции, раскрытие выпадающего списка
    STATION_CHOICE = xpath("//div[@class='select-search__select']/ul/li/button/div[2]"), //форма заказа: поле выбра станции, выбор элемента списка для тестового набора 1
    BUTTON_NEXT = cssSelector("div.Order_NextButton__1_rCA > button.Button_Middle__1CSJM"); //форма заказа: кнопка "Далее", для перехода на 2ую страницу формы

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //public void clickCloseCookies() {
    // By closeCookies = By.id("rcc-confirm-button");
    //  driver.findElement(closeCookies).click();
    // }


    public void name(String name) {
        driver.findElement(NAME).sendKeys(name);
    }

    public void firstname(String firstname) {
        driver.findElement(FIRSTNAME).sendKeys(firstname);
    }

    public void address(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }

    public void phone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);
    }

    public void station() {
        driver.findElement(STATION).click();
    }

    public void stationChoice() {
        driver.findElement(STATION_CHOICE).click();
    }

    public void buttonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }

    public void inputParams(String name, String firstname, String address, String phone) {
        name(name);
        firstname(firstname);
        address(address);
        phone(phone);
        station();
        stationChoice();
    }

}
//public void clickCloseCookies() {
// By closeCookies = By.id("rcc-confirm-button");
//  driver.findElement(closeCookies).click();
// }












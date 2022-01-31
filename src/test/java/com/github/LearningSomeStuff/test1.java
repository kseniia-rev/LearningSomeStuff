package com.github.LearningSomeStuff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/KsuNepomniashchaia/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://tartecosmetics.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement cookies_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        cookies_button.click();
    }
}

package com.github.LearningSomeStuff;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        cookiesButton.click();

        sleep();
        
        WebElement noThanksButton = null;
        try {
            noThanksButton = driver.findElements(By.className("bx-button")).get(3);
        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }
        var j = (JavascriptExecutor) driver;
        
        j.executeScript("$(arguments[0]).click()", noThanksButton);
        WebElement signInButton = driver.findElement(By.className("signin-section"));
        signInButton.click();
        String actualUrl = driver.getCurrentUrl();
        String signInPageUrl = "https://tartecosmetics.com/shop/login?original=%2Fshop%2Fauthiframe%3Fformat%3Dajax";
        System.out.println(actualUrl.equals(signInPageUrl));

    }



    private static void sleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

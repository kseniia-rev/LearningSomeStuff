package com.github.LearningSomeStuff;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriverWait wait;
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public HomePage get() {
        driver.get("https://tartecosmetics.com/");
        handleCookies(wait);
        return new HomePage(driver);
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.className("signin-section"));
        signInButton.click();
    }

    private void handleCookies(WebDriverWait wait) {
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
    }

    private static void sleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

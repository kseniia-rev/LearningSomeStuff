package com.github.LearningSomeStuff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test1 {

    public WebDriver driver;

    @BeforeEach
    public void setup() {

        driver = new ChromeDriver();
    }

    @Test
    public void canNavigateToRewards() {
        HomePage homePage = new HomePage(driver);
        homePage.get();

    }
    @Test
    public void customerCanLogin() throws FileNotFoundException {
        HomePage homePage = new HomePage(driver);
        homePage.get().clickSignInButton();

        String actualUrl = driver.getCurrentUrl();
        String signInPageUrl = "https://tartecosmetics.com/shop/login?original=%2Fshop%2Fauthiframe%3Fformat%3Dajax";
        System.out.println(actualUrl.equals(signInPageUrl));

        WebElement emailAddressField = driver.findElement(By.id("dwfrm_login_username"));
        WebElement passwordField = driver.findElement(By.id("dwfrm_login_password"));
        WebElement loginButton = driver.findElement(By.className("btn-checkout"));

        String filePath = "C:\\Users\\KsuNepomniashchaia\\LearningSomeStuff\\src\\test\\java\\com\\github\\LearningSomeStuff\\creds.txt";
        File creds = new File(filePath);
        Scanner scanner = new Scanner(creds);
        String emailAddress = scanner.nextLine();
        String password = scanner.nextLine();
        emailAddressField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        loginButton.click();


        String expectedUrl = "https://tartecosmetics.com/shop/myaccount";
        System.out.println(expectedUrl.equals(driver.getCurrentUrl()));

        driver.quit();
    }
}

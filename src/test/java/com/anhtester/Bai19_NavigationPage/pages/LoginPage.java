package com.anhtester.Bai19_NavigationPage.pages;

import com.anhtester.locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BaseTest)
    public LoginPage(WebDriver driver){
        this.driver = driver; //this để chỉ thành phần trong nội tại class
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Khai báo tất cả các object (element) trong page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");
    //Xây dựng các hàm xử lý trên chính page này

    private void setInputEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
        System.out.println("Set email value: " + email);
    }

    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
        System.out.println("Set password value: " + password);

    }

    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
        System.out.println("Click on Login Button: " + buttonLogin);

    }

//    public void loginCRM(String email, String password){
//        driver.get(url);
//        System.out.println("Navigate to URL: "+ url);
//        setInputEmail(email);
//        setInputPassword(password);
//        clickButtonLogin();
//    }

    public DashboardPage loginCRM(String email, String password){
        driver.get(url);
        System.out.println("Navigate to URL: "+ url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();

        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess(){
        System.out.println("Verify Login success");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void verifyLoginFail(){
        System.out.println("Verify Login fail");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error Message is not displayed");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Error Message is not displayed");
    }

}

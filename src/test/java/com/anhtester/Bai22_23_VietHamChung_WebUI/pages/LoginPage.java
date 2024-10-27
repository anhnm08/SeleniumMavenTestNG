package com.anhtester.Bai22_23_VietHamChung_WebUI.pages;

import com.anhtester.keywords.WebUI;
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
        new WebUI(driver); //Bắt buộc có trong từng class Page để khai báo, truyền driver vào thì mới không null
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
//        driver.findElement(inputEmail).sendKeys(email);
//        System.out.println("Set email value: " + email);
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
//        driver.findElement(inputPassword).sendKeys(password);
//        System.out.println("Set password value: " + password);
        WebUI.setText(inputPassword, password);

    }

    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
//        driver.findElement(buttonLogin).click();
//        System.out.println("Click on Login Button: " + buttonLogin);
        WebUI.clickElement(buttonLogin);

    }

    public DashboardPage loginCRM(String email, String password){
        WebUI.openURL(url);
        //System.out.println("Navigate to URL: "+ url);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();

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

    public void verifyRedirectLoginPage(){
        System.out.println("Verify Redirect to Login Page");
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed(), "Header Login page is not displayed");
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(), "Login", "Content of header Login page is not displayed");
    }

}

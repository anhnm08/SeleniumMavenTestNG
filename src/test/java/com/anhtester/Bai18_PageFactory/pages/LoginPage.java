package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BaseTest)
    public LoginPage(WebDriver driver){
        this.driver = driver; //this để chỉ thành phần trong nội tại class
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Khai báo tất cả các object (element) trong page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    //By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
//    By inputEmail = By.xpath("//input[@id='email']");
//    By inputPassword = By.xpath("//input[@id='password']");
//    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerLoginPage;

//    @FindBy(xpath = "//input[@id='email']")
//    private WebElement inputEmail;

    @FindAll (
            {
                    @FindBy(xpath = "//input[@id='email123']"),
                    @FindBy(id = "email")
            }
    )
    private WebElement inputEmail;
//Dùng FindAll để tìm kiếm 1 element dựa trên nhiều tiêu chí, chỉ cần 1 tiêu chí tồn tại thì sẽ tìm thấy element dù các tiêu chí khác sai
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='text-center alert alert-danger']")
    private WebElement errorMessage;

    @FindBy(xpath = "//ul[@id='side-menu']//span[normalize-space()='Dashboard']")
    private WebElement menuDashboard;

    //khi cần tìm danh sách các phần tử trên một trang (findElements) thì chúng ta dùng @FindBys như sau
    @FindBys(@FindBy(xpath="d//ul[@id='side-menu']/li/a"))
    private List<WebElement> listMenu;
// Tương ứng với câu lệnh sau
    List<WebElement> listMenu2 = driver.findElements(By.xpath("d//ul[@id='side-menu']/li/a"));

    public void getListMenu(){
        for(int i = 0; i< listMenu.size(); i++){
            System.out.println(listMenu.get(i).getText());
        }
    }

    /* Page Factory thiết kế các element theo đối tượng WebElement
     nên có 1 số hàm trong cơ chế Waits không hỗ trợ Weblemennt mà chỉ hỗ trợ đối tượng By
    VD: visibilityOfElementLocated, presenceOfAllElementsLocatedBY
    Cần thay đổi thành các hàm như visibilityOf
    */

    //Xây dựng các hàm xử lý trên chính page này

    private void setInputEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
//        driver.findElement(inputEmail).sendKeys(email);
        inputEmail.sendKeys(email);
        System.out.println("Set email value: " + email);
    }

    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
//        driver.findElement(inputPassword).sendKeys(password);
        inputPassword.sendKeys(password);
        System.out.println("Set password value: " + password);

    }

    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOf(buttonLogin));
//        driver.findElement(buttonLogin).click();
        buttonLogin.click();
        System.out.println("Click on Login Button: " + buttonLogin);

    }

    public void loginCRM(String email, String password){
        driver.get(url);
        System.out.println("Navigate to URL: "+ url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
    }

    public void verifyLoginSuccess(){
        System.out.println("Verify Login success");
        Assert.assertTrue(menuDashboard.isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void verifyLoginFail(){
        System.out.println("Verify Login fail");
//        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error Message is not displayed");
//        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Error Message is not displayed");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error Message is not displayed");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Error Message is not displayed");
    }

}

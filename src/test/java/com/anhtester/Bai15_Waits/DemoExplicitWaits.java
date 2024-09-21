package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWaits {
    //Tạo 1 webdriver

    WebDriver driver;

    //Tạo 1 ghi chú @BeforeMethod
    @BeforeMethod
    public void setDriver(){
        // System.setProperty("webdriver.http.factory", "jdk-http-client"); // nếu bị lỗi ở window
        driver = new ChromeDriver();  //Khởi tạo Browser
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


    @Test(priority = 1)
    //Chỉ thị đây là 1 testcase, cứ hàm có 1 @Test phía trước thì được hiểu là 1 TC và khi đó click chuột sẽ run được
    public void testLoginCRM_success() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.)

        driver.get("https://hrm.anhtester.com/");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//span[@class='ladda-label']")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Projects']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Projects']")));

        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")));
        driver.findElement(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Selenium Explicit Wait anhnm");

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='budget_hours']")));
        driver.findElement(By.xpath("//input[@name='budget_hours']")).sendKeys("5s");
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).click();
        Thread.sleep(2000);



    }

}

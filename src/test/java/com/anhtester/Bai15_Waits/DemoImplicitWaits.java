package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoImplicitWaits {

    //Tạo 1 webdriver

    WebDriver driver;

    //Tạo 1 ghi chú @BeforeMethod
    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();  //Khởi tạo Browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Thời gian chờ đợi tối đa khi tìm kiếm elemnet
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //Chờ đợi page load xong, công dụng khi chuyển trang
    }

    @AfterMethod
    public void closeDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//Reset thời gian tìm kiếm elemnet về 0
        driver.quit();
    }


    @Test(priority = 1)
    //Chỉ thị đây là 1 testcase, cứ hàm có 1 @Test phía trước thì được hiểu là 1 TC và khi đó click chuột sẽ run được
    public void testLoginCRM_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //Sau khi reset thời gian load ở closeDriver thì đặt thời gian load mới cho từng testcase
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email123']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 2)
    public void testLoginCRM_InvalidEmail(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin123@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Assert.assertEquals(driver.getTitle(), "Dashboard"); // Test case này cần là Fail vì Nghĩa là khi login failed thì phải ở lại nguyên trang login, ko thể vào dashboard
    }

    @Test(priority = 3)
    public void testLoginCRM_InvalidPassword(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
    //=> 1 class chạy được nhiều TC, muốn chạy từng TC thì run ở bên trong, chạy toàn bộ TC thì click chuột ở hàm chung để run all


}

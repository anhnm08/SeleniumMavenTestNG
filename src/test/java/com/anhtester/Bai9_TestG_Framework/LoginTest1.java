package com.anhtester.Bai9_TestG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest1 {

    //Tạo 1 webdriver

    WebDriver driver;

    //Tạo 1 ghi chú @BeforeMethod
    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();  //Khởi tạo Browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Thời gian chờ đợi tối đa khi tìm kiếm elemnet
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //Chờ đợi page load xong
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


    @Test   //Chỉ thị đây là 1 testcase, cứ hàm có 1 @Test phía trước thì được hiểu là 1 TC và khi đó click chuột sẽ run được
    public void testLoginCRM_success(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test
    public void testLoginCRM_InvalidEmail(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin123@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Assert.assertEquals(driver.getTitle(), "Dashboard"); // Test case này cần là Fail vì Nghĩa là khi login failed thì phải ở lại nguyên trang login, ko thể vào dashboard
    }

    @Test
    public void testLoginCRM_InvalidPassword(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
   //=> 1 class chạy được nhiều TC, muốn chạy từng TC thì run ở bên trong, chạy toàn bộ TC thì click chuột ở hàm chung để run all

}

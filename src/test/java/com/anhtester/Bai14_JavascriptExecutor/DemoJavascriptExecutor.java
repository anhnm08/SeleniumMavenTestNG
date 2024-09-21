package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test
    public void testJavascriptExecutor01(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
//        // Tắt Dialog
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        driver.findElement(By.xpath("//a[normalize-space()='Blogs']")).click();

        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuBlogs);
    }

    @Test //click
    public void testJavascriptExecutor02(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
//        // Tắt Dialog
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        //Click vào Add to Cart ở 1 sản phẩm khuất khởi màn hình => Sẽ báo lỗi
//        driver.findElement(By.xpath("(//i[@class='las la-shopping-cart'])[1]")).click();

        WebElement buttonAddToCart =   driver.findElement(By.xpath("(//i[@class='las la-shopping-cart'])[1]"));
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonAddToCart);
        sleep(2);
    }

    @Test   //input
    public void testJavascriptExecutor03(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        //Click vào ô Search
//        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Bánh Cosy");
//        sleep(2);

        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));

        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','Bánh Cosy');", inputSearch);
        sleep(2);
    }

    @Test   //scroll
    public void testJavascriptExecutor04(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);

        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));

        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonViewAllCategories);
        //true: cuộn lên trên, false: để bên dưới
        sleep(4);
    }

    @Test   //highlight phần tử trên web
    public void testJavascriptExecutor05(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(2);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
        inputEmail.sendKeys("admin@example.com");
        sleep(2);

        js.executeScript("arguments[0].style.border='3px solid red'", inputPassword);
        inputPassword.sendKeys("123456");
        sleep(2);

        js.executeScript("arguments[0].style.border='3px solid yellow'", buttonLogin);
        buttonLogin.click();

        sleep(1);
    }

}

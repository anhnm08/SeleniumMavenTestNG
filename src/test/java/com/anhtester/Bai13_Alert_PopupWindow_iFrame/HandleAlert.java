package com.anhtester.Bai13_Alert_PopupWindow_iFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() {
        driver.get("https://demoqa.com/alerts");
        sleep(2);

        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        sleep(1);

        //Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();
        // Nhấn vào button OK
        alert1.accept();
       // driver.switchTo().alert().accept();

        sleep(1);
    }

    @Test
    public void demoHandleAlertDismiss() {
        driver.get("https://demoqa.com/alerts");
        sleep(2);

        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();

        //Get Text on Alert
        Assert.assertEquals(alert2.getText(),
                "Do you confirm action?");

        //Nhấn vào button Cancel
        alert2.dismiss();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='confirmResult']")).isDisplayed(),
                "You didn't select Cancel");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(),
                "You selected Cancel");
        sleep(1);
    }

    @Test
    public void demoHandleAlertInputText() {
        driver.get("https://demoqa.com/alerts");
        sleep(2);

        //Mở Alert Input text, click nút thứ 3
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Anh Tester Demo Alert");
        sleep(1);

        alert3.accept();
        sleep(1);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(),
                "You entered Anh Tester Demo Alert",
                "Chưa điền được text");

        sleep(1);
    }
}

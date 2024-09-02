package com.anhtester.Bai12_ActionClassRobotClass;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoActionClass extends BaseTest {
    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
//        action.sendKeys(element, "Anh Tester").perform(); //Chức năng tương ứng driver.findElement.sendKeys
//        action.sendKeys(Keys.ENTER).perform(); //Enter bằng việc gọi Class Keys của selenium kết hợp với actions
        action.sendKeys(element, "Anh Tester").pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
        // Get element title of page
        WebElement elementTitlePage = driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']"));

        // Gọi hàm click để click element trên
        action.click(elementTitlePage).perform();

        Thread.sleep(2000);
    }
        @Test
        public void doubleClick() throws InterruptedException {
            driver.get("https://anhtester.com/");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

            Actions action = new Actions(driver);

            action.doubleClick(element).perform();
            Thread.sleep(2000);
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.contextClick(element).perform();
        Thread.sleep(2000);
    }

    // Ctrl + R hoặc F5 để reload trang
    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        //action.moveToElement(element).perform();
        action.scrollToElement(element).perform();

        Thread.sleep(2000);
    }

    @Test //Dùng được khi hệ thống cho phép dragdrop
    public void demoDragAndDropWithActionClass() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html/");
        sleep(1);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));

        sleep(1);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).perform();

        //Cách 2: Tương ứng dragAnđrop
        // action.clickAndHold(From).moveToElement(To).release().perform();
        sleep(2);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").perform();
        action.keyUp(element, Keys.SHIFT).perform();

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down
        action.keyDown(Keys.END).perform();
        action.keyUp(Keys.END).perform();
        Thread.sleep(2000);
        // Scroll up
//        action.keyDown(Keys.HOME).perform();
//        action.keyUp(Keys.HOME).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.COMMAND).sendKeys("r").keyUp(Keys.COMMAND).build().perform();

    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();
        action.sendKeys(Keys.ENTER).perform();
// LƯU Ý: mac dùng COMMAND, window dùng CONTROL
        Thread.sleep(2000);

        //Reload trang ở mac
//        Command + R: Tải lại trang.
//        Shift + Command + R: Tải lại trang và bỏ qua bộ nhớ cache (hard reload).
        //action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform(); //Làm mới trang ở Win
        action.keyDown(Keys.COMMAND).sendKeys("r").keyUp(Keys.COMMAND).build().perform();
        Thread.sleep(2000);
    }

}

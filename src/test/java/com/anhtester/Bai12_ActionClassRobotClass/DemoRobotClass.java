package com.anhtester.Bai12_ActionClassRobotClass;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoRobotClass extends BaseTest {

    @Test
    public void inputText() {

        driver.get("https://anhtester.com/");

        sleep(1); //gọi từ BaseTest để đỡ 1 exception InterruptedException
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = null;
        //Thêm try-catch để bớt 1 exception AWTException
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);

        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_U);
        robot.keyRelease(KeyEvent.VK_M);
        sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleep(1);
    }

    @Test
    public void mousePress() {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(driver.findElement(By.xpath("//a[@id='btn-login']")).getLocation());
        // Ngang 380 & Dọc 190
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1150, 304);
        //Dalay giống sleep
        robot.delay(1000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        //Chuột giữa là BUTTON2_DOWN_MASK
        //Chuột phải là BUTTON3_DOWN_MASK
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

        sleep(3);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        sleep(2);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        sleep(2);
    }

    /* Trước khi thêm hàm capture vào BaseTest
    @Test
    public void createScreenCapture() throws IOException {

        driver.get("https://anhtester.com/");
        sleep(1);

        int W = driver.manage().window().getSize().getWidth();
        int H = driver.manage().window().getSize().getHeight(); //Kích cỡ do Selenium lấy
        System.out.println(W);
        System.out.println(H);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //Get size screen browser - kích cỡ do Java lấy
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        System.out.println("Cỡ do Java và Selenium lấy là khác nhau, vẫn phải dùng hàm của Java để capture đúng");

        //Khởi tạo kích thước khung hình với kích cỡ trên - Java
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên - Java
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png - Java
        File file = new File("TestImageRobot.png");
        ImageIO.write(image, "png", file);

        sleep(1);
    }

     */

    @Test
    public void createScreenCapture() {

        driver.get("https://www.google.com/");
        sleep(1);
        createScreenCapture("Image01");
    }

}


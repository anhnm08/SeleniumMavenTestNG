package com.anhtester.common;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void createScreenCapture(String imageName) {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //Get size screen browser - kích cỡ do Java lấy
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);

        //Khởi tạo kích thước khung hình với kích cỡ trên - Java
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên - Java
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png - Java
        File file = new File(imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sleep(1);
    }

    @BeforeMethod
    @Parameters({"browser"})

    public void createBrowser(String browserName){
//        //Khởi tạo Browser
//        driver = new ChromeDriver();
//
//        // 2 Hàm chờ đợi
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));  //Thời gian chờ đợi tối đa khi tìm kiếm elemnet // cmt ở Bai 16
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180)); //Chờ đợi page load xong
//
//        // 2 Hàm để maximize/ minimize cửa sở trình duyệt
//        driver.manage().window().maximize();
//
        setBrowser(browserName);

        //Bai 16: Khai báo class WebUI để khởi tạo giá trị driver cho class WebUI
        new WebUI(driver);
    }

//cmt toàn bộ ở buổi 47_Bài 24

    public void setBrowser(String browserName){
        //Khởi tạo Browser
        if(browserName.trim().toLowerCase().equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browserName.trim().toLowerCase().equals("edge")){
            driver = new EdgeDriver();
        }
        if(browserName.trim().toLowerCase().equals("firefox")){
            driver = new FirefoxDriver();
        }
        if(browserName.trim().toLowerCase().equals("safari")){
            driver = new SafariDriver();
        }


        // 2 Hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Thời gian chờ đợi tối đa khi tìm kiếm elemnet
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //Chờ đợi page load xong

        // 2 Hàm để maximize/ minimize cửa sở trình duyệt
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void closeBrowser(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        //Thay vì add exception, dùng try/catch để chỉ cần 1 lần
        //Cmt ở Bai 16
        //Đóng Browser
        driver.quit();
    }

}

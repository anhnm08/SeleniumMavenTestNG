package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai báo 1 đối tượng class LoginPage toàn cục
    LoginPage loginPage;


    @Test
    public void testLoginCRM_success(){
        //Khởi tạo đối tượng class loginPage để truyền giá trị driver từ BsseTesst
        //Để class LoginPage nhận được giá trị driver thì nó mới thực thi các hàm trong class Page được
        loginPage = new LoginPage(driver);

        //Sau đó lấy đối tượng class chấm gọi các thành phần trong class Page
        loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com","123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com","1234567");
        loginPage.verifyLoginFail();
    }

}

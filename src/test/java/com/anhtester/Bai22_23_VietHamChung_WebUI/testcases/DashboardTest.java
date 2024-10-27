package com.anhtester.Bai22_23_VietHamChung_WebUI.testcases;

import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @Test
    public void testOpenCustomerPage(){
//        loginPage = new LoginPage(driver); //Khởi tạo cho Trang Login
//        loginPage.loginCRM("admin@example.com","123456");
//        loginPage.verifyLoginSuccess();
//
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.clickMenuCustomers();

//          customerPage = new CustomerPage(driver);
//          customerPage.verifyRedirectCustomerPageSuccess();

        loginPage = new LoginPage(driver); //Khởi tạo cho Trang Login
        dashboardPage = loginPage.loginCRM("admin@example.com","123456"); //Tạo liên kết trang
        loginPage.verifyLoginSuccess();
        customerPage =  dashboardPage.clickMenuCustomers(); //Tạo liên kết trang
        customerPage.verifyRedirectCustomerPageSuccess();
    }

    @Test
    public void testLogOut(){
//        loginPage = new LoginPage(driver); //Khởi tạo cho Trang Login
//        loginPage.loginCRM("admin@example.com","123456");
//        loginPage.verifyLoginSuccess();
//
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.logOut();

        loginPage = new LoginPage(driver); //Khởi tạo cho Trang Login
        dashboardPage = loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();

        loginPage = dashboardPage.logOut();// để khởi tạo một đối tượng LoginPage mới

        loginPage.verifyRedirectLoginPage();// Nếu không có dòng khởi tạo bên trên, thì dòng code này sẽ hiểu loginPage của seesion cũ

    }

}

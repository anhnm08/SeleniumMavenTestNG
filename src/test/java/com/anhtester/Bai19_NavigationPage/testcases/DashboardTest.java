package com.anhtester.Bai19_NavigationPage.testcases;

import com.anhtester.Bai19_NavigationPage.pages.CustomerPage;
import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
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
        dashboardPage.logOut();

    }

}

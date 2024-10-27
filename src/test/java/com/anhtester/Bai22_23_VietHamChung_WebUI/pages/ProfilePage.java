package com.anhtester.Bai22_23_VietHamChung_WebUI.pages;

import com.anhtester.Bai22_23_VietHamChung_WebUI.testcases.CustomerTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        super(driver);      //Kế thừa hàm xây dựng cần có từ khoá super
        this.driver = driver;
        new WebUI(driver);
    }

    public void verifyCustomerDetail(String companyName){
    Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), companyName, "Message");
        //Viết thêm để kiểm tra các field khác nữa

    }

}

package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import com.anhtester.locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewCustomer extends BaseTest {

    String companyName = "Sky Com03";

    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.inputEmail)));
//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        //Thay thành dòng bên dưới

        WebUI.setText(LocatorsCRM.inputEmail, "admin@example.com");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.inputPassword)));
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        WebUI.setText(LocatorsCRM.inputPassword, "123456");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.buttonLogin)));
//        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        WebUI.clickElement(LocatorsCRM.buttonLogin);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void openCustomerPage(){
        loginCRM();

        WebUI.clickElement(LocatorsCRM.menuCustomers);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerCustomersPage)).isDisplayed());

    }

    @Test
    public void testAddNewCustomer(){
        openCustomerPage();

        WebUI.clickElement(LocatorsCRM.buttonAddNewCustomer);
        WebUI.setText(LocatorsCRM.inputCompany, companyName);
        WebUI.setText(LocatorsCRM.inputVatNumber, "11");
        WebUI.setText(LocatorsCRM.inputPhoneNumber, "12345678910");
        WebUI.setText(LocatorsCRM.inputWebsite, "sky.vnn");

        WebUI.clickElement(LocatorsCRM.dropdownGroups);
        WebUI.setText(LocatorsCRM.inputSearchGroup, "VIP");

        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys(Keys.ENTER);

        WebUI.clickElement(LocatorsCRM.dropdownGroups);//Để thu gọn dropdown

        WebUI.setText(LocatorsCRM.textareaAddress, "No 1234 Cau Giay Street");
        WebUI.setText(LocatorsCRM.inputCity, "HaNoi");
        WebUI.setText(LocatorsCRM.inputState, "HaNoi");
        WebUI.setText(LocatorsCRM.inputZipCode, "100000");

        WebUI.clickElement(LocatorsCRM.dropdownCountry);
        WebUI.setText(LocatorsCRM.inputSearchCountry, "Vietnam");

        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys(Keys.ENTER);

        // driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click(); // do dropdown này tự đóng

        WebUI.clickElement(LocatorsCRM.buttonSaveCustomer);
        WebUI.clickElement(LocatorsCRM.menuCustomers);
        WebUI.setText(LocatorsCRM.inputSearchCustomer, companyName);
        sleep(2); //để chờ search
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(), companyName);

    }

    @Test
    public void testAddContactForCustomer(){
        openCustomerPage();

        WebUI.setText(LocatorsCRM.inputSearchContacts, companyName);
        sleep(1);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(), companyName);

        WebUI.clickElement(LocatorsCRM.firstItemCustomerOnTable);
        WebUI.clickElement(LocatorsCRM.menuContacts);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).getText(), "Contacts");

        WebUI.clickElement(LocatorsCRM.buttonAddNewContact);
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).getText(), "Add new contact");

        //Upload file at Profile Contact
        String filePath = System.getProperty("user.dir") + "//src/test/resources/dataTest/IMG_3129.JPG";
        WebUI.setText(LocatorsCRM.inputProfileImage, filePath);
        WebUI.clickElement(LocatorsCRM.iconGenPassword);
        WebUI.clickElement(LocatorsCRM.iconShowPassword);



        //driver.findElement(By.xpath(LocatorsCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir"),"//src/test/resources/dataTest/IMG_3129.JPG" );
        //Resources> New Directory> DataTest> Past ảnh vào> Copy đường dẫn của ảnh - lấy cái có thư mục src và chuyển dấu / thành \\ (đối với window thôi)
//        sleep(1);

//        driver.findElement(By.xpath(LocatorsCRM.iconGenPassword)).click();
//        driver.findElement(By.xpath(LocatorsCRM.iconShowPassword)).click();
//        sleep(1);
        String passValue = driver.findElement(By.xpath(LocatorsCRM.inputPasswordContact)).getAttribute("value");
        System.out.println(passValue);
    }


}

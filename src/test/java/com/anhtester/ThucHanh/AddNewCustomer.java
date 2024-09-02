package com.anhtester.ThucHanh;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomer extends BaseTest {

    String companyName = "Sky Com";

    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void openCustomerPage(){
        loginCRM();

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerCustomersPage)).isDisplayed());

    }

    @Test
    public void testAddNewCustomer(){
        openCustomerPage();

        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(companyName);
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).sendKeys("123456789");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("sky.vn");
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();

        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click(); //Để thu gọn dropdown

        driver.findElement(By.xpath(LocatorsCRM.textareaAddress)).sendKeys("No 123 Cau Giay Street");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hanoi");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hanoi");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("100000");
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();

        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys(Keys.ENTER);

        // driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click(); // do dropdown này tự đóng
        sleep(1);

        driver.findElement(By.xpath(LocatorsCRM.buttonSaveCustomer)).click();
        sleep(1);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        sleep(1);

        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys(companyName);
        sleep(2);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(), companyName);

    }

    @Test
    public void testAddContactForCustomer(){
        openCustomerPage();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchContacts)).sendKeys(companyName);
        sleep(1);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(), companyName);
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).click();
        driver.findElement(By.xpath(LocatorsCRM.menuContacts)).click();

        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).getText(), "Contacts");

        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewContact)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).getText(), "Add new contact");

        //Upload file at Profile Contact
        driver.findElement(By.xpath(LocatorsCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir"),"//src/test/resources/dataTest/IMG_3129.JPG" );
        //Resources> New Directory> DataTest> Past ảnh vào> Copy đường dẫn của ảnh - lấy cái có thư mục src và chuyển dấu / thành \\ (đối với window thôi)
        sleep(1);

        driver.findElement(By.xpath(LocatorsCRM.iconGenPassword)).click();
        driver.findElement(By.xpath(LocatorsCRM.iconShowPassword)).click();
        sleep(1);
        String passValue = driver.findElement(By.xpath(LocatorsCRM.inputPasswordContact)).getAttribute("value");
        System.out.println(passValue);
    }

}

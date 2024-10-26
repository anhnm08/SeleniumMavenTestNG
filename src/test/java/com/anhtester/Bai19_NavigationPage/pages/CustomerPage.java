package com.anhtester.Bai19_NavigationPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNew = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//h4[normalize-space()='Customers Summary']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input");

    public void clickButtonAddNew(){
        WebUI.clickElement(buttonAddNew);
        System.out.println("Click on button AddNewCustomer");
    }

    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(),"Không tìm thấy Customer Header Page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), "Customers Summary 123", "Giá trị Customer Header Page không đúng");
    }
}

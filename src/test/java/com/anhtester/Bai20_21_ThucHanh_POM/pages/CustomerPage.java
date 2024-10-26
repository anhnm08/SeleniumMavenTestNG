package com.anhtester.Bai20_21_ThucHanh_POM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//h4[normalize-space()='Customers Summary']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input");

    //Trang Customers List
    //private By buttonAddNewCustomer= "//a[normalize-space()='New Customer']";

    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath( "//a[normalize-space()='Import Customers']/following-sibling::a[normalize-space()='Contacts']");
    //Cách 2 của buttonContacts:  //a[contains(@href,'all_contacts')]
    private By headerCustomersPage = By.xpath( "//h4[normalize-space()='Customers Summary']");
    // //div[@id='clients_filter']/descendant::input
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");


    //Trand Add new customers
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVatNumber = By.xpath("//input[@id='vat']");
    public By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite= By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper ='groups_in[]']//input[@type='search']");
    //Cách 2 của inputGroups //button[@data-id='groups_in[]']/following-sibling::div//input
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper ='default_currency']//input[@type='search']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");

    private By textareaAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry= By.xpath("//div[@app-field-wrapper ='country']//input[@type='search']");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//button[normalize-space()='Save and create contact']//following-sibling::button");


    public void clickButtonAddNew(){
        WebUI.clickElement(buttonAddNewCustomer);
        System.out.println("Click on button AddNewCustomer");
    }

    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(),"Không tìm thấy Customer Header Page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), "Customers Summary", "Giá trị Customer Header Page không đúng");
    }

    public void inputDataCustomer(String companyName){
        WebUI.setText(inputCompany, companyName);
        WebUI.setText(inputVatNumber, "10");
        WebUI.setText(inputPhoneNumber, "12345678");
        WebUI.setText(inputWebsite, "https://volio.group");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, "Sale");
        WebUI.sleep(1); //Với những dropdown cần có sleep 1s để đợi bật dropdown lên
        driver.findElement(inputSearchGroup).sendKeys(Keys.ENTER);
        WebUI.clickElement(dropdownGroups); // Tắt dropdown
        WebUI.setText(textareaAddress, "Hà Nội");
        WebUI.setText(inputCity, "Hà Nội");
        WebUI.setText(inputState, "Thăng Long");
        WebUI.setText(inputZipCode, "100000");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        driver.findElement(inputSearchGroup).sendKeys(Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public void ProfilePage searchCustomer(String companyName){
        WebUI.setText(inputSearchCustomer, companyName);
        WebUI.sleep(2);
        WebUI.clickElement(firstItemCustomerOnTable);

        return new ProfilePage(driver);
    }


}

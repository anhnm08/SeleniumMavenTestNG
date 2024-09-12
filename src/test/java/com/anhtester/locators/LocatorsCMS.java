package com.anhtester.locators;

public class LocatorsCMS {
//Login Page
    public static String headerLoginPage = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotpw = "//a[contains(@href, 'password/reset')]";
    public static String checkboxRemember = "//input[@id='remember']";

//Dashboard Page
    public static String menuDashboard = "//ul[@id='main-menu']//span[normalize-space()='Dashboard']";
    public static String menuProducts = "//ul[@id='main-menu']//span[normalize-space()='Products']";
    public static String menuSales = "//ul[@id='main-menu']//span[normalize-space()='Sales']";
    public static String menuCustomers = "//ul[@id='main-menu']//span[normalize-space()='Customers']";
    public static String menuReports = "//ul[@id='main-menu']//span[normalize-space()='Reports']";
    public static String iconAva = "//span[@class='d-block fw-500']/preceding::span[@class='avatar avatar-sm mr-md-2']";

    public static String submenuCategory = "//ul[@id='main-menu']//span[normalize-space()='Category']";

// All categories Page
    public static String headerAllCatePage = "//h1[normalize-space()='All categories']";
    public static String buttonAddNewCategory = "//h1[normalize-space()='All categories']/following::a[@class='btn btn-primary']";
    public static String inputSearchCategory = "//h1[normalize-space()='All categories']/following::input[@id='search']";

//Category Information Page
    public static String headerAddNewCategoryPage = "//h5[normalize-space()='Category Information']";
    public static String inputName = "//input[@id='name']";
    public static String dropdownParentCategory ="//label[normalize-space()='Parent Category']/following::button[@aria-owns='bs-select-1']";
    public static String inputSearchParentCategory = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String dropdownType = "//button[@aria-owns='bs-select-2']";
    public static String inputBanner = "//label[contains(.,'Banner (200x200)')]/following-sibling::div/div/div/div[contains(.,'Browse')]";
    public static String inputSearchYourFiles = "//input[@placeholder='Search your files']";
    public static String firstFile = "//div[@class='aiz-file-box-wrap']";
    public static String buttonAddFiles = "//button[normalize-space()='Add Files']";
    public static String inputIcon = "//label[contains(.,'Icon (32x32)')]/following-sibling::div/div/div/div[contains(.,'Browse')]";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String textAreaMetaDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes ="//label[normalize-space()='Filtering Attributes']/following::button[@aria-owns='bs-select-3']";
    public static String inputSearchFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following::input[@aria-label='Search']";
    public static String buttonSaveCategoryInformation= "//h5[normalize-space()='Category Information']/following::button[normalize-space()='Save']";
    public static String firstItemCateOnTable ="//tbody/tr[1]/td[2]";

//    public static String = "";
//    public static String = "";

}

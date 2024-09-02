package com.anhtester.locators;

public class LocatorsCRM {

    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotpw = "//a[contains(@href, 'forgot_password')]";
    public static String checkboxRemember = "//input[@id='remember']";

    //Trang Dashboard
    public static String menuDashboard= "//ul[@id='side-menu']//span[normalize-space()='Dashboard']";
    public static String menuCustomers = "//ul[@id='side-menu']//span[normalize-space()='Customers']";
    public static String menuProjects = "//ul[@id='side-menu']//span[normalize-space()='Projects']";
    public static String menuTasks = "//ul[@id='side-menu']//span[normalize-space()='Tasks']";

    //Trang Customers List
    public static String buttonAddNewCustomer= "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomers= "//a[normalize-space()='Import Customers']";
    public static String buttonContacts = "//a[normalize-space()='Import Customers']/following-sibling::a[normalize-space()='Contacts']";
    //Cách 2 của buttonContacts:  //a[contains(@href,'all_contacts')]
    public static String headerCustomersPage = "//h4[normalize-space()='Customers Summary']";
    public static String inputSearchCustomer = "//div[@id='clients_filter']//input";
    // //div[@id='clients_filter']/descendant::input
    public static String firstItemCustomerOnTable ="//td[@class='sorting_1']/a";


    //Trand Add new customers
    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputPhoneNumber = "//input[@id='phonenumber']";
    public static String inputWebsite= "//input[@id='website']";
    public static String dropdownGroups = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroup = "//div[@app-field-wrapper ='groups_in[]']//input[@type='search']";
    //Cách 2 của inputGroups //button[@data-id='groups_in[]']/following-sibling::div//input
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency = "//div[@app-field-wrapper ='default_currency']//input[@type='search']";
    public static String dropdownLanguage = "//button[@data-id='default_language']";

    public static String textareaAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry= "//div[@app-field-wrapper ='country']//input[@type='search']";
    public static String buttonSaveAndCreateContact = "//button[normalize-space()='Save and create contact']";
    public static String buttonSaveCustomer = "//button[normalize-space()='Save and create contact']//following-sibling::button";

    public static String headerProjectsPage = "//h4[normalize-space()='Projects Summary']";
    public static String inputSearchProject = "//div[@id='projects_filter']/descendant::input";
    public static String buttonAddNewProject= "//a[@data-title='Gantt']//preceding::a[normalize-space()='New Project']";

    //Trang Projects
    public static String inputProjectName = "//label[@for='name']//following-sibling::input";
    public static String dropdownCustomer = "//button[@data-id='clientid']";
    public static String inputSearchCustomerProject = "//button[@data-id='clientid']/following-sibling::div//input";
    public static String checkboxCalculateProgress = "//label[normalize-space()='Calculate progress through tasks']/parent::div//input";
    public static String sliderProẹctProgress = "//label//span[@class='label_progress']/following::input[@name='progress']";
    public static String dropdownBillingType = "//button[@data-id='billing_type']";
    public static String dropdownStatus = "//button[@data-id='status']";
    public static String inputRatePerHour = "//input[@id='project_rate_per_hour']";
    public static String inputEstHour= "//input[@id='estimated_hours']";
    public static String dropdownMembers = "//button[@data-id='project_members[]']";
    public static String buttonSelectall = "";
    public static String buttonDeselectall = "";
    public static String inputSearchMember = "//button[@data-id='project_members[]']//following-sibling::div//input";
    public static String inputStartDate = "//input[@id='start_date']";
    public static String iconCalendarStartDate = "//input[@id='start_date']/following-sibling::div//i";
    public static String inputDeadline = "//input[@id='deadline']";
    public static String calendarDeadline = "//input[@id='deadline']/following-sibling::div//i";

    public static String inputTextAreaDescription = "//iframe[@id='description_ifr']";
    public static String checkboxSendProjectCreatedEmail = "//label[normalize-space()='Send project created email']/preceding-sibling::input";
    public static String buttonSaveProject = "//button[normalize-space()='Save']";
    public static String tabProjectSettings = "//a[normalize-space()='Project Settings']";

    //Trang Customer Contacts
    public static String menuContacts = "//a[@data-group='contacts']";
    public static String headerContactPage = "//h4[normalize-space()='Contacts']";
    public static String buttonAddNewContact = "//a[normalize-space()='New Contact']";
    public static String inputSearchContacts = "//input[@class='form-control input-sm']";
    public static String headerAddNewContactDialog = "//h4[normalize-space()='Add new contact']";
    public static String inputProfileImage = "//input[@id='profile_image']";
    public static String inputFirstName = "//input[@id='firstname']";
    public static String inputLastName = "//input[@id='lastname']";
    public static String inputPosition = "//input[@id='title']";
    public static String inputEmailContact = "//input[@id='email']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String dropdownDirection = "//button[@data-id='direction']";
    public static String inputPasswordContact = "//input[@name='password']";
    public static String iconShowPassword = "//i[@class='fa fa-eye']";
    public static String iconGenPassword = "//a[@class='generate_password']";
    public static String checkboxPrimaryContact = "//label[normalize-space()='Primary Contact']";
    public static String checkboxNoWelcomeEmail = "//label[normalize-space()='Do not send welcome email']";
    public static String checkboxSendSetPWEmail = "//label[normalize-space()='Send SET password email']";
    public static String buttonSaveContact = "//form[@id='contact-form']//button[normalize-space()='Save']";


}

package Bt_Ecommerce.Bt1;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorsCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCategoryCMS extends BaseTest {

    String categoryName = "Sky";

    public void loginCMS(){
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath(LocatorsCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCMS.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCMS.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed");
    }

    public void openAllCategoriesPage(){
        loginCMS();

        driver.findElement(By.xpath(LocatorsCMS.menuProducts)).click();
        driver.findElement(By.xpath(LocatorsCMS.submenuCategory)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCMS.headerAllCatePage)).isDisplayed());

    }

    @Test
    public void testAddNewCategory(){
        openAllCategoriesPage();

        driver.findElement(By.xpath(LocatorsCMS.buttonAddNewCategory)).click();
        driver.findElement(By.xpath(LocatorsCMS.inputName)).sendKeys(categoryName);

        driver.findElement(By.xpath(LocatorsCMS.dropdownParentCategory)).click();
        driver.findElement(By.xpath(LocatorsCMS.inputSearchParentCategory)).sendKeys("T-shirt");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.inputSearchParentCategory)).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCMS.inputOrderingNumber)).sendKeys("1");

        driver.findElement(By.xpath(LocatorsCMS.dropdownType)).click();
        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();

        driver.findElement(By.xpath(LocatorsCMS.inputBanner)).click();
        driver.findElement(By.xpath(LocatorsCMS.inputSearchYourFiles)).sendKeys("IMG_3129");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.firstFile)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.buttonAddFiles)).click();
        sleep(2);

        driver.findElement(By.xpath(LocatorsCMS.inputIcon)).click();
        driver.findElement(By.xpath(LocatorsCMS.inputSearchYourFiles)).sendKeys("IMG_3129");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.firstFile)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.buttonAddFiles)).click();
        sleep(2);

        driver.findElement(By.xpath(LocatorsCMS.inputMetaTitle)).sendKeys("Meta Title Example 1");
        driver.findElement(By.xpath(LocatorsCMS.textAreaMetaDescription)).sendKeys("Light, Portable, Ubiquitous");

        driver.findElement(By.xpath(LocatorsCMS.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(LocatorsCMS.inputSearchFilteringAttributes)).sendKeys("Size");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCMS.inputSearchFilteringAttributes)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCMS.dropdownFilteringAttributes)).click();

        driver.findElement(By.xpath(LocatorsCMS.buttonSaveCategoryInformation)).click();
        sleep(1);

//        driver.findElement(By.xpath(LocatorsCMS.menuProducts)).click();
//        driver.findElement(By.xpath(LocatorsCMS.submenuCategory)).click();
//        sleep(1);

        driver.findElement(By.xpath(LocatorsCMS.inputSearchCategory)).sendKeys(categoryName);
        driver.findElement(By.xpath(LocatorsCMS.inputSearchCategory)).sendKeys(Keys.ENTER);
        sleep(2);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCMS.firstItemCateOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCMS.firstItemCateOnTable)).getText(), categoryName);

    }

}

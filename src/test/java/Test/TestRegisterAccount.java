package Test;

import Actions.ActionRegisterAccount;
import Pages.PageRegisterAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegisterAccount {
    WebDriver driver;
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://113.176.100.130:8080/EBankingWebsite/");
        System.out.println(driver.getTitle());
    }
    @Test //Verify that Register page displays when clicking on "Tạo tài khoản" link in Home page
    public void TC_RG_01(){
        //Step 1: Click on "Tạo tài khoản" link.
        ActionRegisterAccount.clickOnCreateAccount(driver);
        String Registerpage = driver.findElement(By.xpath(".//span[@class='ui-panel-title' and contains(.,'Đăng kí tài khoản')] ")).getText();
        Assert.assertEquals("Đăng kí tài khoản", Registerpage);
    }
    @Test // "Đăng ký tài khoản thành công, vui lòng đi đến Email để kích hoạt tài khoản" message displays in screen when customer enter valid data into all field in Register Page and click on "Đăng ký" button
    public void TC_RG_02(){
        //Step 1: Click on "Tạo tài khoản" link
        ActionRegisterAccount.clickOnCreateAccount(driver);
        //Step 2:  Enter valid data into all field in Register Page
        ActionRegisterAccount.enterAccount(driver,"112233445566778");
        ActionRegisterAccount.enterPassword(driver,"123456yu");
        ActionRegisterAccount.enterConfirmPassword(driver,"123456yu");
        ActionRegisterAccount.enterFullName(driver,"Nguyen Thi Thu Thao");
        ActionRegisterAccount.enterPhone(driver,"0123456789");
        ActionRegisterAccount.enterBirthday(driver, "13/03/1994");
        ActionRegisterAccount.SelectGender(driver);
        Select drp_City = new Select(driver.findElement(By.xpath(PageRegisterAccount.drp_City)));
        drp_City.selectByIndex(1);
        ActionRegisterAccount.enterPassPost(driver,"123456789");
        ActionRegisterAccount.enterEmail(driver,"thuthao94bkdn@gmail.com");
        ActionRegisterAccount.clickOnRegister(driver);
        ActionRegisterAccount.ClickOnCreateAccount2(driver);
        String RegisterSuccessfully = driver.findElement(By.xpath(".//div[@class='ui-dialog-content ui-widget-content']")).getText();
        Assert.assertEquals("Đăng ký tài khoản thành công, vui lòng đi đến Email để kích hoạt tài khoản", RegisterSuccessfully);
    }
    @Test //"Verify that "Tài khoản phải có ít nhất 8 ký tự" message displays below "Tài khoản" field when customer enter account is less than 8 characters into "Tài khoản" field in register page
    public void TC_RG_03(){
        //Step 1: Click on "Tạo tài khoản" link
        ActionRegisterAccount.clickOnCreateAccount(driver);
        //Step 2: Enter account is less than 8 characters into "Tài khoản" field
        ActionRegisterAccount.enterAccount(driver,"123");
        //Step 3: Click on "Đăng ký" button
        ActionRegisterAccount.clickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(PageRegisterAccount.btn_CreateAccount2))).perform();
        ActionRegisterAccount.ClickOnCreateAccount2(driver);
        //Check
        //Assert.assertEquals();
    }
    @Test
    @AfterMethod
    public void After(){
    }
}

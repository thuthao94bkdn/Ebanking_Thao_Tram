package Actions;

import Objects.Users;
import Pages.RegisterAccount_Page;
import org.openqa.selenium.*;

public class RegisterAccount_Action {
    public static void clickOnCreateAccount(WebDriver driver) {
        driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount)).click();
    }

    public static void enterInformation(WebDriver driver, Users user) {
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Account)).sendKeys(user.getAccount());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Password)).sendKeys(user.getPassword());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_ConfirmPassword)).sendKeys(user.getConfirmPassword());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_FullName)).sendKeys(user.getFullName());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Phone)).sendKeys(user.getPhone());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Birthday)).sendKeys(user.getBirthday());
        driver.findElement(By.xpath(RegisterAccount_Page.rdb_Female)).click();
        driver.findElement(By.xpath(RegisterAccount_Page.drp_City)).click();
        driver.findElement(By.xpath(RegisterAccount_Page.txt_City)).click();
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Passpost)).sendKeys(user.getPassPost());
        driver.findElement(By.xpath(RegisterAccount_Page.txt_Email)).sendKeys(user.getEmail());
    }
    public static void ClickOnRegister(WebDriver driver){
                driver.findElement(By.xpath(RegisterAccount_Page.btn_Register)).click();
    }
    public static void ClickOnCreateAccount2(WebDriver driver){
       driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2)).click();
    }
}


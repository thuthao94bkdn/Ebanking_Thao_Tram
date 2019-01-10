package Actions;

import Pages.PageRegisterAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionRegisterAccount {
    public static void clickOnCreateAccount(WebDriver driver){
        driver.findElement(By.xpath(PageRegisterAccount.btn_CreateAccount)).click();
    }
    public static void enterAccount(WebDriver driver, String Account) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Account)).sendKeys(Account);
    }
    public static void enterPassword(WebDriver driver, String Password) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Password)).sendKeys(Password);
    }
    public static void enterConfirmPassword(WebDriver driver, String ConfirmPassword) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_ConfirmPassword)).sendKeys(ConfirmPassword);
    }
    public static void enterFullName(WebDriver driver, String FullName) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_FullName)).sendKeys(FullName);
    }
    public static void enterPhone(WebDriver driver, String Phone) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Phone)).sendKeys(Phone);
    }
    public static void enterBirthday(WebDriver driver, String Birthday) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Birthday)).sendKeys(Birthday);
    }
    public static void SelectGender(WebDriver driver) {
        driver.findElement(By.xpath(PageRegisterAccount.rdb_Gender)).click();
    }
    public static void enterPassPost(WebDriver driver, String PassPost) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Passpost)).sendKeys(PassPost);
    }
    public static void enterEmail(WebDriver driver, String Email) {
        driver.findElement(By.xpath(PageRegisterAccount.txt_Email)).sendKeys(Email);
    }
    public static void clickOnRegister(WebDriver driver) {
        driver.findElement(By.xpath(PageRegisterAccount.btn_Register)).click();
    }
    public static void ClickOnCreateAccount2(WebDriver driver) {
        driver.findElement(By.xpath(PageRegisterAccount.btn_CreateAccount2)).click();
    }
}


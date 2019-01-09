package Test;

import Actions.ActionRegisterAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        ActionRegisterAccount.clickoncreateaccount(driver);
        String Registerpage = driver.findElement(By.xpath(".//span[@class='ui-panel-title' and contains(.,'Đăng kí tài khoản')] ")).getText();
        Assert.assertEquals("Đăng kí tài khoản", Registerpage);
    }
    @Test
    @AfterMethod
    public void After(){
    }
}

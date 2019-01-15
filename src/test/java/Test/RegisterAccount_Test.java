package Test;

import Objects.Users;
import Pages.RegisterAccount_Page;
import  Actions.RegisterAccount_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadFactory;

public class RegisterAccount_Test {
    WebDriver driver;
    Users Thao;
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://113.176.100.130:8080/EBankingWebsite/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        Thao = new Users();
        Thao.setConfirmPassword("123456yu");
        Thao.setPhone("0123456789");
        Thao.setBirthday("13/03/1994");
        Thao.setPassPost("123456789");
        Thao.setEmail("thuthao94bkdn@gmail.com");
        Thao.setCity("Thanh Pho Da Nang");
    }
    @Test //Verify that Register page displays when clicking on "Tạo tài khoản" link in Home page
    public void TC_Register_01(){
        //Step 1: Click on "Tạo tài khoản" link.
        RegisterAccount_Action.clickOnCreateAccount(driver);
        String Registerpage = driver.findElement(By.xpath(".//span[@class='ui-panel-title' and contains(.,'Đăng kí tài khoản')] ")).getText();
        Assert.assertEquals("Đăng kí tài khoản", Registerpage);
    }
    @Test // "Đăng ký tài khoản thành công, vui lòng đi đến Email để kích hoạt tài khoản" message displays in screen when customer enter valid data into all field in Register Page and click on "Đăng ký" button
    public void TC_Register_02() throws InterruptedException {
        String accountnumber = "328746"+ Math.random();
        Thao.setAccount(accountnumber);
        Thao.setPassword("123456yu");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2:  Enter valid data into all field in Register Page
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button

        RegisterAccount_Action.ClickOnRegister(driver);

        //Step 4: Click on "Tạo tài khoản" button
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RegisterAccount_Page.btn_CreateAccount2)));



        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        String RegisterSuccessfully = driver.findElement(By.xpath(".//div[@class='ui-dialog-content ui-widget-content']")).getText();
        Assert.assertEquals("Đăng kí tài khoản thành công, vui lòng vào Email để kích hoạt tài khoản.", RegisterSuccessfully);
    }
    @Test //"Verify that "Tài khoản phải có ít nhất 8 ký tự" message displays below "Tài khoản" field when customer enter account is less than 8 characters into "Tài khoản" field in register page
    public void TC_Register_03(){
        Thao.setAccount("123");
        Thao.setPassword("123456yu");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and enter account is less than 8 characters into "Tài khoản" field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //Check
        //Assert.assertEquals();
    }
    @Test //"Tài khoản nhập sai" message displays below "Tài khoản" field when customer leave blank "Tài khoản" field in register page
    public void TC_Register_04() {
        Thao.setAccount("");
        Thao.setPassword("123456yu");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and customer leave blank "Tài khoản" field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
    }
    @Test //verify that "Tài khoản đã tồn tại" message displays in register page when customer enter account has been used into"Tài khoản" field
    public void TC_Register_05(){
        Thao.setAccount("1122334455667") ;
        Thao.setPassword("123456yu");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and enter account has been used into "Tài khoản"field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
        String Account = driver.findElement(By.xpath(".//div[@class='ui-dialog-content ui-widget-content' and contains(.,'Tài khoản đã tồn tại')]")).getText();
        Assert.assertEquals("Tài khoản đã tồn tại", Account);
    }
    @Test //Verify that "Vui lòng nhập mật khẩu" message displays when customer leave blank "Mật khẩu" field in register page
    public void TC_Register_06() {
        Thao.setAccount("12345678901234");
        Thao.setPassword("");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and leave blank "Mật khẩu" field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
    }
    @Test //Verify that "Mật khẩu lớn hơn 8 kí tự" message displays when customer enter password is less than 8 character into "Mật khẩu" field in register page
    public void TC_Register_07() {
        Thao.setAccount("12345678901234");
        Thao.setPassword("123");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and customer enter password is less than 8 character into "Mật khẩu" field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
    }
    @Test //Verify that "Không trùng mật khẩu" message displays below "Nhập lại mật khẩu" field when customer enter confirm password not match password in register page
    public void TC_Register_08() {
        Thao.setAccount("12345678901234");
        Thao.setPassword("123123thao");
        Thao.setFullName("Nguyen Thi Thu Thao");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and customer enter confirm password not match password into "Nhập lại mật khẩu" field
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
    }
    @Test //Verify that "Vui lòng nhập Họ tên" message displays below "Họ tên" field when customer leave blank "Họ tên" field in register page
    public void TC_Register_09() {
        Thao.setAccount("12345678901234");
        Thao.setPassword("123456yu");
        Thao.setFullName("");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and customer leave blank "Họ tên" field in register page
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
    }
    @Test //Verify that “Độ lớn từ 1 đến 100 ký tự” message displays below “Họ tên” field when customer enter full name more than 100 characters into “Họ tên” field in register page
    public void TC_Register_10() {
        Thao.setAccount("12345678901234");
        Thao.setPassword("123456yu");
        Thao.setFullName("qwertyuioplkjhgfdsazxcvbnmmnbvcxz qwertyuioplkjhgfdsazxcvbnmmnbvcxz qwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxzqwertyuioplkjhgfdsazxcvbnmmnbvcxz");
        //Step 1: Click on "Tạo tài khoản" link
        RegisterAccount_Action.clickOnCreateAccount(driver);
        //Step 2: Enter valid data into all field and customer enter full name more than 100 characters into “Họ tên” field in register page
        RegisterAccount_Action.enterInformation(driver, Thao);
        //Step 3: Click on "Đăng ký" button
        RegisterAccount_Action.ClickOnRegister(driver);
        //Step 4: Click on "Tạo tài khoản" button
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(RegisterAccount_Page.btn_CreateAccount2))).perform();
        RegisterAccount_Action.ClickOnCreateAccount2(driver);
        //check
    }
    @AfterMethod
    public void After(){
        //driver.quit();
    }
}

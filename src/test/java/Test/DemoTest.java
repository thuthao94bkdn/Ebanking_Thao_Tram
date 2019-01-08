package Test;

import Actions.Demo_actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {
    WebDriver driver;
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://113.176.100.130:8080/EBankingWebsite/faces/registry.xhtml");
        System.out.println(driver.getTitle());
    }
    @Test
    public void Test2(){
        Demo_actions.enteraccount(driver, "123456789012");
    }
    @AfterMethod
    public void After(){
    }
}

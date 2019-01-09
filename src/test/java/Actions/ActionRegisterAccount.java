package Actions;

import Pages.PageRegisterAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionRegisterAccount {
    public static void clickoncreateaccount(WebDriver driver){
        driver.findElement(By.xpath(PageRegisterAccount.btn_CreateAccount)).click();
    }
}

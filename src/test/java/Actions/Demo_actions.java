package Actions;

import Pages.DEMOPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Demo_actions {
   public static void enteraccount(WebDriver driver, String account){
      driver.findElement(By.xpath(DEMOPage.txt_Account)).sendKeys(account);
   }
}

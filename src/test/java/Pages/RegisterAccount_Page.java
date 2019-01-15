package Pages;

public class RegisterAccount_Page {
    public static String btn_CreateAccount = ".//a[@href='http://113.176.100.130:8080/EBankingWebsite/faces/registry.xhtml']";
    public static String txt_Account = ".//input[@id='j_idt9:soucre']";
    public static String txt_Password = ".//input[@id='j_idt9:pwd1']";
    public static String txt_ConfirmPassword = ".//input[@id='j_idt9:pwd2']";
    public static String txt_FullName = ".//input[@id='j_idt9:key']";
    public static String txt_Phone = ".//input[@id='j_idt9:phone']";
    public static String txt_Birthday = ".//input[@id='j_idt9:mask_input']";
    public static String rdb_Female = ".//label[@for='j_idt9:console:1']";
    public static String rdb_Male = ".//label[@for='j_idt9:console:0']";
    public static String drp_City = ".//div[@id='j_idt9:country']";
    public static String txt_City = ".//div[@id='j_idt9:country_panel']//li[.='Thanh Pho Da Nang']";
    public static String txt_Passpost = ".//input[@id='j_idt9:cmnd']";
    public static String txt_Email = ".//input[@id='j_idt9:email']";
    public static String btn_Register = ".//button//span[.='Đăng ký']";
   // public static String btn_CreateAccount2 = ".//input[@type='submit' and @name='j_idt9:j_idt30']";
    //public static String btn_CreateAccount2 = ".//input[@name='j_idt9:j_idt30']";
    //public static String btn_CreateAccount2 = ".//div[@class='ui-dialog-content ui-widget-content']//input[@name='j_idt9:j_idt30']";
    //public static String btn_CreateAccount2 = ".//div[@id='j_idt9:j_idt28']//input[@name='j_idt9:j_idt30']";
    public static String btn_CreateAccount2 = ".//input[@value='Tạo tài khoản']";
    //.//div[@id="j_idt9:msgs_container"]//span[contains(.,'Mật khẩu lớn hơn 8 kí tư')]
}


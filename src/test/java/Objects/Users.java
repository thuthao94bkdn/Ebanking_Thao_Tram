package Objects;
public class Users {
    private String Account;
    private String Password;
    private String Confirmassword;
    private  String FullName;
    private  String Phone;
    private  String Birthday;
    private  String PassPost;
    private  String Email;
    private String City;

    public String getAccount() { return Account;}
    public void setAccount(String account) {
        Account = account;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password){
        Password = password;
    }
    public String getConfirmPassword() {
        return Confirmassword;
    }
    public void setConfirmPassword(String confirmpassword){
        Confirmassword = confirmpassword;
    }
    public String getFullName() {
        return FullName;
    }
    public void setFullName(String fullname) {
        FullName = fullname;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getBirthday() {
        return Birthday;
    }
    public void setBirthday(String birthday) {
        Birthday = birthday;
    }
    public String getPassPost() {
        return PassPost;
    }
    public void setPassPost(String passPost) {
        PassPost = passPost;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getCity(){return City;}
    public void setCity(String city){ City = city;}

}

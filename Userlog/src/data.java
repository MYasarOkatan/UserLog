public class data {
    private String userName;
    private String password;
    private final String email;

    public data(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getuserName() {
        return  this.userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getpassword() {
        return  this.password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    public String getemail() {
        return  this.email;
    }
}

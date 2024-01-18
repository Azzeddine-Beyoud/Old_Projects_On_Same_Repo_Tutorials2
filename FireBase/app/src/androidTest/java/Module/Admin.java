package Module;

public class Admin {
    private String userName;
    private String password;
    private String c_Password;

    public Admin() {
    }

    public Admin(String userName, String password, String c_Password) {
        this.userName = userName;
        this.password = password;
        this.c_Password = c_Password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getC_Password() {
        return c_Password;
    }

    public void setC_Password(String c_Password) {
        this.c_Password = c_Password;
    }
}

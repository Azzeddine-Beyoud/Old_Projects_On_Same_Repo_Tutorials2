package Module;

public class UserClient {
    private String firstName;
    private String lastName;
    private int id_Cammande;
    private int phone;

    public UserClient() {
    }

    public UserClient(String firstName, String lastName, int id_Cammande, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id_Cammande = id_Cammande;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId_Cammande() {
        return id_Cammande;
    }

    public void setId_Cammande(int id_Cammande) {
        this.id_Cammande = id_Cammande;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

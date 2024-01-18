package Modul;



public class ListPerson {
    public int id;
    public String email;
    public String name;
    public String Lastname;
    public String password;
    public String Phonenumber;
    public int age;
    public String city;

    public ListPerson() {
    }

    public ListPerson(String name, String lastname, String phonenumber, String city) {
        this.name = name;
        this.Lastname = lastname;
        this.Phonenumber = phonenumber;
        this.city = city;
    }

    public ListPerson(String email, String name, String lastname, String password, String phonenumber , int age, String city) {
        this.email = email;
        this.name = name;
        this.Lastname = lastname;
        this.password = password;
        this.Phonenumber = phonenumber;
        this.age = age;
        this.city = city;
    }

    public ListPerson(int id, String email, String name, String lastname, String password, String phonenumber, int age, String city) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.Lastname = lastname;
        this.password = password;
        this.Phonenumber = phonenumber;
        this.age = age;
        this.city = city;
    }

    public ListPerson(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

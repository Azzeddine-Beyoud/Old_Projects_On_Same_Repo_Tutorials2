package Modul;




public class ListPerson {
    public int id;
    public String email;
    public String password;
    public String name;
    public String Lastname;
    public int age;
    public String Phonenumber;
    public String city;
    public String Job;

    public ListPerson() {
    }

    public ListPerson(String name, String lastname, String phonenumber, String city) {
        this.name = name;
        this.Lastname = lastname;
        this.Phonenumber = phonenumber;
        this.city = city;
    }
    public ListPerson(String name, String lastname, String phonenumber, String city,String Email) {
        this.name = name;
        this.Lastname = lastname;
        this.Phonenumber = phonenumber;
        this.city = city;
        this.email=Email;
    }





    public ListPerson(String email, String password, String name, String lastname, String phonenumber, String city,String Job) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.Lastname = lastname;
        this.Phonenumber = phonenumber;
        this.city = city;
        this.Job=Job;
    }
    public ListPerson(String email, String password, String name, String lastname, String phonenumber, String city) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.Lastname = lastname;
        this.Phonenumber = phonenumber;
        this.city = city;

    }


    public ListPerson(int id, String email, String password, String name, String lastname, int age, String phonenumber, String city) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.Lastname = lastname;
        this.age = age;
        this.Phonenumber = phonenumber;
        this.city = city;
    }

    public ListPerson(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public ListPerson (ListPerson person){
        this.name=person.getName();
        this.Lastname=person.getLastname();
        this.Phonenumber=person.getPhonenumber();
        this.city=person.getCity();
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
    public String getJob(){
        return Job;
    }
}

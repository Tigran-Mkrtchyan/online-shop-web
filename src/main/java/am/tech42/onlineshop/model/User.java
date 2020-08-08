package am.tech42.onlineshop.model;

public class User {

    private int id;
    private String phoneNumber;
    private String password;
    private String name;

    public User(int id, String phoneNumber, String password, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

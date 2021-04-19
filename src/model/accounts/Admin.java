package model.accounts;

public class Admin extends User{
    public Admin() {
    }

    public Admin(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phoneNumber + '\'' +
                ", adress='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}

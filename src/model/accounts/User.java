package model.accounts;
import model.order.Order;
import java.util.Set;
import java.util.UUID;

public class User{
    protected final String id = UUID.randomUUID().toString();
    protected String username;
    protected String fullname;
    protected String email;
    protected String password;
    protected String phonenumber;
    protected String adress;
    protected String cardnumber;
    protected Set<Order> orders;

    public User() {
    }

    public User(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.adress = adress;
        this.cardnumber = cardnumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", adress='" + adress + '\'' +
                ", orders=" + orders +
                '}';
    }

    public String getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    /*public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }*/
}

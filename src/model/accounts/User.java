package model.accounts;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class User{
    protected final String id = UUID.randomUUID().toString();
    protected String username;
    protected String fullname;
    protected String email;
    protected String password;
    protected String phonenumber;
    protected String address;
    protected String cardnumber;
    protected ArrayList<Order> orders;
//    protected Set<Order> orders;

    public User() {
        this.orders = new ArrayList<>();
    }

    public User(String username, String fullname, String email, String password, String phonenumber, String address, String cardnumber) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
        this.cardnumber = cardnumber;
        orders = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                //", orders=" + orders +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    /*public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }*/

    public void addOrder(Order order){
        System.out.println(this.orders);
        System.out.println(order);
        this.orders.add(order);
//        System.out.println(order);
//        System.out.println(this.orders);
//        System.out.println(orders.size());
    }
}

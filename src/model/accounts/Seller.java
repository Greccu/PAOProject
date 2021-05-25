package model.accounts;

import model.order.Order;
import model.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    private Restaurant restaurant;
    private List<Order> sales;

    public Seller(User user, Restaurant restaurant){
        super(user.username,user.fullName, user.email, user.password, user.phoneNumber, user.address,user.cardNumber,user.id);
        this.restaurant = restaurant;
    }

    public Seller(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.sales = new ArrayList<Order>();
    }

    public Seller(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Restaurant restaurant) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.restaurant = restaurant;
        this.sales = new ArrayList<Order>();
    }

    public Seller(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Restaurant restaurant, String id) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber, id);
        this.restaurant = restaurant;
        this.sales = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return "Seller{" +
                "restaurant=" + restaurant +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phoneNumber + '\'' +
                ", adress='" + address + '\'' +
                ", orders=" + orders +
                ", sales=" + sales +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getSales() {
        return sales;
    }
}

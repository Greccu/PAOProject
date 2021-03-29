package model.accounts;

import model.order.Order;
import model.restaurant.Restaurant;

import java.util.ArrayList;

public class Seller extends User{
    Restaurant restaurant;
    private ArrayList<Order> sales;

    public Seller(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.sales = new ArrayList<Order>();
    }

    public Seller(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Restaurant restaurant) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.restaurant = restaurant;
        this.sales = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return "Seller{" +
                "restaurant=" + restaurant +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
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

    public ArrayList<Order> getSales() {
        return sales;
    }
}

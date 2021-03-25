package model.accounts;

import model.restaurant.Restaurant;

public class Seller extends User{
    Restaurant restaurant;

    public Seller(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Seller(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Restaurant restaurant) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.restaurant = restaurant;
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
                ", adress='" + adress + '\'' +
                ", orders=" + orders +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

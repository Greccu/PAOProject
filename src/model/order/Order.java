package model.order;

import model.accounts.Driver;
import model.accounts.User;
import model.others.Pair;
import model.products.Product;
import model.restaurant.Restaurant;

import java.security.KeyPair;
import java.util.List;
import java.util.UUID;


public class Order {
    private final String id = UUID.randomUUID().toString();
    private User user;
    private Driver driver;
    private Restaurant restaurant;
    private List<Pair<Product,Integer>> products; // <product, quantity> // list always sorted by quantity

//        Product p = new Product();
//        Pair<Product,Integer> pp = new Pair<Product, Integer>(p,1);
//        products.add(pp);

    public Order(User user) {
        this.user = user;
    }

    public Order(User user, Driver driver, Restaurant restaurant) {
        this.user = user;
        this.driver = driver;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", driver=" + driver +
                ", restaurant=" + restaurant +
                ", products=" + products +
                '}';
    }

    public double getTotalPrice(){
        double total = 0;
        for (Pair<Product,Integer> p: products){
            total+= p.getSecond()*p.getFirst().getPrice();
        }
        return total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getId() {
        return id;
    }

    public List<Pair<Product, Integer>> getProducts() {
        return products;
    }

}

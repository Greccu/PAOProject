package model.order;

import model.accounts.Driver;
import model.accounts.User;
import model.others.Pair;
import model.products.Product;
import java.util.ArrayList;
import java.util.UUID;


public class Order {
    private final String id = UUID.randomUUID().toString();
    private String status = "created";
    private User user;
    private Driver driver;
    private ArrayList<Pair<Product,Integer>> products; // <product, quantity> // list always sorted by quantity

//        Product p = new Product();
//        Pair<Product,Integer> pp = new Pair<Product, Integer>(p,1);
//        products.add(pp);

    public Order(User user) {
        this.user = user;
        products = new ArrayList<Pair<Product,Integer>>();
    }

    public Order(User user, Driver driver) {
        this.user = user;
        this.driver = driver;
        products = new ArrayList<Pair<Product,Integer>>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", driver=" + driver +
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

    public String getId() {
        return id;
    }

    public ArrayList<Pair<Product, Integer>> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

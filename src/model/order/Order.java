package model.order;

import model.accounts.Driver;
import model.accounts.User;
import model.others.Pair;
import model.products.Product;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


public class Order {
    private final String id = UUID.randomUUID().toString();
    private String status = "created";
    private User user;
    private Driver driver;
    private LocalDateTime createDate;
    private ArrayList<Pair<Product,Integer>> products; // <product, quantity> // list always sorted by quantity

//        Product p = new Product();
//        Pair<Product,Integer> pp = new Pair<Product, Integer>(p,1);
//        products.add(pp);

    public Order(User user) {
        this.user = user;
        this.driver = null;
        this.products = new ArrayList<Pair<Product,Integer>>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.createDate = LocalDateTime.now();
    }

    public Order(User user, Driver driver) {
        this.user = user;
        this.driver = driver;
        products = new ArrayList<Pair<Product,Integer>>();
    }



    @Override
    public String toString() {
        String prod = new String();
        prod += "[";
        for (Pair<Product,Integer> p : products){
            prod+= "("+p.getFirst().getName() + " " + p.getSecond() + "),";
        }
        prod += "]";
        if (driver == null)
           return  "Order{" +
                "user=" + user.getFullName() +
                ", products=" + prod +
                ", createdate=" + createDate +
                '}';
        return "Order{" +
                "user = " + user.getFullName() +
                ", driver = " + driver.getFullName() +
                ", products = " + prod +
                ", createdate = " + createDate +
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void addProduct(Product product,int quantity){
        Integer q = quantity;
        Pair<Product,Integer> p = new Pair<>(product,q);
        products.add(p);
        Collections.sort(products);
//        products.sort(Comparable<Pair<Product,Integer>>);
    }
}

package model.app;

import model.accounts.Admin;
import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.order.Order;
import model.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    private static App instance = null;     //singleton instance

    private List<Restaurant> restaurants;
    private List<User> users;
    private List<Driver> drivers;
    private List<Seller> sellers;
    private List<Admin> admins;
    private List<Order> orders;

    public App() {
//        restaurants = new Set<Restaurant>();
//        users = new Set<User>(){};
        this.restaurants = new ArrayList<Restaurant>();
        this.users = new ArrayList<User>();
        this.drivers = new ArrayList<Driver>();
        this.sellers = new ArrayList<Seller>();
        this.admins = new ArrayList<Admin>();
        this.orders = new ArrayList<Order>();
        Admin admin = new Admin("admin", "Admin Admin", "admin@admin.ro", "admin", "0000000000", "Admin Adress", "0000 0000 0000 0000");
        addAdmin(admin);
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
        this.users.add(driver);
    }

    public void addSeller(Seller seller) {
        this.sellers.add(seller);
        this.users.add(seller);
    }

    public void addAdmin(Admin admin) {
        this.admins.add(admin);
        this.users.add(admin);
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }
}

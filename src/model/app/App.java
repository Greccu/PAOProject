package model.app;

import model.accounts.Admin;
import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.order.Order;
import model.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Set;

public class App {
    private static App instance = null;     //singleton instance

    private ArrayList<Restaurant> restaurants;
    private ArrayList<User> users;
    private ArrayList<Driver> drivers;
    private ArrayList<Seller> sellers;
    private ArrayList<Admin> admins;
    private ArrayList<Order> orders;

    public App() {
//        restaurants = new Set<Restaurant>();
//        users = new Set<User>(){};
        restaurants = new ArrayList<Restaurant>();
        users = new ArrayList<User>();
        drivers = new ArrayList<Driver>();
        sellers = new ArrayList<Seller>();
        admins = new ArrayList<Admin>();
        orders = new ArrayList<Order>();
        Admin admin = new Admin("admin","Admin Admin","admin@admin.ro","admin","0000000000","Admin Adress","0000 0000 0000 0000");
        addAdmin(admin);
    }

    public static App App(){
        if (instance == null){
            instance = new App();
        }
        return instance;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addDriver(Driver driver){
        drivers.add(driver);
        users.add(driver);
    }

    public void addSeller(Seller seller){
        sellers.add(seller);
        users.add(seller);
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
        users.add(admin);
    }


}

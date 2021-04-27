package service;

import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static OrderService instance = null;

    private OrderService(){}

    public static OrderService getInstance(){
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    private AuditService audit = AuditService.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public List<Order> getActiveOrders(App app){
        List<Order> activeOrders = new ArrayList<>();
        for(Order order : app.getOrders()){
            if(order.getStatus().equals("created")) {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    public void createOrder(App app, User user) {
        Order order = new Order(user);
        System.out.println("Order created");
        for (; ; ) {
            System.out.println("Select an option");
            System.out.println("1. Select restaurant");
            System.out.println("2. View restaurants");
            System.out.println("3. Finish order");
            System.out.println("0. Cancel Order");
            int option = scanner.nextInt();
            if (option == 0) {
                return;
            }
            if (option == 3) {
                break;
            }
            if (option == 2) {
                System.out.println("Available restaurants");
                for (Restaurant res : app.getRestaurants()) {
                    System.out.println(res.getName());
                }
                scanner.nextLine();
//                scanner.nextLine();
            } else if (option == 1) {
                System.out.println("Enter restaurant name");
                String sc = scanner.next();
                Restaurant restaurant = null;
                for (Restaurant res : app.getRestaurants()) {
                    if (res.getName().equalsIgnoreCase(sc)) {
                        restaurant = res;
                    }
                }
                if (restaurant == null) {
                    System.out.println("Restaurant doesn't exist");
                } else {
                    System.out.println("Restaurant " + restaurant.getName() + " selected");
                    for (; ; ) {
                        System.out.println("Select option");
                        System.out.println("1. View menu");
                        System.out.println("2. Add product to your order");
                        System.out.println("3. Back");
                        System.out.println("0. Cancel order");
                        int addoption = scanner.nextInt();
                        if (addoption == 0) {
                            return;
                        } else if (addoption == 1) {
                            System.out.println(restaurant.getMenu());
                        } else if (addoption == 3) {
                            break;
                        } else if (addoption != 2) {
                            System.out.println("Invalid option");
                        } else {
                            System.out.println("Enter product name");
                            String name = scanner.next();
                            Product product = null;
                            for (Product p : restaurant.getMenu()) {
                                if (p.getName().equalsIgnoreCase(name)){
                                    product = p;
                                }
                            }
                            if (product == null) {
                                System.out.println("This product doesn't exist");
                            } else {
                                System.out.println("Enter quantity");
                                int quantity = scanner.nextInt();
                                order.addProduct(product, quantity);
                            }
                        }
                    }
                }
            }
        }
        audit.write("Create order - "+user.getUsername());
        user.addOrder(order);
        app.addOrder(order);
    }

    public void displayOrders(App app, User user, Boolean active) {

        audit.write("Display Orders - "+user.getUsername());
        int count = 0;
        System.out.println(user.getOrders());
        for (Order order : user.getOrders()) {
            if (!active || order.getStatus().equals("created")) {
                System.out.println(order);
                count++;
            }
        }
        if (count == 0) {
            if(active)
                System.out.println("No active orders");
            else
                System.out.println("No orders");
        }
    }



}

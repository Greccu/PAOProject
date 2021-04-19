package service;

import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;

import java.util.Locale;
import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    public void Main(App app, User user) {
        System.out.println("\nLogged in as User");
        System.out.println(user);
        for (; ; ) {
            System.out.println("Select an option");
            System.out.println("1. Create order");
            System.out.println("2. Display current orders");
            System.out.println("3. Display all orders");
            System.out.println("4. Account settings");
            System.out.println("0. Exit");
            //            System.out.println("5. Change password");
//            System.out.println("5. Change email");
//            System.out.println("5. Change phone number");
            int option = scanner.nextInt();
            if (option == 0) {
                System.out.println("Exiting...");
                break;
            }
            switch (option) {
                case 1:
                    createOrder(app, user);
                    break;
                case 2:
                    displayOrders(app, user, true);
                    break;
                case 3:
                    displayOrders(app, user, false);
                    break;
                case 4:
                    accountSettings(app,user);
                    break;
                default:

                    break;
            }
        }
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
        user.addOrder(order);
        app.addOrder(order);
    }

    public void displayOrders(App app, User user, Boolean active) {
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

    public void accountSettings(App app, User user){
        for(;;){
            System.out.println("Select option");
            System.out.println("1. Show info");
            System.out.println("0. Back");
            int option = scanner.nextInt();
            switch (option){
                case 0:
                    return;
                case 1:
                    System.out.println(user);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

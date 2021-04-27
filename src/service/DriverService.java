package service;


import model.accounts.Driver;
import model.app.App;
//import model.products.Product;
import model.order.Order;
import model.restaurant.Restaurant;

import java.util.List;
import java.util.Scanner;

public class DriverService {
    private static DriverService instance = null;

    private DriverService(){}

    public static DriverService getInstance(){
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    private final Scanner scanner = new Scanner(System.in);
    //private final ProductService productService = new ProductService();
    private final OrderService orderService = OrderService.getInstance();
    private final AuditService audit = AuditService.getInstance();

    public void Main(App app, Driver driver) {
        System.out.println("\nLogged in as Driver");
        int option;
        for(;;){
            System.out.println("Select an option");
            System.out.println("1. Show Driver menu");
            System.out.println("2. Show User Menu");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if(option == 0){
                break;
            }else if(option == 2){
                UserService userService = UserService.getInstance();
                userService.Main(app, driver);
            }else if(option != 1){
                System.out.println("Invalid option");
            }else {
                for (; ; ) {

//                    scanner.
                    List<Order> activeOrders = orderService.getActiveOrders(app);
                    System.out.println(String.format("There are %o orders waiting for delivery", activeOrders.size()));
                    System.out.println("Select an option");
                    System.out.println("1. Show all available orders");
                    System.out.println("2. Select a order to deliver");
                    System.out.println("3. Show your past orders");
                    System.out.println("0. Exit");
                    option = scanner.nextInt();
                    if(option == 0){
                        break;
                    }
                    switch (option){
                        case 1 -> {
                            audit.write("Show Available Orders - "+driver.getUsername());
                            System.out.println("Available orders");
                            System.out.println();
                            for(int i = 0; i<activeOrders.size(); i++){
                                System.out.print(i+". ");
                                System.out.println(activeOrders.get(i));
                            }
                        }
                        case 2 -> {
                            audit.write("Deliver Order - "+driver.getUsername());
                            System.out.println("Enter order number");
                            int index = scanner.nextInt();
                            System.out.print("Order selected: ");
                            System.out.println(activeOrders.get(index));
                            System.out.println("Confirm? (Y/N) ");
                            scanner.nextLine();
                            String yn = scanner.nextLine();
                            if(yn.equalsIgnoreCase("Y")){
                                activeOrders.get(index).setStatus("delivering");
                                activeOrders.get(index).setDriver(driver);
                            }

                        }
                        case 3 -> {
                            audit.write("Show Order History - "+driver.getUsername());
                            System.out.println(driver.getDeliveries());
                        }
                    }
                }

            }
        }
    }
}


package service;

import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;

import java.util.Locale;
import java.util.Scanner;

public class UserService {
    private static UserService instance = null;

    private UserService(){}

    public static UserService getInstance(){
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public OrderService orderService = OrderService.getInstance();
    public AuditService audit = AuditService.getInstance();
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
                    orderService.createOrder(app, user);
                    break;
                case 2:
                    orderService.displayOrders(app, user, true);
                    break;
                case 3:
                    orderService.displayOrders(app, user, false);
                    break;
                case 4:
                    accountSettings(app,user);
                    break;
                default:

                    break;
            }
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

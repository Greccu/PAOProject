package service;

import model.accounts.Admin;
import model.accounts.User;
import model.app.App;

import java.util.Scanner;

public class AdminService {
    public void Main(App app, Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLogged in as Admin");
        System.out.println(admin);
        for(;;){
            System.out.println("Select an option");
            System.out.println("1. Show Admin menu");
            System.out.println("2. Show User Menu");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            if(option == 0){
                break;
            }else if(option == 2){
                UserService userService = new UserService();
                userService.Main(app,admin);
            }else if(option != 1){
                System.out.println("Invalid option");
            }else{
                for(;;){
                    System.out.println("Select an option");
                    System.out.println("1. Display all users");
                    System.out.println("2. Display all drivers");
                    System.out.println("3. Display all sellers");
                    System.out.println("4. Display all restaurants");
                    System.out.println("5. Display all orders");
                    System.out.println("0. Exit");
                    int option2 = scanner.nextInt();
                    if(option2==0){
                        System.out.println("Exiting...");
                        break;
                    }
                    switch (option2){
                        case 1:
                            System.out.println(app.getUsers());
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        case 2:
                            System.out.println(app.getDrivers());
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.println(app.getSellers());
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        case 4:
                            System.out.println(app.getRestaurants());
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.println(app.getOrders());
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                        default:
                            System.out.println("Invalid option");
                            scanner.nextLine();
                            scanner.nextLine();
                            break;
                    }
                }
            }
        }
    }
}

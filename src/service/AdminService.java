package service;

import model.accounts.Admin;
import model.app.App;

import java.util.Scanner;

public class AdminService {
    public void Main(App app, Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLogged in as Admin");
        System.out.println(admin);
        for(;;){
            System.out.println("Select an option");
            System.out.println("1. Display all users");
            System.out.println("2. Display all drivers");
            System.out.println("3. Display all sellers");
            System.out.println("4. Display all restaurants");
            System.out.println("5. Display all orders");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            if(option==0){
                System.out.println("Exiting...");
                break;
            }
            for (;;){

            }
        }
    }
}

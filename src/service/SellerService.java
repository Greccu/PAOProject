package service;


import model.accounts.Seller;
import model.accounts.User;
import model.app.App;
//import model.products.Product;
import model.products.Product;
import model.restaurant.Restaurant;

import java.util.Scanner;

public class SellerService {
    private static SellerService instance = null;

    private SellerService(){}

    public static SellerService getInstance(){
        if (instance == null) {
            instance = new SellerService();
        }
        return instance;
    }
    private final CSVWriter csvWriter = CSVWriter.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    ProductService productService = ProductService.getInstance();
    public void Main(App app, Seller seller) {
        System.out.println("\nLogged in as Seller");
        int option;
        for(;;){
            System.out.println("Select an option");
            System.out.println("1. Show Seller menu");
            System.out.println("2. Show User Menu");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if(option == 0){
                break;
            }else if(option == 2){
                UserService userService = UserService.getInstance();
                userService.Main(app,seller);
            }else if(option != 1){
                System.out.println("Invalid option");
            }else {
                for (; ; ) {
                    Restaurant restaurant = seller.getRestaurant();
                    System.out.println("Select an option");
                    System.out.println("1. Show resturant information");
                    System.out.println("2. Edit restaurant information");
                    System.out.println("3. Show menu");
                    System.out.println("4. Add product to the menu");
                    System.out.println("5. Delete product from the menu");
                    System.out.println("0. Exit App");
                    option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                    switch (option) {
                        case 1 -> System.out.println(restaurant);
                        case 2 -> {
                            System.out.println("Enter new Restaurant information (leaving it empty means it doesn't change)");
                            System.out.print("Enter restaurant name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter restaurant adress: ");
                            String adress = scanner.nextLine();
                            if (!name.equals("")) {
                                restaurant.setName(name);
                            }
                            if (!adress.equals("")) {
                                restaurant.setAdress(adress);
                            }
                        }
                        case 3 -> System.out.println(restaurant.getMenu());
                        case 4 -> {
                            Product product = productService.createProduct();
                            csvWriter.write(product);
                            restaurant.addProduct(product);
                        }
                        case 5 -> {
                            System.out.println("Enter product name");
                            String prodName = scanner.nextLine();
                            productService.removeProduct(seller, restaurant, prodName);
                        }
                        default -> System.out.println("Invalid option");
                    }

                }
            }
        }
    }

}

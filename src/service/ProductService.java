package service;

import model.accounts.Seller;
import model.products.Ingredient;
import model.products.Product;
import model.restaurant.Restaurant;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private static ProductService instance = null;

    private ProductService(){}

    public static ProductService getInstance(){
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    Scanner scanner = new Scanner(System.in);

    public Product createProduct() {
        System.out.println("Enter Product Information");
        System.out.println("Enter Product Name");
        String name = scanner.nextLine();
        System.out.println("Enter Product Price");
        double price = scanner.nextDouble();
        System.out.println("Enter ingredients list");
        List<String> ingredientList = new ArrayList<>();

        scanner.nextLine();
        for (; ; ) {
            System.out.println("Add another ingredient? Y/N");
            String op = scanner.nextLine();
            if (op.equals("Y")) {
                System.out.println("Enter ingredient name");
                String ingName = scanner.nextLine();
                ingredientList.add(ingName);
            } else {
                break;
            }
        }
        return new Product(name,ingredientList,price);
    }

    public void removeProduct(Seller seller, Restaurant restaurant, String productName){
        if(!seller.getRestaurant().getId().equals(restaurant.getId())){
            System.out.println("You can't do this");
            return;
        }
        Product sp;
        for(Product p : restaurant.getMenu()){
            if(p.getName().equalsIgnoreCase(productName)){
                sp = p;
                restaurant.getMenu().remove(sp);
                System.out.println("Product deleted!");
                return;
            }
        }
        System.out.println("Product not found!");

    }
}

package service;

import model.accounts.Seller;
import model.products.Product;
import model.restaurant.Restaurant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProductService {
    Scanner scanner = new Scanner(System.in);

    public Product createProduct() {
        System.out.println("Enter Product Information");
        System.out.println("Enter Product Name");
        String name = scanner.nextLine();
        System.out.println("Enter Product Price");
        double price = scanner.nextDouble();
        System.out.println("Enter ingredients list");
        for (; ; ) {
            System.out.println("Add another ingredient? Y/N");
            String op = scanner.next();
            if (op.equals("Y")) {
                System.out.println("Enter ingredient name");
                String ingName = scanner.nextLine();
                for (; ; ) {
                    try {
                        System.out.println("Enter expiry date(format = dd/mm/yyyy");
                        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(scanner.nextLine());
                        break;
                    } catch (java.text.ParseException e) {
                        System.out.println("Invalid date format");
                    }
                }
            } else {
                break;
            }
        }
        Product p = new Product();
        return p;
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

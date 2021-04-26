package service;

import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.products.Product;
import model.restaurant.Restaurant;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVWriter {

    private static CSVWriter instance = null;
    Map<String, Path> paths;

    private CSVWriter() {
        paths = new HashMap<>();
        paths.put("User", Path.of("files/users.csv"));
        paths.put("Driver", Path.of("files/drivers.csv"));
        paths.put("Seller", Path.of("files/sellers.csv"));
        //paths.put("Restaurant", Path.of("files/restaurants.csv"));
        paths.put("Products", Path.of("files/products.csv"));

        for (Path path : paths.values()) {
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }

    public static CSVWriter getInstance() {
        if (instance == null) {
            instance = new CSVWriter();
        }
        return instance;
    }

    public void write(User user) {
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("User"), StandardOpenOption.APPEND);
            String output = user.getId() + "," +
                    user.getUsername() + "," +
                    user.getFullName() + "," +
                    user.getEmail() + "," +
                    user.getPassword() + "," +
                    user.getPhoneNumber() + "," +
                    user.getAddress() + "," +
                    user.getCardNumber();
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Driver driver) {
        write((User) driver);
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Driver"), StandardOpenOption.APPEND);
            String output = driver.getId() + "," +
                    driver.getCar().getId() + "," +
                    driver.getCar().getBrand() + "," +
                    driver.getCar().getModel() + "," +
                    driver.getCar().getNumberPlate() + "," +
                    driver.getCar().getFabricationYear() + "," +
                    driver.getCar().getHorsePower() + ",";
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void write(Seller seller) {
        write((User) seller);
        try {
            System.out.println("Writing user");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Seller"), StandardOpenOption.APPEND);
            String menu = "";
            if(seller.getRestaurant().getMenu().size()>0) {
                for (Product product : seller.getRestaurant().getMenu()) {
                    menu += product.getId() + ";";
                }
                menu = menu.substring(0, menu.length() - 1);
            }
            String output = seller.getId() + "," +
                    seller.getRestaurant().getId() + "," +
                    seller.getRestaurant().getName() + "," +
                    seller.getRestaurant().getAdress() + "," +
                    menu;

            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void write(Product product) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(paths.get("Products"), StandardOpenOption.APPEND);
            String ingredients = "";
            if(product.getIngredients().size()>0){
                for (String ingredient : product.getIngredients()) {
                    ingredients += ingredient + ";";
                }
                ingredients = ingredients.substring(0, ingredients.length() - 1);
            }


            String output = product.getId() + "," +
                            product.getName() + "," +
                            product.getPrice() + "," +
                            ingredients
                    ;

            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

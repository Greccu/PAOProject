package service;

import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.app.App;
import model.others.Car;
import model.products.Ingredient;
import model.products.Product;
import model.restaurant.Restaurant;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    private static CSVReader instance = null;
    private Map<String, Path> paths;

    private CSVReader() {
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

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public void readAll(App app) {
        List<Restaurant> restaurants = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();
        List<Product> products = readProducts();
        ///
        List<List<String>> userInfo = getUserInfo();
        List<List<String>> driverInfo = getDriverInfo();
        List<List<String>> sellerInfo = getSellerInfo();
        if (!driverInfo.isEmpty()) {
            for (List<String> dInfo : driverInfo) {
                List<String> uInfo = new ArrayList<>();
                String id = dInfo.get(0);
                for (List<String> info : userInfo) {
                    if (info.get(0).equals(id)) {
                        uInfo = info;
                        userInfo.remove(info);
                        break;
                    }
                }

                String username = uInfo.get(1);
                String fullName = uInfo.get(2);
                String email = uInfo.get(3);
                String password = uInfo.get(4);
                String phonenumber = uInfo.get(5);
                String adress = uInfo.get(6);
                String cardNumber = uInfo.get(7);

                String carId = dInfo.get(1);
                String brand = dInfo.get(2);
                String model = dInfo.get(3);
                String numberPlate = dInfo.get(4);
                int fabricationYar = Integer.parseInt(dInfo.get(5));
                int horsePower = Integer.parseInt(dInfo.get(6));

                Car car = new Car(brand, model, numberPlate, fabricationYar, horsePower, carId);

                Driver driver = new Driver(username, fullName, email, password, phonenumber, adress, cardNumber, car, id);
                app.addDriver(driver);
            }
        }

        if (!sellerInfo.isEmpty()) {
            for (List<String> sInfo : sellerInfo) {
                List<String> uInfo = new ArrayList<>();
                String id = sInfo.get(0);
                for (List<String> info : userInfo) {
                    if (info.get(0).equals(id)) {
                        uInfo = info;
                        userInfo.remove(info);
                        break;
                    }
                }

                String username = uInfo.get(1);
                String fullName = uInfo.get(2);
                String email = uInfo.get(3);
                String password = uInfo.get(4);
                String phonenumber = uInfo.get(5);
                String adress = uInfo.get(6);
                String cardNumber = uInfo.get(7);

                String restaurantId = sInfo.get(1);
                String restaurantName = sInfo.get(2);
                String restaurantAdress = sInfo.get(3);
                String[] prods = sInfo.get(4).split(";");
                List<Product> menu = new ArrayList<>();
                for(String pid: prods){
                    for(Product prod: products){
                        if(prod.getId().equals(pid)){
                            menu.add(prod);
                            break;
                        }
                    }
                }

                Restaurant restaurant = new Restaurant(restaurantName,adress,restaurantId,menu);

                Seller seller = new Seller(username, fullName, email, password, phonenumber, adress, cardNumber, restaurant, id);
                app.addSeller(seller);

            }
        }
        if (!userInfo.isEmpty()) {
            for (List<String> uInfo : userInfo) {

                String id = uInfo.get(0);
                String username = uInfo.get(1);
                String fullName = uInfo.get(2);
                String email = uInfo.get(3);
                String password = uInfo.get(4);
                String phonenumber = uInfo.get(5);
                String adress = uInfo.get(6);
                String cardNumber = uInfo.get(7);

                User user = new User(username, fullName, email, password, phonenumber, adress, cardNumber, id);
                app.addUser(user);

            }
        }

    }

    private List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Products"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] prod = line.split(",");
                String id = prod[0];
                String name = prod[1];
                Double price = Double.parseDouble(prod[2]);
                List<String> ingredients = new ArrayList<String>(Arrays.asList(prod[3].split(";")));

                products.add(
                        new Product(name, ingredients, price, id)
                );
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return products;
        }
    }

    private List<List<String>> getUserInfo() {
        List<List<String>> users = new ArrayList<>();

        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Users"));
            String line = bufferedReader.readLine();
            while (line != null) {
                users.add(new ArrayList<String>(Arrays.asList(line.split(","))));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return users;
        }


    }

    private List<List<String>> getDriverInfo() {
        List<List<String>> drivers = new ArrayList<>();

        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Drivers"));
            String line = bufferedReader.readLine();
            while (line != null) {
                drivers.add(new ArrayList<String>(Arrays.asList(line.split(","))));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return drivers;
        }


    }

    private List<List<String>> getSellerInfo() {
        List<List<String>> sellers = new ArrayList<>();

        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Sellers"));
            String line = bufferedReader.readLine();
            while (line != null) {
                sellers.add(new ArrayList<String>(Arrays.asList(line.split(","))));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return sellers;
        }


    }


}

package main;

//import java.util.UUID;
import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.others.Car;
import model.products.Product;
import model.restaurant.Restaurant;
import repository.DriverRepository;
import repository.ProductRepository;
import repository.SellerRepository;
import repository.UserRepository;
import service.CSVReader;
import service.CSVWriter;
import service.LogInService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static DriverRepository driverRepository = DriverRepository.getInstance();
    private static ProductRepository productRepository = ProductRepository.getInstance();
    private static SellerRepository sellerRepository = SellerRepository.getInstance();
    private static UserRepository userRepository = UserRepository.getInstance();

    public static void main(String[] args) {

        App app = new App();
        LogInService logInService = LogInService.getInstance();
        //Seeder();
        GetContext(app);
        logInService.Main(app);
    }

    private static void Seeder(){

        ///////////////////////////////////////////////////////
        User user1 = new User(
                "elgreco",
                "Grecu Cristian",
                "email@email.com",
                "password",
                "0777777777",
                "adresa",
                "00045050430403"
        );
        userRepository.addUser(user1);
        ///////////////////////////////////////////////////////
        User user2 = new User(
                "driver",
                "Driver",
                "driver@email.com",
                "password",
                "0777777777",
                "adresa",
                "00045050430403"
        );

        Car car2 = new Car(
                "brand",
                "model",
                "numberplate",
                2000,
                360
        );

        Driver driver2 = new Driver(user2,car2);
        userRepository.addUser(user2);
        driverRepository.addDriver(driver2);
        ///////////////////////////////////////////////////////
        User user3 = new User(
                "seller",
                "Seller",
                "seller@email.com",
                "password",
                "0777777777",
                "adresa",
                "00045050430403");

        Restaurant restaurant3 = new Restaurant(
                "Restaurant1",
                "adresa 1"
        );

        Seller seller3 = new Seller(user3, restaurant3);

        userRepository.addUser(user3);
        sellerRepository.addSeller(seller3);
        //////////////////////////////////////////////////////////
        List<String> ing =  new ArrayList<String>();
        ing.add("ing1");
        ing.add("ing2");
        Product prod1 = new Product(
                "prod1",
                ing,
                20.2
        );
        Product prod2 = new Product(
                "prod2",
                ing,
                28.3
        );
        Product prod3 = new Product(
                "prod3",
                ing,
                30.7
        );

        productRepository.addProduct(prod1,restaurant3.getId());
        productRepository.addProduct(prod2,restaurant3.getId());
        productRepository.addProduct(prod3,restaurant3.getId());


    }

    private static void GetContext(App app){
        app.setDrivers(driverRepository.getDrivers());
        app.setSellers(sellerRepository.getSellers());
        app.setUsers(userRepository.getUsers());
        List<Restaurant> restaurants = new ArrayList<>();
        for (Seller seller:app.getSellers()) {
            restaurants.add(seller.getRestaurant());
        }
        app.setRestaurants(restaurants);
    }

}

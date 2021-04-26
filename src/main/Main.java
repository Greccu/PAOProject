package main;

//import java.util.UUID;
import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;
import service.CSVReader;
import service.CSVWriter;
import service.LogInService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("elgreco","Grecu Cristian","email@emai.com","password","0777777777","adresa","00045050430403");
//        System.out.println(user);
        App app = new App();
        app.addUser(user);
        Restaurant restaurant = new Restaurant("Restaurant1","adresa 1");
        List<String> ing =  new ArrayList<String>();
        ing.add("ing1");
        Product product1 = new Product("nume1",ing,1.01);
        ing.add("ing2");
        Product product2 = new Product("nume2",ing,1.02);
        restaurant.addProduct(product1);
        restaurant.addProduct(product2);
        app.addRestaurant(restaurant);

        Order order = new Order(user);
        order.addProduct(product1,1);
        order.addProduct(product2,3);
        user.addOrder(order);
        app.addOrder(order);
        LogInService logInService = LogInService.getInstance();
//        logInService.Main(app);
        CSVWriter csvWriter = CSVWriter.getInstance();
        csvWriter.write(user);
        csvWriter.write(product1);
        csvWriter.write(product2);
        CSVReader csvReader = CSVReader.getInstance();
        csvReader.readAll(app);
//        System.out.println("ok");
    }

}

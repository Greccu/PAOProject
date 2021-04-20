package main;

//import java.util.UUID;
import model.accounts.User;
import model.app.App;
import model.order.Order;
import model.products.Product;
import model.restaurant.Restaurant;
import service.LogInService;

public class Main {
    public static void main(String[] args) {
        User user = new User("elgreco","Grecu Cristian","email@emai.com","password","0777777777","adresa","00045050430403");
//        System.out.println(user);
        App app = new App();
        app.addUser(user);
        Restaurant restaurant = new Restaurant("Restaurant1","adresa 1");
        Product product1 = new Product("nume1",1.01);
        Product product2 = new Product("nume2",1.02);
        restaurant.addProduct(product1);
        restaurant.addProduct(product2);
        app.addRestaurant(restaurant);

        Order order = new Order(user);
        order.addProduct(product1,1);
        order.addProduct(product2,3);
        user.addOrder(order);
        app.addOrder(order);
        LogInService logInService = new LogInService();
        logInService.Main(app);
//        System.out.println("ok");
    }
}

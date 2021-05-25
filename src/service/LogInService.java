package service;

import model.accounts.Admin;
import model.accounts.Driver;
import model.accounts.Seller;
import model.accounts.User;
import model.app.App;
import model.others.Car;
import model.restaurant.Restaurant;
import repository.DriverRepository;
import repository.ProductRepository;
import repository.SellerRepository;
import repository.UserRepository;

import java.util.Scanner;

public class LogInService {
    private static LogInService instance = null;

    private LogInService(){}

    public static LogInService getInstance(){
        if (instance == null) {
            instance = new LogInService();
        }
        return instance;
    }

    private final Scanner scanner = new Scanner(System.in);
    //private final CSVWriter csvWriter = CSVWriter.getInstance();
    private final AuditService audit = AuditService.getInstance();
    private static DriverRepository driverRepository = DriverRepository.getInstance();
    private static SellerRepository sellerRepository = SellerRepository.getInstance();
    private static UserRepository userRepository = UserRepository.getInstance();

    public void Main(App app) {

        int option;
        for (; ; ) {
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
            System.out.println("Select an option");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("0. Exit App");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for (; ; ) {
                        System.out.println("Username");
                        String username = scanner.next();
                        System.out.println("Password");
                        String password = scanner.next();
                        User user = login(username, password, app);
                        if (user == null) {
                            System.out.println("Invalid credentials");
                            System.out.println("1. Try again");
                            System.out.println("2. Back");
                            int option2 = scanner.nextInt();
                            if (option2 == 2){
                                break;
                            }else if(option2 != 1){
                                System.out.println("Invalid optin - going back...");
                                break;
                            }

                        } else {
                            audit.write("Login - "+user.getUsername());
                            if (user instanceof Admin) {
//                            System.out.println("Logged in as Admin");
                                //admin service
                                AdminService adminService = AdminService.getInstance();
                                adminService.Main(app, (Admin)user);
                                break;
                            } else if (user instanceof Driver) {
//                            System.out.println("Logged in as Driver");
                                //driver service
                                DriverService driverService = DriverService.getInstance();
                                driverService.Main(app, (Driver)user);
                                break;
                            } else if (user instanceof Seller) {
//                            System.out.println("Logged in as Seller");
                                //seller service
                                SellerService sellerService = SellerService.getInstance();
                                sellerService.Main(app, (Seller)user);
                                break;
                            } else {
//                            System.out.println("Logged in as Normal User");
                                UserService userService = UserService.getInstance();
                                userService.Main(app, user);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    int option2;
                    System.out.println("1. Sign up as a normal user");
                    System.out.println("2. Sign up as a driver");
                    System.out.println("3. Sign up as a seller");
                    System.out.println("0. Back");
                    option2 = scanner.nextInt();
                    if (option2 >= 1 && option2 <= 3) {
                        signup(option2, app);
                    }

            }
        }
    }

    private User login(String username, String password, App app) {
        for (User user : app.getUsers()) {
//            System.out.println(user.getUsername()+" "+username + " - "+ user.getPassword() + " " + password);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void signup(int type, App app) {
        System.out.println("Username");
        String username = scanner.next();
        System.out.println("Password");
        String password = scanner.next();
        System.out.println("Full Name");
        String fullname = scanner.next();
        System.out.println("Email");
        String email = scanner.next();
        System.out.println("Phone number");
        String phonenumber = scanner.next();
        System.out.println("Address");
        String address = scanner.next();
        System.out.println("Card Number");
        String cardnumber = scanner.next();

        switch (type) {
//user
            case 1 -> {
                System.out.println("creating user");
                User user = new User(username, fullname, email, password, phonenumber, address, cardnumber);
                app.addUser(user);
                //csvWriter.write(user);
                userRepository.addUser(user);
                audit.write("SignUp - "+user.getUsername());
            }
//driver
            case 2 -> {
                System.out.println("Enter your car information");
                System.out.println("Brand");
                String brand = scanner.next();
                System.out.println("Model");
                String model = scanner.next();
                System.out.println("NumberPlate");
                String numberplate = scanner.next();
                System.out.println("Fabrication Year");
                int fabricationyear = scanner.nextInt();
                System.out.println("Horse Power");
                int horsepower = scanner.nextInt();
                Car car = new Car(brand, model, numberplate, fabricationyear, horsepower);
                Driver driver = new Driver(username, fullname, email, password, phonenumber, address, cardnumber, car);
                app.addDriver(driver);
                userRepository.addUser(driver);
                driverRepository.addDriver(driver);
                audit.write("SignUp "+driver.getUsername());
            }
//seller
            case 3 -> {
                System.out.println("Enter your restaurant information");
                System.out.println("Name");
                String name = scanner.next();
                System.out.println("Address");
                String raddress = scanner.next();
                Restaurant restaurant = new Restaurant(name, raddress);
                Seller seller = new Seller(username, fullname, email, password, phonenumber, address, cardnumber, restaurant);
                app.addSeller(seller);
                userRepository.addUser(seller);
                sellerRepository.addSeller(seller);
                audit.write("SignUp "+seller.getUsername());
            }
        }
    }


}

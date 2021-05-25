package model.accounts;

import model.others.Car;
import model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User{
    private Car car;
    private List<Order> deliveries;

    public Driver(User user, Car car){
        super(user.username,user.fullName, user.email, user.password, user.phoneNumber, user.address,user.cardNumber,user.id);
        this.car = car;
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.deliveries = new ArrayList<Order>();
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Car car) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.car = car;
        this.deliveries = new ArrayList<Order>();
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Car car, String id) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber, id);
        this.car = car;
        this.deliveries = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                ", deliveries=" + deliveries +
                ", username='" + username + '\'' +
                ", fullname='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phoneNumber + '\'' +
                ", adress='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Order> getDeliveries() {
        return deliveries;
    }

}

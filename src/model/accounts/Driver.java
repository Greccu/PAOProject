package model.accounts;

import model.others.Car;
import model.order.Order;
import java.util.Set;

public class Driver extends User{
    private Car car;
    private Set<Order> deliveries;

    public Driver() {
    }

    public Driver(Car car) {
        this.car = car;
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Car car) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                ", deliveries=" + deliveries +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", adress='" + adress + '\'' +
                ", orders=" + orders +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Order> getDeliveries() {
        return deliveries;
    }

}

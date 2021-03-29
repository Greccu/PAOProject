package model.accounts;

import model.others.Car;
import model.order.Order;

import java.util.ArrayList;

public class Driver extends User{
    private Car car;
    private ArrayList<Order> deliveries;

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.deliveries = new ArrayList<Order>();
    }

    public Driver(String username, String fullname, String email, String password, String phonenumber, String adress, String cardnumber, Car car) {
        super(username, fullname, email, password, phonenumber, adress, cardnumber);
        this.car = car;
        this.deliveries = new ArrayList<Order>();
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

    public ArrayList<Order> getDeliveries() {
        return deliveries;
    }

}

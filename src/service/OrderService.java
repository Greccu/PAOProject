package service;

import model.app.App;
import model.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static OrderService instance = null;

    private OrderService(){}

    public static OrderService getInstance(){
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    private Scanner scanner = new Scanner(System.in);

    public List<Order> getActiveOrders(App app){
        List<Order> activeOrders = new ArrayList<>();
        for(Order order : app.getOrders()){
            if(order.getStatus().equals("created")) {
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }


}

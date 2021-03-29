package model.restaurant;

import model.products.Product;

import java.util.ArrayList;
import java.util.UUID;

public class Restaurant {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String adress;
    private ArrayList<Product> menu;

    public Restaurant() {
        menu = new ArrayList<Product>();
    }

    public Restaurant(String name, String adress) {
        this.name = name;
        this.adress = adress;
        menu = new ArrayList<Product>();
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ArrayList<Product> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Product> menu) {
        this.menu = menu;
    }

    public void addProduct(Product product){
        this.menu.add(product);
    }
}

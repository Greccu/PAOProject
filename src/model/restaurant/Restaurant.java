package model.restaurant;

import model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private String id;
    private String name;
    private String adress;
    private List<Product> menu;

    public Restaurant() {
        menu = new ArrayList<Product>();
    }

    public Restaurant(String name, String adress) {
        this.name = name;
        this.adress = adress;
        menu = new ArrayList<Product>();
        this.id = UUID.randomUUID().toString();
    }

    public Restaurant(String name, String adress, String id) {
        this.name = name;
        this.adress = adress;
        menu = new ArrayList<Product>();
        this.id = id;
    }

    public Restaurant(String name, String adress, String id, List<Product> menu) {
        this.name = name;
        this.adress = adress;
        this.menu = menu;
        this.id = id;
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

    public List<Product> getMenu() {
        return menu;
    }

    public void setMenu(List<Product> menu) {
        this.menu = menu;
    }

    public void addProduct(Product product){
        this.menu.add(product);
    }
}

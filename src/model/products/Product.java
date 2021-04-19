package model.products;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Product {
    private final String id = UUID.randomUUID().toString();
    private String name;
    List<Ingredient> ingredients;
    private double price;

    public  Product(){
        ingredients = new ArrayList<Ingredient>();
    }
    public Product(String name, ArrayList<Ingredient> ingredients, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Name= " + name + ' ' +
                "Ingredients= " + ingredients + ' '+
                "Price= " + price;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

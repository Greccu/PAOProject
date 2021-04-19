package model.products;

import java.util.Date;
import java.util.UUID;

public class Ingredient {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private Date expiryDate;

    public Ingredient(String name, Date expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", expirydate=" + expiryDate +
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}

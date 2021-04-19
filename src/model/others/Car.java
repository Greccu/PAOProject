package model.others;

import java.util.UUID;

public class Car {
    private final String id = UUID.randomUUID().toString();
    private String brand;
    private String model;
    private String numberPlate;
    private int fabricationYear;
    private int horsePower;



    public Car() {
    }

    public Car(String brand, String model, String numberPlate, int fabricationYear, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.numberPlate = numberPlate;
        this.fabricationYear = fabricationYear;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", fabricationYear=" + fabricationYear +
                ", horsePower=" + horsePower +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}

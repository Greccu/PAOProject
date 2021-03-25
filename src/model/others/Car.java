package model.others;

import java.util.UUID;

public class Car {
    private final String id = UUID.randomUUID().toString();
    private String brand;
    private String model;
    private String numberplate;
    private int fabricationyear;
    private int horsepower;



    public Car() {
    }

    public Car(String brand, String model, String numberplate, int fabricationyear, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.numberplate = numberplate;
        this.fabricationyear = fabricationyear;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", numberplate='" + numberplate + '\'' +
                ", fabricationyear=" + fabricationyear +
                ", horsepower=" + horsepower +
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

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public int getFabricationyear() {
        return fabricationyear;
    }

    public void setFabricationyear(int fabricationyear) {
        this.fabricationyear = fabricationyear;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}

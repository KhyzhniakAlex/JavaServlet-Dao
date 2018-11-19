package Entities.Models;

public class CarModel {
    private int id;
    private String brand;
    private String model;
    private int prise;
    private String color;

    public CarModel(int id, String brand, String model, int prise, String color)
    {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.prise = prise;
        this.color = color;
    }

    public CarModel()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj)
    {
        CarModel car = (CarModel)obj;
        return id == car.id && brand.equals(car.brand) && model.equals(car.model) && prise == car.prise && color.equals(car.color);
    }
}

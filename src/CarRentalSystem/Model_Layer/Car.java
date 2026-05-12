package CarRentalSystem.Model_Layer;


public abstract class Car {

    private String carID;
    private String brand;
    private String model;
    private String category;
    private double basePricePerDay;
    private boolean available;

    public Car(String carID,
               String brand,
               String model,
               String category,
               double basePricePerDay,
               boolean available) {

        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.basePricePerDay = basePricePerDay;
        this.available = available;
    }

    public String getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }

    public abstract double totalPrice(int days);
}
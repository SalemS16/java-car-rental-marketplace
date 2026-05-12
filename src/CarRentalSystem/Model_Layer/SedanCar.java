package CarRentalSystem.Model_Layer;

public class SedanCar extends Car {

    public SedanCar(String carID,
                    String brand,
                    String model,
                    String category,
                    double basePricePerDay,
                    boolean available) {

        super(carID, brand, model, category, basePricePerDay, available);
    }

    @Override
    public double totalPrice(int days) {

        return getBasePricePerDay() * days;
    }
}
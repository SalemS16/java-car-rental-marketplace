package CarRentalSystem.Model_Layer;

public class LuxuryCar extends Car {

    public LuxuryCar(String carID,
                     String brand,
                     String model,
                     String category,
                     double basePricePerDay,
                     boolean available) {

        super(carID, brand, model, category, basePricePerDay, available);
    }

    @Override
    public double totalPrice(int days) {

        double price = getBasePricePerDay() * days;

        double luxuryTax = price * 0.20;

        return price + luxuryTax + 2000;
    }
}
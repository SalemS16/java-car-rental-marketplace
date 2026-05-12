package CarRentalSystem.Model_Layer;

import java.time.LocalDate;

public class Rental {

    private int rentalID;
    private Car car;
    private Customer customer;
    private int days;
    private double totalPrice;
    private LocalDate rentalDate;

    public Rental(int rentalID,
                  Car car,
                  Customer customer,
                  int days,
                  double totalPrice,
                  LocalDate rentalDate) {

        this.rentalID = rentalID;
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalPrice = totalPrice;
        this.rentalDate = rentalDate;
    }

    public int getRentalID() {
        return rentalID;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }
}
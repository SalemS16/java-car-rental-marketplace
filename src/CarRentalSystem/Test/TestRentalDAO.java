package CarRentalSystem.Test;

import CarRentalSystem.DAO_Layer.RentalDAO;

public class TestRentalDAO {

    public static void main(String[] args) {

        RentalDAO dao =
                new RentalDAO();


        // ===== TEST RENT CAR =====

        dao.rentCar(

                "CAR001",     // Car ID

                "CUS001",     // Customer ID

                5,            // Days

                15000         // Total Price

        );


        System.out.println(
                "Rental Added Successfully!"
        );



        // ===== TEST RETURN CAR =====
        /*
        dao.returnCar(

                1,            // Rental ID

                "CAR001"      // Car ID

        );

        System.out.println(
                "Car Returned Successfully!"
        );
        */

    }

}
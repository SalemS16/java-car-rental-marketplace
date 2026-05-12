package CarRentalSystem.Test;

import CarRentalSystem.DAO_Layer.CarDAO;

public class TestCarDAO {

    public static void main(String[] args) {

        CarDAO dao = new CarDAO();


        dao.addCar(
                "Toyota",
                "Fortuner",
                "SUV",
                3500,
                "Pune",
                "CUS001"
        );


        System.out.println(
                "Car Added Successfully!"
        );

    }

}